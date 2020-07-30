package com.coffefreaks.timberwallee.service.Interface;

import com.coffefreaks.timberwallee.model.Enum.EngineStatus;
import com.coffefreaks.timberwallee.model.Location;

public interface RobiotService {

    /**
     * Contact the Robiot API to get its current location
     * @return a location
     */
    Location getCurrentLocation();

    /**
     * Contact the Robiot API to get its engine's status
     * @return the engine status
     */
    EngineStatus getEngineStatus();

    /**
     * Move the robot to the specified destination
     *
     * @param dest a new final Location
     * @return true if moving is a success, false otherwise
     */
    boolean move(Location dest);

    /**
     * Contact the Robiot API to get its battery consumption since started
     *  will wait for the robot to finish its jobs (moving or mesuring)
     *
     * @return a double with the value
     */
    double getBatteryUsage();
}
