package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Button btn_login;

    @FXML
    private AnchorPane pane_login;

    @FXML
    private TextField txt_id;

    @FXML
    private PasswordField txt_password;

    /*public void LoginPaneShow(){
        pane_login.setVisible(true);
    }*/

    @FXML
    protected void onLoginButtonClick() {
        btn_login.setText("Hi darling!");

    }

    @FXML
    protected void Login(ActionEvent event) throws Exception{
         try {
             btn_login.getScene().getWindow().hide();
             Parent root = FXMLLoader.load(getClass().getResource("mate.fxml"));
             Stage mainStage = new Stage();
             Scene scene = new Scene(root);
             mainStage.setScene(scene);
             mainStage.show();
         } catch (Exception e){

             JOptionPane.showMessageDialog(null, e);
         }
    }






}