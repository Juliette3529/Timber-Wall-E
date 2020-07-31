package com.coffefreaks.timberwalle.service;

import com.coffefreaks.timberwalle.exception.TimberResourceNotFoundException;
import com.coffefreaks.timberwalle.model.Location;
import com.coffefreaks.timberwalle.model.enumerations.EngineStatus;
import com.coffefreaks.timberwalle.model.enumerations.MeasureStatus;
import com.coffefreaks.timberwalle.model.request.RobiotRequest;
import com.coffefreaks.timberwalle.model.response.RobiotResponse;
import com.coffefreaks.timberwalle.service.interfaces.RobiotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class RobiotServiceImpl implements RobiotService {
    private static final Logger logger = LoggerFactory.getLogger(RobiotServiceImpl.class);

    private RestTemplate clientRobiot;

    @Autowired
    public RobiotServiceImpl(RestTemplateBuilder builder) {
        super();

        clientRobiot = builder.build();
    }

    @Value(value = "${robiot.endpoint.url}")
    private String robiotEndpoint;

    @Override
    public Location getCurrentLocation() {
        String url = robiotEndpoint + "/301";
        logger.trace("getLocation - url = {}", url);
        Location loc = new Location();

        ResponseEntity<RobiotResponse> response = clientRobiot.getForEntity(url, RobiotResponse.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            // Test the format of the return content, must be "double,double" format
            if (!response.getBody().getContent().matches("^[0-9]+\\.[0-9]+,[0-9]+.[0-9]+$")) {
                logger.error("getLocation - Error with body.content = {}", response.getBody().getContent());
                throw new TimberResourceNotFoundException("Invalid content for Location");
            }
            String[] content = response.getBody().getContent().split(",");
            loc.setPositionX(Double.parseDouble(content[0]));
            loc.setPositionY(Double.parseDouble(content[1]));
        } else {
            logger.error("getLocation - Error {} while retrieving current location - {}", response.getStatusCode(), response.getBody());
            throw new TimberResourceNotFoundException("Robiot-API error on id 301");
        }
        return loc;
    }

    @Override
    public EngineStatus getEngineStatus() {
        String url = robiotEndpoint + "/201";
        logger.trace("getEngineStatus - url = {}", url);
        EngineStatus status;

        ResponseEntity<RobiotResponse> response = clientRobiot.getForEntity(url, RobiotResponse.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            status = EngineStatus.valueOfLabel(response.getBody().getContent());
            logger.trace("getEngineStatus - Enum status={} and response.content={}", status, response.getBody().getContent());
        } else {
            logger.error("getEngineStatus - Error {} while retrieving robiot engine status - {}", response.getStatusCode(), response.getBody());
            throw new TimberResourceNotFoundException("Robiot-API error on id 201");
        }
        return status;
    }

    @Override
    public boolean move(Location dest) {
        boolean result = false;
        String url = robiotEndpoint + "/302";
        logger.trace("move - url = {}", url);

        while(getEngineStatus().equals(EngineStatus.MOVING)) {
            try {
                logger.info("move - waiting for Robiot to finish moving");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("move - Thread error - {}", e.getMessage());
                Thread.currentThread().interrupt();
                return false;
            }
        }
        RobiotRequest request = new RobiotRequest(302,
                            String.format(Locale.ROOT, "%1$.2f,%2$.2f", dest.getPositionX(), dest.getPositionY()));
        HttpEntity<RobiotRequest> entity = new HttpEntity<>(request);

        ResponseEntity<RobiotResponse> response = clientRobiot.exchange(url, HttpMethod.PUT,
                                        entity, RobiotResponse.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            result = true;
        } else {
            logger.error("move - Error {} in trying to move", response.getStatusCode());
        }

        return result;
    }

    @Override
    public double getBatteryUsage() {
        String url = robiotEndpoint + "/101";
        logger.trace("getBatteryUsage - url = {}", url);
        double result = Double.MIN_VALUE;

        while(getEngineStatus().equals(EngineStatus.MOVING) || !getMesureStatus().equals(MeasureStatus.READY)) {
            try {
                logger.info("getBatteryUsage - waiting for Robiot to finish its job");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("getBatteryUsage - Thread error - {}", e.getMessage());
                Thread.currentThread().interrupt();
                throw new TimberResourceNotFoundException("Internal server error");
            }
        }
        ResponseEntity<RobiotResponse> response = clientRobiot.getForEntity(url, RobiotResponse.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            result = Double.parseDouble(response.getBody().getContent());
        } else {
            logger.error("getBatteryUsage - Error {} while retrieving robiot battery", response.getStatusCode());
        }

        return result;
    }

    //TODO  not useful ? prefering measureStatus
    // return 18000 by default
    private double getRemainingMesureTime() {
        String url = robiotEndpoint + "/402";
        logger.trace("getRemainingMesureTime - url = {}", url);
        double result = Double.MIN_VALUE;

        ResponseEntity<RobiotResponse> response = clientRobiot.getForEntity(url, RobiotResponse.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            result = Double.parseDouble(response.getBody().getContent());
        } else {
            logger.error("getRemainingMesureTime - Error {} while retrieving robiot mesure time", response.getStatusCode());
        }

        return result;
    }

    private MeasureStatus getMesureStatus() {
        String url = robiotEndpoint + "/401";
        logger.trace("getMesure - url = {}", url);
        MeasureStatus status;

        ResponseEntity<RobiotResponse> response = clientRobiot.getForEntity(url, RobiotResponse.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            status = MeasureStatus.valueOf(response.getBody().getContent());
            logger.trace("getMesureStatus - Enum status={} and response.content={}", status, response.getBody().getContent());
        } else {
            logger.error("getMesureStatus - Error {} while retrieving robiot battery status - {}", response.getStatusCode(), response.getBody());
            throw new TimberResourceNotFoundException("Robiot-API error on id 401");
        }
        return status;
    }
}
