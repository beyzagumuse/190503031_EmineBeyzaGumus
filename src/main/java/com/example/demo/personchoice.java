package com.example.demo;

import javafx.fxml.FXML;

import java.io.IOException;

public class personchoice {

    private HelloApplication application;

    @FXML
    private void goPersonal() throws IOException {
        application.showPersonalScene();
    }

    @FXML
    private void goSportler() throws IOException {
        application.showSportlerScene();
    }

    @FXML
    private void goTrainer() throws IOException {
        application.showTrainerScene();
    }

    @FXML
    private void goDetails() throws IOException {
        application.showDetailsScene();
    }


}
