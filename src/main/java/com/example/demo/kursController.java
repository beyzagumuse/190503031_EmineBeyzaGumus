package com.example.demo;

import javafx.fxml.FXML;

import java.io.IOException;

public class kursController {

    private HelloApplication application;

    @FXML
    private void goHomepage() throws IOException {
        application.showHomepageScene();
    }

    @FXML
    private void goaddKurs() throws IOException {
        application.showaddKursScene();
    }

    @FXML
    private void godeleteKurs() throws IOException {
        application.showdeleteKursScene();
    }

    @FXML
    private void goeditKurs() throws IOException {
        application.showeditKursScene();
    }
}
