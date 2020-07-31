package com.coffefreaks.timberwalle.model;

public class Location {
    private Double positionX;
    private Double positionY;

    public Location() {
    }

    public Double getPositionX() {
        return positionX;
    }

    public void setPositionX(Double positionX) {
        this.positionX = positionX;
    }

    public Double getPositionY() {
        return positionY;
    }

    public void setPositionY(Double positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "Location{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}
