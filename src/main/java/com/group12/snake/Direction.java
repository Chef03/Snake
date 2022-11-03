package com.group12.snake;

public enum Direction {

    LEFT("Left", "Right"),
    RIGHT("Right", "Left"),
    UP("Up", "Down"),
    DOWN("Down", "Up");

    private String name;
    private String opposite;

    Direction(String name, String opposite) {
        this.name = name;
        this.opposite = opposite;
    }

    public Direction getOpposite() {
        return Direction.valueOf(this.opposite.toUpperCase());
    }

}
