package com.coffefreaks.timberwallee.service;

import com.coffefreaks.timberwallee.model.Enum.EngineStatus;
import com.coffefreaks.timberwallee.model.Location;
import com.coffefreaks.timberwallee.service.Interface.RobiotService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
@Import(RobiotServiceImpl.class)
class RobiotServiceImplTest {

    @Autowired
    private RobiotService service;
    private final static Logger logger = LoggerFactory.getLogger(RobiotServiceImplTest.class);

    @Test
    @DisplayName("IntegrationTest - Retrieve Robiot Location successfully")
    void whenExternalApiIsRunning_getLocationWithSuccess() {
        /* Need robiot-api running and configured on application.properties in test/resources
        *  More tests with mock client needed to tests errors
        **/

        Location loc = service.getCurrentLocation();

        logger.info("getlocation - {}", loc);
        Assertions.assertNotNull(loc, "Location not null");
        Assertions.assertNotNull(loc.getPositionX(), "positionX not null");
        Assertions.assertNotNull(loc.getPositionY(), "positionY not null");
    }

    @Test
    @DisplayName("IntegrationTest - Retrieve Robiot engine status successfully")
    void whenExternalApiIsRunning_getEngineStatusWithSuccess() {
        /* Need robiot-api running and configured on application.properties in test/resources
         *  More tests with mock client needed to tests errors
         **/

        EngineStatus status = service.getEngineStatus();

        logger.info("getEngineStatus - {}", status);
        Assertions.assertNotNull(status, "Location not null");
        Assertions.assertSame(EngineStatus.STOPPED, status);
    }

    @Test
    @Disabled("Not implemented yet")
    void move() {
    }
}