package com.ares.mpjfx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TestController {
    @FXML
    private Button login1;

    @FXML
    private Button login2;

    @FXML
    private TextField user;

    @FXML
    private TextField psw;

    public void login1(){
        login1.setOnAction(e -> {
            //verify if the username and password are correct
            if(user.getText().equals("admin") && psw.getText().equals("admin")){
                //shows an alert that the login is successful in button 1
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login");
                alert.setHeaderText("Login");
                alert.setContentText("Login Successful ya boudaa !!");
                alert.showAndWait();
            } else if (user.getText().equals("nouvelair") && psw.getText().equals("1234")){
                //if failed shows an alert that the login is failed in button 1
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login");
                alert.setHeaderText("Login");
                alert.setContentText("Login Failed Ya onss chleka !!");
            } else{
                //if failed shows an alert that the login is failed in button 1
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login");
                alert.setHeaderText("Login");
                alert.setContentText("Login Failed Ya onss chleka !!");
            }
        });
    }
}
