package com.example.demo;

import com.example.demo.Classes.Kurse;
import com.example.demo.Classes.Sportler;
import com.example.demo.Classes.Trainer;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class listController {

    @FXML
    private AnchorPane Trainerlist;

    @FXML
    private TableColumn<Kurse, Integer> kurse_nichtfreie_col;

    @FXML
    private ComboBox<Kurse> kursecombo;

    @FXML
    private TableColumn<Kurse, Integer> kursefreie_col;

    @FXML
    private TableColumn<Kurse, String> kursekurseid_col;

    @FXML
    private TableColumn<Kurse, String> kursekursename_col;

    @FXML
    private AnchorPane kurselist;

    @FXML
    private TableColumn<Sportler, String> kurseportlerid_col;

    @FXML
    private TableColumn<Sportler, Integer> kurseshuld_col;

    @FXML
    private TableView<Kurse> kurseview;

    @FXML
    private TableView<Sportler> kurseview2;

    @FXML
    private TextField payfield;

    @FXML
    private ComboBox<Sportler> sportlercombo;

    @FXML
    private TableColumn<Kurse, String> sportlerkurse_col;

    @FXML
    private AnchorPane sportlerlist;

    @FXML
    private TableColumn<Sportler, Integer> sportlerschuld_col;

    @FXML
    private TableColumn<Sportler, String> sportlersportlerid_col;

    @FXML
    private TableColumn<Sportler, String> sportlersportlernachname_col;

    @FXML
    private TableColumn<Sportler, String> sportlersportlername_col;

    @FXML
    private TableView<Sportler> sportlerview;

    @FXML
    private TableColumn<Kurse, Integer> traineranzahl_col;

    @FXML
    private ComboBox<Trainer> trainercombo;

    @FXML
    private TableColumn<Trainer, String> trainerid_col;

    @FXML
    private TableColumn<Trainer, String> trainerkurse_col;

    @FXML
    private TableColumn<Sportler, String> trainersportlerid_col;

    @FXML
    private TableColumn<Sportler, String> trainersportlernachname_col;

    @FXML
    private TableColumn<Sportler, String> trainersportlername_col;

    @FXML
    private TableView<Trainer> trainerview;

    @FXML
    private TableView<Sportler> trainerview2;

}
