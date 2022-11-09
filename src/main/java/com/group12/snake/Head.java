package com.group12.snake;

import java.util.ArrayList;
import java.util.HashSet;

public class Head extends Square {

    private Direction direction;

    public Head(int x, int y) {
        super(x, y);
        this.direction = Direction.RIGHT;
    }

    public void move(ArrayList<Square> tail) {


        ArrayList<Square> updated = new ArrayList<>();

        for (int i = 1; i < tail.size(); i++) {

            int previousX = tail.get(i - 1).getX();
            int previousY = tail.get(i - 1).getY();

            Square updatedPosition = new Square(previousX, previousY);
            updated.add(updatedPosition);

        }

        if (tail.size() > 0) {
            tail.get(0).updateX(this.getX());
            tail.get(0).updateY(this.getY());
        }

        for (int i = 1; i < tail.size(); i++) {

            tail.set(i, updated.get(i - 1));

        }

        switch (this.direction) {

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


    public boolean hasCollided(ArrayList<Square> tail) {

        int finalPosition;

        if (this.direction.equals(Direction.LEFT)) {

            finalPosition = this.getX() - Square.length;
            return finalPosition < 0 || this.hasHitTail(tail, new Square(finalPosition, this.getY()));

        } else if (this.direction.equals(Direction.RIGHT)) {
            finalPosition = this.getX() + Square.length;
            return finalPosition >= Game.WIDTH || this.hasHitTail(tail, new Square(finalPosition, this.getY()));
        } else if (this.direction.equals(Direction.UP)) {
            finalPosition = this.getY() - Square.length;
            return finalPosition < 0 || this.hasHitTail(tail, new Square(this.getX(), finalPosition));
        } else {
            finalPosition = this.getY() + Square.length;
            return finalPosition >= Game.HEIGHT || this.hasHitTail(tail, new Square(this.getX(), finalPosition));
        }

    }


    public boolean hasHitTail(ArrayList<Square> tail, Square predictedPosition) {
        return this.getUsedTiles(tail).contains(predictedPosition);
    }

    public HashSet<Square> getUsedTiles(ArrayList<Square> tail) {

        HashSet<Square> tiles = new HashSet<>(tail);
        return tiles;

    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
