package com.example.demo;

import javafx.fxml.FXML;

import java.io.IOException;

public class rechnungController {

    private HelloApplication application;

    @FXML
    private void goHomepage() throws IOException {
        application.showHomepageScene();
    }
}
