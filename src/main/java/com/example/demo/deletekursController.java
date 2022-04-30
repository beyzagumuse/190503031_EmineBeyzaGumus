package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class deletekursController {

    private HelloApplication application;

    @FXML
    private TextField deleteKursId;

    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }

}
