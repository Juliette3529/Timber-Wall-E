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
     * Move the robot of 1 position in the specified direction
     *
     * @param dest@return true if moving is a success, false otherwise
     */
    boolean move(Location dest);
}
