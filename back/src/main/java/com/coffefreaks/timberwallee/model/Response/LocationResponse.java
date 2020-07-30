package com.coffefreaks.timberwallee.model.Response;

import com.coffefreaks.timberwallee.model.Location;

public class LocationResponse extends Location {

    public LocationResponse(Double positionX, Double positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
    }
}
