module com.group12.snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group12.snake to javafx.fxml;
    exports com.group12.snake;
}