package com.example.demo;

import com.example.demo.Classes.Kurse;
import javafx.fxml.FXML;
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
    private TextField add_tage;

    @FXML
    private TextField add_trainer;

    //@FXML
    //private ComboBox<?> addKursTrainer;

    //@FXML
    //private DatePicker addTag;
    private HelloApplication application;

    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }

    Kurse kurse = new Kurse();

    /*public void  addKurse(){
        kurse.setKursename(addKursName.getText());
        kurse.setKursenummer(addKursId.getText());
        database.createKurse(kurse);
    }*/



    @FXML
    private void addKurse() throws IOException {
        //dbControl.addKurse(Integer.parseInt(addKursId.getText()), addKursName.getText(), Integer.parseInt(addKursPreis.getText()),add_tage.getText(),add_trainer.getText(),Integer.parseInt(addAnzahlderSportler.getText()),Integer.parseInt(addBeginn.getText()),Integer.parseInt(addEnd.getText()));
        dbControl.printKurseData(Integer.parseInt(addKursId.getText()));

        System.out.println("Person wurde zum Datenbank addiert.");
        goKurspage();

    }
}
