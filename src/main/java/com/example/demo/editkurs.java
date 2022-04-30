package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class editkurs {

    private HelloApplication application;
    @FXML
    private TextField editKursID;

    @FXML
    private TextField editanzahl;

    @FXML
    private TextField editbeginn;

    @FXML
    private TextField editend;

    @FXML
    private TextField editname;

    @FXML
    private TextField editpreis;

    @FXML
    private DatePicker edittag;

    @FXML
    private ComboBox<?> edittrainer;


    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }
}
