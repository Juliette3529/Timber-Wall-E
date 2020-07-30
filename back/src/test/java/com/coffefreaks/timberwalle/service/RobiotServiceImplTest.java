package com.coffefreaks.timberwalle.service;

import com.coffefreaks.timberwalle.model.Enum.EngineStatus;
import com.coffefreaks.timberwalle.model.Location;
import com.coffefreaks.timberwalle.service.Interface.RobiotService;
import org.junit.jupiter.api.Assertions;
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

        logger.info("Test - getlocation - {}", loc);
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

        logger.info("Test - getEngineStatus - {}", status);
        Assertions.assertNotNull(status, "Location not null");
        Assertions.assertSame(EngineStatus.STOPPED, status);
    }

    @Test
    @DisplayName("IntegrationTest - Retrieve Robiot battery use successfully")
    void whenExternalApiIsRunning_getBatteryUsageWithSuccess() {
        /* Need robiot-api running and configured on application.properties in test/resources
         *  More tests with mock client needed to tests errors
         **/

        double usage = service.getBatteryUsage();

        logger.info("Test - getBatteryUsage - {}", usage);
        Assertions.assertTrue(usage >= 0);
    }

    @Test
    @DisplayName("IntegrationTest - Move Robiot successfully")
    void whenExternalApiIsRunning_moveWithSuccess() {
        /* Need robiot-api running and configured on application.properties in test/resources
         *  More tests with mock client needed to tests errors
         **/

        Location dest = new Location();
        dest.setPositionX(5.0);
        dest.setPositionY(0.0);
        boolean result = service.move(dest);
        logger.info("test move = {}", result);

        dest.setPositionX(0.0);
        service.move(dest);
        Assertions.assertTrue(result);
    }
}