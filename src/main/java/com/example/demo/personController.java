package com.example.demo;

import com.example.demo.Classes.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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


    @FXML
    private TableColumn<Person, String> tc_col;

    @FXML
    private TableColumn<Person, String> telno_col;

    @FXML
    private TableColumn<Person, String> mail_col;

    @FXML
    private TableColumn<Person, String> nachname_col;

    @FXML
    private TableColumn<Person, String> name_col;


    @FXML
    private TableColumn<Person, String> add_col;

    @FXML
    private TableView<Person> allpersonview;






    private Person p;


    @FXML
    void goaddPerson() throws IOException {
        //addpersonpane.setVisible(true);
        //deletepersonpane.setVisible(false);
        //editpersonpane.setVisible(false);
        //detailspane.setVisible(false);
        application.showPersonAddScene();
    }

    @FXML
    private void addPerson() throws IOException {
        dbControl.addPerson(((addid.getText())), addname.getText(),addnachname.getText(),addtel.getText(),addadresse.getText(),addmail.getText());
        //dbControl.printKurseData((addid.getText()));

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


    @FXML
    private AnchorPane personpane;

    @FXML
    private void goBack() throws IOException{
        try {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("personchoice.fxml"));
           personpane.getChildren().setAll(pane);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    ObservableList<Person> data = FXCollections.observableArrayList();

    /*
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
    */

    @FXML
    public void initializee() {


        /*
        try {
            Connection conn = database.connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM person");

            while (rs.next()) {
                this.data.add(new Person(rs.getString("person_id"),rs.getString("person_name"),rs.getString("person_nachname"),rs.getString("person_telno"),rs.getString("person_adresse"),rs.getString("person_email")));
            }
        } catch (SQLException e) {
            Logger.getLogger(kursController.class.getName()).log(Level.SEVERE, (String)null, e);
        }*/
        dbControl.initPerson();

        tc_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        nachname_col.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        telno_col.setCellValueFactory(new PropertyValueFactory<>("telno"));
        add_col.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail_col.setCellValueFactory(new PropertyValueFactory<>("email"));



        data = dbControl.getDataperson();
        System.out.println(data);
        this.allpersonview.setItems(data);

        allpersonview.setEditable(true);
        name_col.setCellFactory(TextFieldTableCell.forTableColumn());
        nachname_col.setCellFactory(TextFieldTableCell.forTableColumn());
        telno_col.setCellFactory(TextFieldTableCell.forTableColumn());
        add_col.setCellFactory(TextFieldTableCell.forTableColumn());
        mail_col.setCellFactory(TextFieldTableCell.forTableColumn());


    }


    public void initialize(){

        tc_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        nachname_col.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        telno_col.setCellValueFactory(new PropertyValueFactory<>("telno"));
        add_col.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mail_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        allpersonview.setItems(ListPersonal());
    }

    @FXML
    public ObservableList ListPersonal(){
        ObservableList arr = dbControl.listPersonal();
        return arr;
    }



    @FXML
    private TextField textfieldname;

/*
    @FXML
    void buttonadd() {

        Person p = new Person(textfieldname.getText());
        persontableview.getItems().add(p);
        dbControl.add_Person(p);

    }

*/

    @FXML
    void buttonadd() {

        Person p = new Person(addid.getText(),addname.getText(),addnachname.getText(),addtel.getText(),addadresse.getText(),addmail.getText());
        persontableview.getItems().add(p);
        dbControl.add_Personal(p);

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

    public void personList(){

    }
/*
    @FXML
    void deleteaction() {
        ObservableList<Person> allPerson, SinglePerson;
        allPerson = persontableview.getItems();
        SinglePerson = persontableview.getSelectionModel().getSelectedItems();

        Person person = persontableview.getSelectionModel().getSelectedItem();
        System.out.println(person.getId());

        String a = person.getId();
        SinglePerson.forEach(allPerson::remove);
        dbControl.delete_Person((a));
    }*/

    @FXML
    void deleteaction() {
        ObservableList<Person> allPerson, SinglePerson;
        allPerson = allpersonview.getItems();
        SinglePerson = allpersonview.getSelectionModel().getSelectedItems();

        Person person = allpersonview.getSelectionModel().getSelectedItem();
        System.out.println(person.getId());

        String a = person.getId();
        SinglePerson.forEach(allPerson::remove);
        dbControl.delete_Person((a));
    }

    @FXML
    void oneditchange(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Person person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updatePerson(person);
    }

    @FXML
    void oneditchange2(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Person person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updatePerson(person);
    }
    @FXML
    void oneditchange3(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Person person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updatePerson(person);
    }

    @FXML
    void oneditchang4(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Person person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updatePerson(person);
    }

    @FXML
    void oneditchange5(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Person person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updatePerson(person);
    }

/*
    @FXML
    void oneditchange(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Person person = persontableview.getSelectionModel().getSelectedItem();
        person.setName(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updatePerson(person);
    }*/


}
