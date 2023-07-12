package com.ares.mpjfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Get the database connection
        Void connection = Connection_DB.getConnection();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Test-1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Ares");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}