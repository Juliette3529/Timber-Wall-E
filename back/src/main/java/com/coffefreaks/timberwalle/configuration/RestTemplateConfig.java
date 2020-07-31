package com.coffefreaks.timberwalle.configuration;

import com.coffefreaks.timberwalle.model.request.SecuredRestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration file that replaces RestTemplate objects instanced via Spring injection
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public SecuredRestTemplateCustomizer securedRestTemplateCustomizer() {
        return new SecuredRestTemplateCustomizer();
    }
}
