package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class sportlerController {

    @FXML
    private AnchorPane addSportlerpane;

    @FXML
    private AnchorPane deleteSportlerpane;

    @FXML
    private AnchorPane editsportlerpane;

    @FXML
    void goaddSportler() {
        addSportlerpane.setVisible(true);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(false);
    }

    @FXML
    void godeleteSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(true);
        editsportlerpane.setVisible(false);
    }

    @FXML
    void goeditSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(true);
    }

}

