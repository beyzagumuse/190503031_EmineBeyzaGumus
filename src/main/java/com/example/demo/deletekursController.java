package com.example.demo;

import com.example.demo.Classes.database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class deletekursController {

    private HelloApplication application;


    @FXML
    private TextField id_deletekurs;


    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }


    @FXML
    private Button ok_btn;

    @FXML
    private void deletebyId(){
        database.deleteDataKurse(Integer.parseInt(id_deletekurs.getText()));
    }





}
