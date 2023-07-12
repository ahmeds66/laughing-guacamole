package com.ares.mpjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Reservation {
    @FXML
    private TextField Vol_selected;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private CheckBox check;
    @FXML
    private Button Annuler;
    @FXML
    private Button Confirmer;
    @FXML
    private Button reservenc;


    public void Annuler(ActionEvent event){
        Annuler.setOnAction(e -> {
            //close the window
            Annuler.getScene().getWindow().hide();
        });
        }
    public void Confirmer(ActionEvent event){
        //To do
    }

    public void reservenc(ActionEvent event){
        //To do
    }

    public void check(ActionEvent event){
        //To do
    }

    public void vol(){
        //get the selected flight from the table and put it in the textfield
    }
}
