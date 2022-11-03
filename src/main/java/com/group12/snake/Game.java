package com.group12.snake;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.Random;

public class Game extends AnimationTimer {

    final static int WIDTH = 600;
    final static int HEIGHT = 600;
    final static int fps = 10;
    private final Snake snake;
    private Food food;
    private final Canvas canvas;
    private long lastUpdate = 0;


    public Game() {

        this.snake = new Snake();
        this.canvas = new Canvas(WIDTH, HEIGHT);
        this.canvas.getGraphicsContext2D().setFill(Color.WHITE);
        this.canvas.setFocusTraversable(true);
        this.canvas.addEventHandler(KeyEvent.KEY_PRESSED, this::handleInput);
        this.food = this.generateFood();

    }

    @Override
    public void handle(long now) {

        // this runs every 1/fps seconds
        if((now - lastUpdate) >= Math.pow(10, 9) / fps) {

//            this.food = this.generateFood(); //a cool effect lol
            this.clearTrail();
            this.snake.head.move(this.snake.getTail());
            if(this.snake.head.getX() == this.food.getX() && this.snake.head.getY() == this.food.getY()) {
                System.out.println("You ate the food");
                this.food = this.generateFood();
                this.snake.grow();
            }
            this.drawSquare(snake.head);
            for(Square square : snake.getTail()) {
                this.drawSquare(square);
            }
            HelloApplication.stage.setTitle("Score: " + this.snake.getSize() + " X: " + snake.head.getX() + " Y: " + snake.head.getY());
            lastUpdate = now;

        }

        if(this.snake.head.hasHitWall()) {
            System.out.println("Game Lost.");
            HelloApplication.stage.setTitle("Game Lost");
            this.stop();
        }


    }

    public void drawSquare(Square square) {
        this.canvas.getGraphicsContext2D().setFill(square.getColor());
        this.canvas.getGraphicsContext2D().fillRect(square.getX(), square.getY(), Square.length, Square.length);
    }

    public Food generateFood() {

        int nbOfCols = (int) Math.floor(this.canvas.getWidth() / Square.length);
        int nbOfRows = (int) Math.floor(this.canvas.getHeight() / Square.length);

        int randomX = (new Random()).nextInt(nbOfCols) + 1;
        int randomY = (new Random()).nextInt(nbOfRows) + 1;

        Food apple = new Food((randomX * Square.length) - Square.length, (randomY * Square.length) - Square.length, Color.rgb(254, 204, 2));

        this.drawSquare(apple);
        return apple;

    }

    public void handleInput(KeyEvent event) {

        Direction inputDir = Direction.valueOf(event.getCode().toString().toUpperCase());
        if(inputDir.getOpposite().equals(this.snake.head.getDirection()) && snake.getSize() > 0) {
            return;
        }

        switch(event.getCode()) {
            case RIGHT:
                    this.snake.head.setDirection(Direction.RIGHT);
                break;
            case LEFT:
                    this.snake.head.setDirection(Direction.LEFT);
                break;
            case UP:
                    this.snake.head.setDirection(Direction.UP);
                break;
            case DOWN:
                    this.snake.head.setDirection(Direction.DOWN);
                break;
        }

    }

    public void clearTrail() {

        this.clearSquare(this.snake.head);

        for(Square square : this.snake.getTail()) {
            this.clearSquare(square);
        }

    }

    public void clearSquare(Square square) {

        this.canvas.getGraphicsContext2D().clearRect(square.getX(), square.getY(), Square.length, Square.length);

    }

    public Canvas getCanvas() {
        return canvas;
    }
}
