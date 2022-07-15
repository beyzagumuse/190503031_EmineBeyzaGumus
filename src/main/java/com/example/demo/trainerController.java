package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class trainerController {

    @FXML
    private TextField addadresse;

    @FXML
    private TextField addid;

    @FXML
    private TextField addmail;

    @FXML
    private TextField addname;

    @FXML
    private TextField addtel;

    @FXML
    private AnchorPane addtrainerpane;

    @FXML
    private AnchorPane deletetrainerpane;

    @FXML
    private Button detailsclose;

    @FXML
    private AnchorPane detailspane;

    @FXML
    private AnchorPane edittrainerpane;

    @FXML
    private Button finishaddtrainer;

    @FXML
    private Button homebtn;

    @FXML
    private AnchorPane personpane;

    HelloApplication application;
    @FXML
    void goPersonChoice() throws IOException {
        application.showHomepageScene();
    }

    @FXML
    private void goBack() throws IOException{
        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("personchoice.fxml"));
            personpane.getChildren().setAll(pane);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    @FXML
    void goaddTrainer() {
        addtrainerpane.setVisible(true);
        deletetrainerpane.setVisible(false);
        edittrainerpane.setVisible(false);
        detailspane.setVisible(false);
    }
    @FXML
    void godeleteTrainer() {
        addtrainerpane.setVisible(false);
        deletetrainerpane.setVisible(true);
        edittrainerpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    void goeditTrainer() {
        addtrainerpane.setVisible(false);
        deletetrainerpane.setVisible(false);
        edittrainerpane.setVisible(true);
        detailspane.setVisible(false);
    }

    @FXML
    void godetailsTrainer() {
        addtrainerpane.setVisible(false);
        deletetrainerpane.setVisible(false);
        edittrainerpane.setVisible(false);
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
