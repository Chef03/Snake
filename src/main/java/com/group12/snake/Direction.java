package com.group12.snake;

public enum Direction {

    LEFT("Left", "Right", -1),
    RIGHT("Right", "Left", 1),
    UP("Up", "Down", 1),
    DOWN("Down", "Up", -1);

    private String name;
    private String opposite;
    private int vector;

    Direction(String name, String opposite, int vector) {
        this.name = name;
        this.opposite = opposite;
        this.vector = vector;
    }

    public Direction getOpposite() {
        return Direction.valueOf(this.opposite.toUpperCase());
    }

    public int getVector() {
        return this.vector;
    }

}
