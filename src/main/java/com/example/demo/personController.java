package com.example.demo;

import com.example.demo.Classes.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class personController {

    @FXML
    private TextField addadresse;

    @FXML
    private TextField addid;

    @FXML
    private TextField addmail;

    @FXML
    private TextField addnachname;

    @FXML
    private TextField addname;

    @FXML
    private AnchorPane addpersonpane;

    @FXML
    private TextField addtel;

    @FXML
    private TextField deleteid;

    @FXML
    private AnchorPane deletepersonpane;

    @FXML
    private Button detailsclose;

    @FXML
    private AnchorPane detailspane;

    @FXML
    private TextField editadresse;

    @FXML
    private TextField editid;

    @FXML
    private TextField editmail;

    @FXML
    private TextField editnachname;

    @FXML
    private TextField editname;

    @FXML
    private AnchorPane editpersonpane;

    @FXML
    private TextField edittel;

    @FXML
    private Button finishaddtrainer;

    @FXML
    private Button home_btn;

    @FXML
    private TableColumn<Person,String> persontable;
    @FXML
    private TableView<Person> persontableview;





    private Person p;


    @FXML
    void goaddPerson() {
        addpersonpane.setVisible(true);
        deletepersonpane.setVisible(false);
        editpersonpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    private void addPerson() throws IOException {
        dbControl.addPerson(Integer.parseInt(addid.getText()), addname.getText(),addnachname.getText(),addtel.getText(),addadresse.getText(),addmail.getText());
        dbControl.printKurseData(Integer.parseInt(addid.getText()));

        System.out.println("Person wurde zum Datenbank addiert.");

    }


    @FXML
    void godeletePerson() {
        addpersonpane.setVisible(false);
        deletepersonpane.setVisible(true);
        editpersonpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    void goeditPerson() {
        addpersonpane.setVisible(false);
        deletepersonpane.setVisible(false);
        editpersonpane.setVisible(true);
        detailspane.setVisible(false);
    }

    @FXML
    void godetailsPerson() {
        addpersonpane.setVisible(false);
        deletepersonpane.setVisible(false);
        editpersonpane.setVisible(false);
        detailspane.setVisible(true);
    }

    @FXML
    void closedetails(){
        closePane(detailspane);
    }

    @FXML
    void closeedit(){
        closePane(editpersonpane);
    }

    @FXML
    void closeadd(){
        closePane(addpersonpane);
    }

    @FXML
    void closedelete(){
        closePane(deletepersonpane);
    }


    @FXML
    void closePane(AnchorPane pane) {
        pane.setVisible(false);
    }


    private HelloApplication application;
    @FXML
    private void returnPersonchoice() throws IOException{
        application.showPersonChoiceScene();
    }

    @FXML
    private void goHomepage() throws IOException {
        application.showHomepageScene();
    }
}
