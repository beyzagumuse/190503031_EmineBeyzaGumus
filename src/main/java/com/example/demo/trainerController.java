package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
