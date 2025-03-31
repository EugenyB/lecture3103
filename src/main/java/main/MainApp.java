package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("main.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("First Application");
        primaryStage.show();
    }
}
