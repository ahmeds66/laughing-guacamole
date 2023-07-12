package com.ares.mpjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button login;

    public void login(ActionEvent event){
        login.setOnAction(e -> {
            //verify if the username and password are correct
            if(username.getText().equals("admin") && password.getText().equals("admin")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login");
                alert.setHeaderText("Login");
                alert.setContentText("Login Successful");
                alert.showAndWait();
                //close the window and open the admin dashboard
                login.getScene().getWindow().hide();
                Stage stage = new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("dashAdmin.fxml"));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else if (username.getText().equals("nouvelair") && password.getText().equals("1234")){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login");
                alert.setHeaderText("Login");
                alert.setContentText("Login Successful");
                alert.showAndWait();
            } else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login");
                alert.setHeaderText("Login");
                alert.setContentText("Login Failed");
                alert.showAndWait();

                //close the window and open the client dashboard
            }
        });
    }

}
