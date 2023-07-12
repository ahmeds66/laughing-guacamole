package com.ares.mpjfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class Client_Dash {
    @FXML
    private Button reservebtn;
    @FXML
    private Button search_button;
    @FXML
    private TableView tableview;
    @FXML
    private TableColumn flight_name;


    private void reserve() {
        //to open the reservation window and send the selected flight to the reservation window
        reservebtn.setOnAction(e -> {
            selectedItem();
            reservebtn.getScene().getWindow().hide();
            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("reservation.fxml"));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
    }

    public String selectedItem(){
        //to get the selected item from the tableview and extract the flight name from the column "flight_name"
        String selected = tableview.getSelectionModel().getSelectedItem().toString();
        String flight_name = selected.substring(selected.indexOf("flight_name=")+12,selected.indexOf(","));
        return flight_name;
    }
}
