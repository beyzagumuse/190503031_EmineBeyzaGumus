package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class addkursController {



    @FXML
    private TextField addAnzahlderSportler;

    @FXML
    private TextField addBeginn;

    @FXML
    private TextField addEnd;

    @FXML
    private TextField addKursId;

    @FXML
    private TextField addKursName;

    @FXML
    private TextField addKursPreis;

    @FXML
    private ComboBox<?> addKursTrainer;

    @FXML
    private DatePicker addTag;
    private HelloApplication application;

    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }
}