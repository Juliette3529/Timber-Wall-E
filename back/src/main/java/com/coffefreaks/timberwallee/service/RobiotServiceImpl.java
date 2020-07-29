package com.coffefreaks.timberwallee.service;

import com.coffefreaks.timberwallee.exception.TimberResourceNotFoundException;
import com.coffefreaks.timberwallee.model.Enum.Direction;
import com.coffefreaks.timberwallee.model.Enum.EngineStatus;
import com.coffefreaks.timberwallee.model.Location;
import com.coffefreaks.timberwallee.model.Response.RobiotResponse;
import com.coffefreaks.timberwallee.service.Interface.RobiotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public boolean move(Direction direction) {
        //TODO to implemented
        return false;
    }
}
