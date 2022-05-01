package com.example.demo;

import com.example.demo.Classes.Kurse;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class kursController{

    private HelloApplication application;

    @FXML
    private TableColumn<Kurse, Integer> kurseanzahl;

    @FXML
    private TableColumn<Kurse, Integer> kursebeginn;

    @FXML
    private TableColumn<Kurse, Integer> kurseend;

    @FXML
    private TableColumn<Kurse, String> kurseid;

    @FXML
    private TableColumn<Kurse, String> kursename;

    @FXML
    private TableColumn<Kurse, Integer> kursepreis;

    @FXML
    private TableColumn<Kurse, Date> kursetag;

    @FXML
    private TableColumn<Kurse, String> kursetrainer;

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

    ObservableList<Kurse> listKurs;

    int index =-1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    public void initilaze(){
        kurseid.setCellValueFactory(new PropertyValueFactory<Kurse,String>("kursenummer"));
        kursename.setCellValueFactory(new PropertyValueFactory<Kurse,String>("kursename"));
        kursepreis.setCellValueFactory(new PropertyValueFactory<Kurse,Integer>("preis"));
        kursetag.setCellValueFactory(new PropertyValueFactory<Kurse,Date>("tage"));
        //kursetrainer.setCellValueFactory(new PropertyValueFactory<Kurse,String>("kurse_id"));
        kurseanzahl.setCellValueFactory(new PropertyValueFactory<Kurse,Integer>("anzahlSportler"));
        kursebeginn.setCellValueFactory(new PropertyValueFactory<Kurse,Integer>("beginn"));
        kurseend.setCellValueFactory(new PropertyValueFactory<Kurse,Integer>("end"));
    }


}
