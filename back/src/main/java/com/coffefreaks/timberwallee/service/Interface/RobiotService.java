package com.coffefreaks.timberwallee.service.Interface;

import com.coffefreaks.timberwallee.model.Enum.Direction;
import com.coffefreaks.timberwallee.model.Enum.EngineStatus;
import com.coffefreaks.timberwallee.model.Location;

public interface RobiotService {

    /**
     * Contact the Robiot API to get its current location
     * @return a location
     */
    Location getLocation();

    /**
     * Contact the Robiot API to get its engine's status
     * @return the engine status
     */
    EngineStatus getEngineStatus();

    /**
     * Move the robot of 1 position in the specified direction
     * @param direction an enum with the direction of the move
     * @return true if moving is a success, false otherwise
     */
    boolean move(Direction direction);
}
