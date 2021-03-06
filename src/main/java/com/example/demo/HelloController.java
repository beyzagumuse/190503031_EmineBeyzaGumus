package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class HelloController {

    private HelloApplication application;
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

    @FXML
    private Label errMsg;

    /*public void LoginPaneShow(){
        pane_login.setVisible(true);
    }*/

    @FXML
    protected void onLoginButtonClick() {
        System.out.println("Hello darling!");

    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    protected void Login(ActionEvent event) throws Exception{
         try {
             if(dbControl.containBenutzer(txt_id.getText(),txt_password.getText())){
                 root = FXMLLoader.load(homepageController.class.getResource("homepage.fxml"));
                 stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                 scene = new Scene(root);
                 stage.setScene(scene);
                 stage.show();
             }else{

                 errMsg.setText("Es gibt keine Person mit diesen Informationen!");
                 errMsg.setVisible(true);
             }


         } catch (Exception e){

             JOptionPane.showMessageDialog(null, e);
         }
    }



    @FXML
    private void goHomepage() throws IOException {
        application.showHomepageScene();
    }






}