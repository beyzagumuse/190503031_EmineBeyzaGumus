package com.example.demo;

import com.example.demo.Classes.Person;
import com.example.demo.Classes.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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


    ObservableList<Person> data = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        try {
            Connection conn = database.connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT person_name FROM person");

            while (rs.next()) {
                this.data.add(new Person(rs.getString("person_name")));
            }
        } catch (SQLException e) {
            Logger.getLogger(kursController.class.getName()).log(Level.SEVERE, (String)null, e);
        }
        persontable.setCellValueFactory(new PropertyValueFactory<>("name"));



        data = dbControl.getDataperson();
        System.out.println(data);
        this.persontableview.setItems(data);

        persontableview.setEditable(true);
        persontable.setCellFactory(TextFieldTableCell.forTableColumn());


    }


    @FXML
    private TextField textfieldname;

    @FXML
    void buttonadd() {

        Person p = new Person(textfieldname.getText());
        persontableview.getItems().add(p);

    }

    @FXML
    void detailsaction() {
        Person person = new Person();

        List<List<String>> arrList = new ArrayList<>();

        for(int i =0; i < persontableview.getItems().size();i++){
            person = persontableview.getItems().get(i);
            arrList.add(new ArrayList<>());
            arrList.get(i).add(person.getName());
        }

        for(int i =0;i<arrList.size();i++){
            for(int j =0; j< arrList.get(i).size();j++){
                System.out.println(arrList.get(i).get(j));
            }
        }

    }

    @FXML
    void deleteaction() {
        ObservableList<Person> allPerson, SinglePerson;
        allPerson = persontableview.getItems();
        SinglePerson = persontableview.getSelectionModel().getSelectedItems();
        SinglePerson.forEach(allPerson::remove);

    }

    @FXML
    void oneditchange(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Person person = persontableview.getSelectionModel().getSelectedItem();
        person.setName(personStringCellEditEvent.getNewValue());
    }


}
