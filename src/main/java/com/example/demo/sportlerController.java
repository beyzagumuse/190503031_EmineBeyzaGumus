package com.example.demo;

import com.example.demo.Classes.database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class sportlerController {

    @FXML
    private AnchorPane addSportlerpane;

    @FXML
    private AnchorPane deleteSportlerpane;

    @FXML
    private AnchorPane editsportlerpane;

    @FXML
    private Button detailsclose;

    @FXML
    private AnchorPane detailspane;




    @FXML
    private TextField addsportleradresse;

    @FXML
    private TextField addsportlerfr;

    @FXML
    private TextField addsportlerid;

    @FXML
    private TextField addsportlerkrank;

    @FXML
    private TextField addsportlermail;

    @FXML
    private TextField addsportlermv;

    @FXML
    private TextField addsportlername;

    @FXML
    private TextField addsportlertelno;



    @FXML
    void goaddSportler() {
        addSportlerpane.setVisible(true);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    private void addSportler() throws IOException {
        database.addSportler(Integer.parseInt(addsportlerid.getText()), addsportlername.getText(),addsportlertelno.getText(),addsportleradresse.getText(),addsportlermail.getText(),Integer.parseInt(addsportlermv.getText()),Integer.parseInt(addsportlerfr.getText()),addsportlerkrank.getText());
        database.printKurseData(Integer.parseInt(addsportlerid.getText()));

        System.out.println("Person wurde zum Datenbank addiert.");

    }

    @FXML
    void godeleteSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(true);
        editsportlerpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    void goeditSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(true);
        detailspane.setVisible(false);
    }

    @FXML
    void godetailsSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(false);
        detailspane.setVisible(true);
    }

    @FXML
    void closedetails(){
        closePane(detailspane);
    }

    @FXML
    void closePane(AnchorPane pane) {
        pane.setVisible(false);
    }


}

