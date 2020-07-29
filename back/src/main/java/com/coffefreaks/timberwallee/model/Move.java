package com.coffefreaks.timberwallee.model;

import com.coffefreaks.timberwallee.model.Enum.Direction;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


public class Move {

    @NotEmpty
    private Direction direction;

    @NotEmpty
    @Min(value = 1)
    @Max(value = 50)
    private int distance;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
