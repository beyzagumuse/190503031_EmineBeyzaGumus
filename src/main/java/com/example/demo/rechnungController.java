package com.example.demo;

import com.example.demo.Classes.Rechnung;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class rechnungController {

    private HelloApplication application;

    @FXML
    private TextField kursno;

    @FXML
    private TextField preis;

    @FXML
    private TextField rechnungno;

    @FXML
    private TextField sportno;

    @FXML
    private TextField tage;


    @FXML
    private void goHomepage() throws IOException {
        application.showHomepageScene();
    }

    @FXML
    private void addRechnung() throws IOException {

        Rechnung r = new Rechnung();
        r.setRechnungsnummer(kursno.getText());
        r.setKursenummer(kursno.getText());
        r.setKurseTage(tage.getText());
        r.setSportlernummer(sportno.getText());
        r.setPreis(Integer.parseInt(preis.getText()));
        dbControl.addRechnung(r);
        //dbControl.printKurseData(Integer.parseInt(addKursId.getText()));

        System.out.println("Person wurde zum Datenbank addiert.");
        //goKurspage();

    }
}
