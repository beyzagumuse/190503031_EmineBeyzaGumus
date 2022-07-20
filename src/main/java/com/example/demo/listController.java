package com.example.demo;

import com.example.demo.Classes.Kurse;
import com.example.demo.Classes.Sportler;
import com.example.demo.Classes.Trainer;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class listController {

    @FXML
    private AnchorPane Trainerlist;

    @FXML
    private TableColumn<Kurse, Integer> kurse_nichtfreie_col;

    @FXML
    private ComboBox<String> kursecombo;

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
    private ComboBox<String> sportlercombo;

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
    private ComboBox<String> trainercombo;

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
    private TableView<Kurse> trainerview;

    @FXML
    private TableView<Sportler> trainerview2;


    HelloApplication application;

    @FXML
    private void goHomepage() throws IOException {
        application.showHomepageScene();
    }

    @FXML
    private void listTrainer(){
        Trainerlist.setVisible(true);
        kurselist.setVisible(false);
        sportlerlist.setVisible(false);
        inTrainer();
    }

    @FXML
    private void listKurse(){
        Trainerlist.setVisible(false);
        kurselist.setVisible(true);
        sportlerlist.setVisible(false);
        inKurse();
    }

    @FXML
    private void listSportler(){
        Trainerlist.setVisible(false);
        kurselist.setVisible(false);
        sportlerlist.setVisible(true);
        inSportler();
    }

    @FXML
    private void initialize(){

        sportlercombo.setItems(dbControl.listSportlerCombo());



        kursecombo.setItems(dbControl.listKurseCombo());

        trainercombo.setItems(dbControl.listTrainerCombo());


    }

    @FXML
    private void inKurse(){
        kurseportlerid_col.setCellValueFactory(new PropertyValueFactory<>("sportlernummer"));
        kurseshuld_col.setCellValueFactory(new PropertyValueFactory<>("schuld"));
        kurseview2.setItems(dbControl.listKurseList2(kursecombo.getValue()));

    }

    @FXML
    private void inTrainer(){

        trainerid_col.setCellValueFactory(new PropertyValueFactory<>("trainer"));
        trainerkurse_col.setCellValueFactory(new PropertyValueFactory<>("kursename"));
        traineranzahl_col.setCellValueFactory(new PropertyValueFactory<>("anzahlSportler"));
        trainersportlerid_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        trainersportlername_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        trainersportlernachname_col.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        trainerview.setItems(dbControl.listTrainerList(trainercombo.getValue()));
        trainerview2.setItems(dbControl.listTrainerList2(trainercombo.getValue()));
    }

    @FXML
    private void inSportler(){
        sportlersportlerid_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        sportlersportlername_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        sportlersportlernachname_col.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        sportlerkurse_col.setCellValueFactory(new PropertyValueFactory<>("kurse_id"));
        sportlerschuld_col.setCellValueFactory(new PropertyValueFactory<>("schuld"));
        sportlerview.setItems(dbControl.listSportlerList(sportlercombo.getValue()));

    }

    /*
    public void initialize(){

        tc_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        nachname_col.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        telno_col.setCellValueFactory(new PropertyValueFactory<>("telno"));
        add_col.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        allpersonview.setItems(ListPersonal());



    }
*/



    @FXML
    private void closeall(){
        Trainerlist.setVisible(false);
        kurselist.setVisible(false);
        sportlerlist.setVisible(false);
    }
}
