package com.ares.mpjfx;

import com.ares.mpjfx.classes.Voll;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class DashAdmin {
    @FXML
    private Button volbtn;
    @FXML
    private Button reservebtn;
    @FXML
    private Button passbtn;
    @FXML
    private Button escalebtn;
    @FXML
    private Button list;
    @FXML
    private TextField volName;
    @FXML
    private DatePicker date;
    @FXML
    private TextField heureDep;
    @FXML
    private TextField heureArr;
    @FXML
    private ChoiceBox<String> escale;
    @FXML
    private Button addVol;
    @FXML
    private Pane Vols;
    @FXML
    private Pane Reserve;
    @FXML
    private Pane escales;
    @FXML
    private TableColumn<?,?> vol_name;
    @FXML
    private TableColumn<?,?> vol_date;
    @FXML
    private TableColumn<?,?> vol_hd;
    @FXML
    private TableColumn<?,?> vol_ha;
    @FXML
    private TableColumn<?,?> status;
    @FXML
    private TableView<Voll> tableView;

    //initialize method
    public void initialize() {
        //initialize the tableview
        Vols.setVisible(false);
        //Reserve.setVisible(false);
        escales.setVisible(false);
    }

    public void volbtn(ActionEvent event){
        //this is the function when the button "volbtn" that will show the pane "volpane"
        volbtn.setOnAction(e -> {
            Vols.setVisible(true);
            Reserve.setVisible(false);
            escales.setVisible(false);
        });
    }

    public void addVol(ActionEvent event){//this is the function when the button "addVol" that will add a flight to the database
        addVol.setOnAction(e -> {
            //add the flight to the database
            String vol = volName.getText();
            String date = this.date.getValue().toString();
            String heureDep = this.heureDep.getText();
            String heureArr = this.heureArr.getText();

            //add the flight to the database
            String query = "INSERT INTO vol (vol, date, heureDep, heureArr,status) VALUES ('"+vol+"', '"+date+"', '"+heureDep+"', '"+heureArr+"' , 'Non Disponible')";
            Connection_DB.executeQuery(query);
            //show a message to the user if the flight is added successfully
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajouter un vol");
            alert.setHeaderText("Ajouter un vol");
            alert.setContentText("Vol ajouté avec succès");
            alert.showAndWait();
        });
    }

    public void list(ActionEvent event){
        //this is the function when the button "list" that will show the list of flights by fetching the data from the database
        try {
            String query = "SELECT * FROM vol";
            PreparedStatement ps = Connection_DB.preparedStatement(query);
            ResultSet result = ps.executeQuery();
            ObservableList<Voll> voll = FXCollections.observableArrayList();

            while (result.next()){
                Voll voll1 = new Voll(result.getString("vol"), result.getDate(3), result.getString("heureDep"), result.getString("heureArr"), result.getString("status"));
                voll.add(voll1);
            }
            vol_name.setCellValueFactory(new PropertyValueFactory<>("vol"));
            vol_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            vol_hd.setCellValueFactory(new PropertyValueFactory<>("heureDep"));
            vol_ha.setCellValueFactory(new PropertyValueFactory<>("heureArr"));
            status.setCellValueFactory(new PropertyValueFactory<>("status"));
            tableView.setItems(voll);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void reservebtn(ActionEvent event){
        //this is the function when the button "reservebtn" that will show the pane "reservepane"
        reservebtn.setOnAction(e -> {
            Reserve.setVisible(true);
            Vols.setVisible(false);
            escales.setVisible(false);
        });
    }

    public void escalebtn(ActionEvent event){
        //this is the function when the button "escalebtn" that will show the pane "escalepane"
        escalebtn.setOnAction(e -> {
            escales.setVisible(true);
            Vols.setVisible(false);
            Reserve.setVisible(false);
        });
    }

    @FXML
    private TextField nom_esc;
    @FXML
    private TextField arr_esc;
    @FXML
    private TextField dep_esc;
    @FXML
    private Button AddEscale;
    @FXML
    private Button updateEsc;
    @FXML
    private Button delEsc;
    @FXML
    private TableView<ObservableList> tableView1;
    @FXML
    private TableColumn<?,?> nom;
    @FXML
    private TableColumn<?,?> arr;
    @FXML
    private TableColumn<?,?> dep;

    public void AddEscale(ActionEvent event){
        //this is the function when the button "AddEscale" that will add an escale to the database
        AddEscale.setOnAction(e -> {
            //add the escale to the database
            String code = "2";
            String nom = nom_esc.getText();
            String arr = arr_esc.getText();
            String dep = dep_esc.getText();

            //add the escale to the database
            String query = "INSERT INTO escale (code,escale, arr, dep) VALUES ('"+code+"', '"+nom+"', '"+arr+"', '"+dep+"')";
            Connection_DB.executeQuery(query);
            //show a message to the user if the escale is added successfully
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ajouter une escale");
            alert.setHeaderText("Ajouter une escale");
            alert.setContentText("Escale ajoutée avec succès");
            alert.showAndWait();
        });
    }

    public void updateEsc(ActionEvent event){
        //this is the function when the button "updateEsc" that will update an escale in the database
        updateEsc.setOnAction(e -> {
            //TODO
        });
    }

    public void delEsc(ActionEvent event){
        //this is the function when the button "delEsc" that will delete an escale from the database
        delEsc.setOnAction(e -> {
            this.tableView1.getItems().removeAll(this.tableView1.getSelectionModel().getSelectedItem());

        });
    }

}
