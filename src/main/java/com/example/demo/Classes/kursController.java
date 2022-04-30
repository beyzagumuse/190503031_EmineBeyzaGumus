package com.example.demo.Classes;

import com.example.demo.HelloApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class kursController {

    private HelloApplication application;

    @FXML
    private void returnHome() throws IOException {
        application.showHomepageScene();
    }
}
