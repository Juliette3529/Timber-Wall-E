package com.coffefreaks.timberwalle.model.response;

public class MeasureResponse {
    private double batteryUsage;

    public MeasureResponse(double batteryUsage) {
        this.batteryUsage = batteryUsage;
    }

    public double getBatteryUsage() {
        return batteryUsage;
    }
}
