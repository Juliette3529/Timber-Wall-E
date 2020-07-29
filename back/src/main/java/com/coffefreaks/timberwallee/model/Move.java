package com.coffefreaks.timberwallee.model;

import com.coffefreaks.timberwallee.model.Enum.Direction;

import javax.validation.constraints.NotEmpty;


public class Move {

    @NotEmpty
    private Direction direction;

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

}
