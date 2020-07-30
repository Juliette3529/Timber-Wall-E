package com.coffefreaks.timberwalle.model.Response;

import com.coffefreaks.timberwalle.model.Location;

public class LocationResponse extends Location {

    public LocationResponse(Double positionX, Double positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
    }
}
