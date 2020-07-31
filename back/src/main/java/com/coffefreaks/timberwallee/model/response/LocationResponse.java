package com.coffefreaks.timberwallee.model.response;

import com.coffefreaks.timberwalle.model.Location;

public class LocationResponse extends Location {
    private double batteryUsage;

    public LocationResponse(Double positionX, Double positionY) {
        this.setPositionX(positionX);
        this.setPositionY(positionY);
    }

    public double getBatteryUsage() {
        return batteryUsage;
    }

    public void setBatteryUsage(double batteryUsage) {
        this.batteryUsage = batteryUsage;
    }
}
