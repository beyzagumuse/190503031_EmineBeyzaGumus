package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class sportlerController {

    @FXML
    private AnchorPane addSportlerpane;

    @FXML
    private AnchorPane deleteSportlerpane;

    @FXML
    private AnchorPane editsportlerpane;

    @FXML
    private Button detailsclose;

    @FXML
    private AnchorPane detailspane;



    @FXML
    void goaddSportler() {
        addSportlerpane.setVisible(true);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    void godeleteSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(true);
        editsportlerpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    void goeditSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(true);
        detailspane.setVisible(false);
    }

    @FXML
    void godetailsSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(false);
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

