package com.coffefreaks.timberwalle.model.Request;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.*;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.function.Supplier;

/**
 * This will add an application-wide customization to the original RestTemplate instances.
 * The purpose of this class is to add an SSL certificate to every request performed by the Spring client.
 */
public class SecuredRestTemplateCustomizer implements RestTemplateCustomizer {

    @Value("${http.client.ssl.key-store}")
    private String keyStoreFile;
    @Value("${http.client.ssl.key-store-password}")
    private char[] keyStorePassword;
    @Value("${http.client.ssl.trust-store}")
    private String trustStoreFile;
    @Value("${http.client.ssl.trust-store-password}")
    private char[] trustStorePassword;

    /**
     * Called on instantiation of every RestTemplate object.
     * @param restTemplate the original RestTemplate object
     */
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.setRequestFactory(new ClientHttpRequestFactorySupplier(
                keyStore(keyStoreFile, keyStorePassword),
                keyStorePassword,
                keyStore(trustStoreFile, trustStorePassword),
                trustStorePassword
        ).get());
    }

    /**
     * This method builds a KeyStore object from a given file and a password.
     * @param file file to be read
     * @param password password used to decrypt the key store
     * @return the key store object
     */
    private KeyStore keyStore(String file, char[] password) {
        KeyStore keyStore = null;
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        try {
            File key = ResourceUtils.getFile(file);
            try (InputStream in = new FileInputStream(key)) {
                if (keyStore != null) {
                    keyStore.load(in, password);
                }
            } catch (IOException | CertificateException | NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return keyStore;
    }

    static class ClientHttpRequestFactorySupplier implements Supplier<ClientHttpRequestFactory> {

        private final KeyStore trustStore;
        private final char[] trustStorePassword;

        private final KeyStore keyStore;
        private final char[] password;

        public ClientHttpRequestFactorySupplier(KeyStore keyStore, char[] keyStorePassword, KeyStore trustStore, char[] trustStorePassword) {
            super();

            this.keyStore = keyStore;
            this.password = keyStorePassword;
            this.trustStore = trustStore;
            this.trustStorePassword = trustStorePassword;
        }

        @Override
        public ClientHttpRequestFactory get() {
            SSLContext sslContext = null;
            try {
                sslContext = SSLContextBuilder
                        .create()
                        .loadKeyMaterial(keyStore, password)
                        .loadTrustMaterial(trustStore, new TrustSelfSignedStrategy())
                        .build();
            } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException | UnrecoverableKeyException e) {
                e.printStackTrace(); // TODO make decision
            }

            HttpClient client = HttpClients
                    .custom()
                    .setSSLContext(sslContext)
                    .build()
            ;

            return new HttpComponentsClientHttpRequestFactory(client);
        }
    }
}
