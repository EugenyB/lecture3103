package main.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MainController {
    @FXML
    private Pane pane;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField textField;

    public void initialize() {
        canvas.heightProperty().bind(pane.heightProperty());
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().addListener((observable, oldValue, newValue) -> draw());
        canvas.widthProperty().addListener((observable, oldValue, newValue) -> draw());
    }

    public void close() {
        Platform.exit();
    }

    public void draw() {
        double width = pane.getWidth();
        double height = pane.getHeight();
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITESMOKE);
        g.fillRect(0, 0, width, height);
        g.setStroke(Color.BLUE);
        g.strokeLine(0,0,width,height);
        g.strokeLine(0,height,width,0);
    }

    public void about() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("First cool program in JavaFX");
        alert.show();
    }

    public void hello() {
        String text = textField.getText();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Hello");
        alert.setHeaderText("This is Hello");
        alert.setContentText("Hello, " + text + "!");
        alert.show();
    }
}
