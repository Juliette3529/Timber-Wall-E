package com.coffefreaks.timberwalle.service;

import com.coffefreaks.timberwalle.exception.TimberResourceNotFoundException;
import com.coffefreaks.timberwalle.model.Enum.EngineStatus;
import com.coffefreaks.timberwalle.model.Location;
import com.coffefreaks.timberwalle.model.Request.RobiotRequest;
import com.coffefreaks.timberwalle.model.Response.RobiotResponse;
import com.coffefreaks.timberwalle.service.Interface.RobiotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class RobiotServiceImpl implements RobiotService {
    private RestTemplate clientRobiot = new RestTemplate();
    private final static Logger logger = LoggerFactory.getLogger(RobiotServiceImpl.class);


    @Value(value = "${robiot.endpoint.url}")
    private String robiotEndpoint;

    @Override
    public Location getCurrentLocation() {
        String url = robiotEndpoint + "/301";
        logger.trace("getLocation - url = {}", url);
        ResponseEntity<RobiotResponse> response = clientRobiot.getForEntity(url, RobiotResponse.class);

        Location loc = new Location();
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
        ResponseEntity<RobiotResponse> response = clientRobiot.getForEntity(url, RobiotResponse.class);

        EngineStatus status;
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
        while(getEngineStatus().equals(EngineStatus.MOVING)) {
            try {
                logger.info("move - waiting for Robiot to finish moving");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                logger.error("move - Thread error - {}", e.getMessage());
                return false;
            }
        }
        RobiotRequest request = new RobiotRequest(302,
                            String.format(Locale.ROOT, "%1$.2f,%2$.2f", dest.getPositionX(), dest.getPositionY()));
        String url = robiotEndpoint + "/302";
        logger.trace("move - url = {}", url);
        HttpEntity<RobiotRequest> entity = new HttpEntity<>(request);

        boolean result = false;
        ResponseEntity<RobiotResponse> response = clientRobiot.exchange(url, HttpMethod.PUT,
                                        entity, RobiotResponse.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            result = true;
        } else {
            logger.error("move - Error {} in trying to move", response.getStatusCode());
        }

        return result;
    }
}
