package com.group12.snake;

import javafx.scene.paint.Color;

import java.util.Objects;

public class Square {

    static final int length = 30;
    private final Color color;
    private int x;
    private int y;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return x == square.x && y == square.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
