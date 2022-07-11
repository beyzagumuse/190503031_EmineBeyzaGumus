package com.example.demo;

import com.example.demo.Classes.Kurse;
import com.example.demo.Classes.Person;
import com.example.demo.Classes.database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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


    //private Person person;

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

    public TableView<Person> getPersontable() {
        return persontable;
    }
/*
    public void Edit (){
        try {
            conn = database.connect();
            String value1 = editid.getText();
            String value2 = editname.getText();
            String value3 = editnachname.getText();
            String value4 = edittel.getText();
            String value5 = editadresse.getText();
            String value6 = editmail.getText();
            String sql = "update person set person_id= '"+value1+"',person_name= '"+value2+"',person_nachname= '"+
                    value3+"',person_telno= '"+value4+"',person_adresse= '"+value5+ "',person_mail= '" +value6+ "' where user_id='"+value1+"' ";
            dbControl.pstmt= conn.prepareStatement(sql);
            pstmt.execute();
            JOptionPane.showMessageDialog(null, "Update");
            UpdateTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void UpdateTable(){

        //this.editid.setCellValueFactory
        persontable.setCellValueFactory(new PropertyValueFactory<>("person_id"));
        //editid.setCellValueFactory(new PropertyValueFactory<users,String>("username"));
        //col_password.setCellValueFactory(new PropertyValueFactory<users,String>("password"));
        //col_email.setCellValueFactory(new PropertyValueFactory<users,String>("email"));
        //col_type.setCellValueFactory(new PropertyValueFactory<users,String>("type"));

        //listM = mysqlconnect.getDatausers();
        //table_users.setItems(listM);
    }
    @FXML
    public void initialize() {

        UpdateTable();
    }*/

    @FXML
    public void initialize() {

        try {
            Connection conn = database.connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM kurse");

            while (rs.next()) {
                //(this.listKurs.add(new Person(rs.getInt("kurse_id"));
            }
        } catch (SQLException e) {
            Logger.getLogger(kursController.class.getName()).log(Level.SEVERE, (String)null, e);
        }
        this.persontable.setCellValueFactory(new PropertyValueFactory<>("person_id"));
        //this.kursename.setCellValueFactory(new PropertyValueFactory<>("kursename"));
        //this.kursepreis.setCellValueFactory(new PropertyValueFactory<>("preis"));
        //this.kursetag.setCellValueFactory(new PropertyValueFactory<>("tage"));
        //this.kursetrainer.setCellValueFactory(new PropertyValueFactory<>("trainer"));
        //this.kurseanzahl.setCellValueFactory(new PropertyValueFactory<>("anzahlSportler"));
        //this.kursebeginn.setCellValueFactory(new PropertyValueFactory<>("beginn"));
        //this.kurseend.setCellValueFactory(new PropertyValueFactory<>("end"));


        listPerson = dbControl.getDataperson();
        System.out.println(listPerson);
        this.persontable.setItems(listPerson);


    }



    //@FXML

    /*private void updatePerson() throws IOException{
        String id = editid.getText();


          person.setId(id);


          dbControl.updatePerson(person);

    }*/
    /**/
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
