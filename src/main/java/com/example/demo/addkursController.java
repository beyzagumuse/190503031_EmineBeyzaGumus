package com.example.demo;

import javafx.fxml.FXML;

import java.io.IOException;

public class addkursController {

    private HelloApplication application;

    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }
}
