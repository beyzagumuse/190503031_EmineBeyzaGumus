package com.example.demo;

import com.example.demo.Classes.database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class signinController {


    @FXML
    private TextField benutzername_txt;

    @FXML
    private TextField password_txt;

    @FXML
    private Button signinbtn;


    @FXML
    private void addAdmin() throws IOException {
        database.addAdmin((benutzername_txt.getText()), password_txt.getText());
        database.printBenutzerData((benutzername_txt.getText()));

        System.out.println("Person wurde zum Datenbank addiert.");

    }
}
