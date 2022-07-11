package com.example.demo;

import com.example.demo.Classes.Kurse;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class kursController {

    private HelloApplication application;

    @FXML
    private TableColumn<Kurse, Integer> kurseanzahl;

    @FXML
    private TableColumn<Kurse, Integer> kursebeginn;

    @FXML
    private TableColumn<Kurse, Integer> kurseend;

    @FXML
    private TableColumn<Kurse,Integer> kurseid;

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

    public TableView<Kurse> getKursetable() {
        return kursetable;
    }

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

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;


    @FXML
    public void initialize() {

        /*try {
            Connection conn = database.connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM kurse");

            while (rs.next()) {
                this.listKurs.add(new Kurse(rs.getInt("kurse_id"),rs.getString("kurse_name"),rs.getInt("kurse_preis"),rs.getString("kurse_tage"),rs.getString("trainer_id"),rs.getInt("kurse_anzahlSportler"),rs.getInt("beginn"),rs.getInt("end")));
            }
        } catch (SQLException e) {
            Logger.getLogger(kursController.class.getName()).log(Level.SEVERE, (String)null, e);
        }
        this.kurseid.setCellValueFactory(new PropertyValueFactory<>("kursenummer"));
        this.kursename.setCellValueFactory(new PropertyValueFactory<>("kursename"));
        this.kursepreis.setCellValueFactory(new PropertyValueFactory<>("preis"));
        this.kursetag.setCellValueFactory(new PropertyValueFactory<>("tage"));
        this.kursetrainer.setCellValueFactory(new PropertyValueFactory<>("trainer"));
        this.kurseanzahl.setCellValueFactory(new PropertyValueFactory<>("anzahlSportler"));
        this.kursebeginn.setCellValueFactory(new PropertyValueFactory<>("beginn"));
        this.kurseend.setCellValueFactory(new PropertyValueFactory<>("end"));


        listKurs = dbControl.getDatakurse();
        System.out.println(listKurs);
        this.kursetable.setItems(listKurs);

         */
    }


}
