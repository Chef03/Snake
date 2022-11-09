package com.group12.snake;

import java.util.ArrayList;

public class Snake {

    public final Head head;
    private final ArrayList<Square> tail;

    public Snake() {
        this.head = new Head(0, 0);
        this.tail = new ArrayList<>();
    }

    public void grow() {

        Square addedSquare = new Square(this.head.getX(), this.head.getY());
        this.tail.add(0, addedSquare);

    }

    public ArrayList<Square> getTail() {
        return this.tail;
    }

    public int getSize() {
        return this.tail.size();
    }


}
