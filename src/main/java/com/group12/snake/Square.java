package com.group12.snake;

import javafx.scene.paint.Color;

public class Square {

    private int x;
    private int y;
    private final Color color;

    static final int length = 20;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.WHITE;
    }

    public Square(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void updateX(int x) {

            this.x = x;

    }

    public void updateY(int y) {

            this.y = y;

    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Color getColor() {
        return this.color;
    }

}
