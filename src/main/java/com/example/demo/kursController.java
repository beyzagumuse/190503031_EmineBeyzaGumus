package com.example.demo;

import com.example.demo.Classes.Kurse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

public class kursController {

    private HelloApplication application;

    @FXML
    private TableColumn<Kurse, Integer> kurseanzahl;

    @FXML
    private TableColumn<Kurse, Integer> kursebeginn;

    @FXML
    private TableColumn<Kurse, Integer> kurseend;

    @FXML
    private TableColumn<Kurse,String> kurseid;

    @FXML
    private TableColumn<Kurse, String> kursename;

    @FXML
    private TableColumn<Kurse, Integer> kursepreis;

    @FXML
    private TableColumn<Kurse, String> kursetag;

    @FXML
    private TableColumn<Kurse, String> kursetrainer;

    @FXML
    private TableView<Kurse> kursetable;

    @FXML
    private void goHomepage() throws IOException {
        application.showHomepageScene();
    }

    @FXML
    private void goaddKurs() throws IOException {
        application.showaddKursScene();
    }

    @FXML
    private void godeleteKurs() throws IOException {
        application.showdeleteKursScene();
    }

    @FXML
    private void goeditKurs() throws IOException {
        application.showeditKursScene();
    }

    ObservableList<Kurse> listKurs = FXCollections.observableArrayList();

    //int index =-1;

    //Connection conn = null;
    //ResultSet rs = null;
    //PreparedStatement pst = null;

    /*@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            Connection con = database.connect();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM kurse");

            while (rs.next()) {
                listKurs.add(new Kurse(rs.getString("kurse_id"),rs.getString("kurse_name"),rs.getInt("kurse_preis"),rs.getString("kurse_tage"),rs.getString("trainer_id"),rs.getInt("kurse_anzahlSportler"),rs.getInt("beginn"),rs.getInt("end")));
            }
        } catch (SQLException e) {
            Logger.getLogger(kursController.class.getName()).log(Level.SEVERE, null, e);
        }
        kurseid.setCellValueFactory(new PropertyValueFactory<>("kursenummer"));
        kursename.setCellValueFactory(new PropertyValueFactory<>("kursename"));
        kursepreis.setCellValueFactory(new PropertyValueFactory<>("preis"));
        kursetag.setCellValueFactory(new PropertyValueFactory<>("tage"));
        kursetrainer.setCellValueFactory(new PropertyValueFactory<>("trainer_id"));
        kurseanzahl.setCellValueFactory(new PropertyValueFactory<>("anzahlSportler"));
        kursebeginn.setCellValueFactory(new PropertyValueFactory<>("beginn"));
        kurseend.setCellValueFactory(new PropertyValueFactory<>("end"));


        //listKurs = database.getDatakurse();
        System.out.println(listKurs);
        kursetable.setItems(listKurs);
    }*/
}
