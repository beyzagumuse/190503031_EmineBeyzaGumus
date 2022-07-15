package com.example.demo;

import com.example.demo.Classes.benutzer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class signinController{


    @FXML
    private Button homebtn;

    @FXML
    private TableColumn<benutzer, String> benutzernamecolumn;

    @FXML
    private TableView<benutzer> benutzertable;

    @FXML
    private TableColumn<benutzer, String> passwordcolumn;

    @FXML
    private TextField benutzername_txt;

    @FXML
    private TextField password_txt;

    @FXML
    private Button signinbtn;


    @FXML
    private void addAdmin() throws IOException {
        dbControl.addAdmin((benutzername_txt.getText()), password_txt.getText());
        dbControl.printBenutzerData((benutzername_txt.getText()));

        System.out.println("Person wurde zum Datenbank addiert.");

    }


    @FXML
    private void deleteBenutzer() throws IOException {
        dbControl.printBenutzerData((benutzername_txt.getText()));
        dbControl.deleteAdmin((benutzername_txt.getText()));
        System.out.println("Patient wurde vom Datenbank geloescht.");

    }

    HelloApplication application;
    @FXML
    void goHomr() throws IOException {
        application.showHomepageScene();

    }






}
