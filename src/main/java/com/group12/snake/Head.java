package com.group12.snake;

import java.util.ArrayList;

public class Head extends Square {

    private Direction direction;

    public Head(int x, int y) {
        super(x, y);
        this.direction = Direction.RIGHT;
    }

    public void move(ArrayList<Square> tail) {


        ArrayList<Square> updated = new ArrayList<>();

        for(int i = 1; i < tail.size(); i++) {

            int previousX = tail.get(i-1).getX();
            int previousY = tail.get(i-1).getY();

            Square updatedPosition = new Square(previousX, previousY);
            updated.add(updatedPosition);

        }

        if(tail.size() > 0) {
            tail.get(0).updateX(this.getX());
            tail.get(0).updateY(this.getY());
        }

        for(int i = 1; i < tail.size(); i++) {

            tail.set(i, updated.get(i - 1));

        }


        switch(this.direction) {

            case RIGHT:
                this.updateX(this.getX() + length);
                break;

            case LEFT:
                this.updateX(this.getX() - length);
                break;

            case UP:
                this.updateY(this.getY() - length);
                break;

            case DOWN:
                this.updateY(this.getY() + length);
                break;

        }

    }

    public boolean hasHitWall() {
        return this.getX() > Game.WIDTH - Square.length || this.getX() < 0 || this.getY() > Game.HEIGHT - Square.length || this.getY() < 0;
    }

//    public boolean isOnEdge(int step) {
//
//        int xPosition = Math.abs(this.getX());
//        int yPosition = Math.abs(this.getY());
//        return (xPosition + Square.length + step) > Game.WIDTH || (yPosition + Square.length + step) > Game.HEIGHT;
//
//    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return this.direction;
    }

}
