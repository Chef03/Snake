package com.group12.snake;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) {

        Game game = new Game();

        HelloApplication.stage = stage;
        stage.setTitle("Snake");

        Group group = new Group();
        group.getChildren().add(game.getCanvas());

        Scene scene = new Scene(group, Game.WIDTH, Game.HEIGHT, Color.rgb(0, 106, 167));

        stage.setScene(scene);
        stage.show();
        game.start();

    }

    public static void main(String[] args) {
        launch();
    }

}