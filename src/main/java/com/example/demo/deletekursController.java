package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class deletekursController {

    private HelloApplication application;


    @FXML
    private TextField id_deletekurs;


    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }


    @FXML
    private Button ok_btn;


   @FXML
    private void deleteKursebyId() throws IOException {
        dbControl.printKurseData((id_deletekurs.getText()));
        dbControl.deleteKurse(Integer.parseInt(id_deletekurs.getText()));
        System.out.println("Patient wurde vom Datenbank geloescht.");
        goKurspage();
    }









}
