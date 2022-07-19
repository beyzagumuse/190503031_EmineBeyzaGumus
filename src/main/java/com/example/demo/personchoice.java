package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class personchoice {

    private HelloApplication application;


    @FXML
    private AnchorPane personchoicepane;

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

    private homepageController homepageController = new homepageController();
    @FXML
    private void goPerson() throws IOException {
        application.showPersonScene();
    }

    @FXML
    private void closePersonChoice(){

        personchoicepane.setVisible(false);
    }

    @FXML
    private void goPersona() throws IOException{
        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("person.fxml"));
            personchoicepane.getChildren().setAll(pane);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void goTrainerr() throws IOException{
        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("trainer.fxml"));
            personchoicepane.getChildren().setAll(pane);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void goSportlerr() throws IOException{
        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("sportler.fxml"));
            personchoicepane.getChildren().setAll(pane);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



    @FXML
    private void goDetails() throws IOException {
        application.showDetailsScene();
    }


}
