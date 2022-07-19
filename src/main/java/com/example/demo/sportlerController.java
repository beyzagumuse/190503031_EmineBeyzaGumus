package com.example.demo;

import com.example.demo.Classes.Person;
import com.example.demo.Classes.Sportler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class sportlerController {



    @FXML
    private AnchorPane addSportlerpane;

    @FXML
    private AnchorPane deleteSportlerpane;

    @FXML
    private AnchorPane editsportlerpane;

    @FXML
    private Button detailsclose;

    @FXML
    private AnchorPane detailspane;




    @FXML
    private TextField addsportleradresse;

    @FXML
    private TextField addsportlerfr;

    @FXML
    private TextField addsportlerid;

    @FXML
    private TextField addsportlerkrank;

    @FXML
    private TextField addsportlermail;

    @FXML
    private TextField addsportlermv;

    @FXML
    private TextField addsportlername;

    @FXML
    private TextField addsportlertelno;

    @FXML
    private TableView<Sportler> allpersonview;

    @FXML
    private TableColumn<Sportler, Integer> fett_col;


    @FXML
    private TableColumn<Sportler, String> add_col;

    @FXML
    private TableColumn<Sportler, String> krank_col;

    @FXML
    private TableColumn<Sportler, String> mail_col;

    @FXML
    private TableColumn<Sportler, Integer> muskel_col;

    @FXML
    private TableColumn<Sportler, String> nachname_col;

    @FXML
    private TableColumn<Sportler, String> name_col;
    @FXML
    private TableColumn<Sportler, String> persontable;

    @FXML
    private TableView<Sportler> persontableview;

    @FXML
    private TableColumn<Sportler, Integer> schuld_col;

    @FXML
    private TableColumn<Sportler, String> tc_col;

    @FXML
    private TableColumn<Sportler, String> telno_col;

    @FXML
    private TextField addsportlernachname;


    @FXML
    private TextField addsportlerschuld;


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
    private Button detailsclose1;


    @FXML
    private AnchorPane detailspane1;

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
    private TableColumn<Sportler, String> email_col;


    @FXML
    private Button finishaddsportler;

    @FXML
    private Button finishaddtrainer;

    @FXML
    private Button home_btn;


    @FXML
    private AnchorPane personpane;


    @FXML
    private TextField textfieldname;


    @FXML
    private Button homebtn;
    HelloApplication application;

    @FXML
    private void goHomepage() throws IOException {
        application.showHomepageScene();
    }


    @FXML
    private void goBackk() throws IOException{
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("personchoice.fxml"));
            personpane.getChildren().setAll(pane);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }



    @FXML
    void goaddSportler() {
        addSportlerpane.setVisible(true);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    private void addSportler() throws IOException {
        dbControl.addSportler((addsportlerid.getText()), addsportlername.getText(),addsportlernachname.getText(),addsportlertelno.getText(),addsportleradresse.getText(),addsportlermail.getText(),Integer.parseInt(addsportlerschuld.getText()),addsportlerkrank.getText(),Integer.parseInt(addsportlermv.getText()),Integer.parseInt(addsportlerfr.getText()));
        //dbControl.printSportlerData(Integer.parseInt(addsportlerid.getText()));

        System.out.println("Sportler wurde zum Datenbank addiert.");

    }

    @FXML
    void godeleteSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(true);
        editsportlerpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    void goeditSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(true);
        detailspane.setVisible(false);
    }

    @FXML
    void godetailsSportler() {
        addSportlerpane.setVisible(false);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(false);
        detailspane.setVisible(true);
    }

    @FXML
    void closedetails(){
        closePane(detailspane);
    }

    @FXML
    void closePane(AnchorPane pane) {
        pane.setVisible(false);
    }




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


    ObservableList<Sportler> data = FXCollections.observableArrayList();

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
    public void initialize() {


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



        data = dbControl.getDatasportler();
        System.out.println(data);
        this.allpersonview.setItems(data);

        allpersonview.setEditable(true);
        name_col.setCellFactory(TextFieldTableCell.forTableColumn());
        nachname_col.setCellFactory(TextFieldTableCell.forTableColumn());
        telno_col.setCellFactory(TextFieldTableCell.forTableColumn());
        add_col.setCellFactory(TextFieldTableCell.forTableColumn());
        mail_col.setCellFactory(TextFieldTableCell.forTableColumn());


    }





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

        Sportler p = new Sportler(addsportlerid.getText(),addsportlername.getText(),addsportlernachname.getText(),addsportlertelno.getText(),addsportleradresse.getText(),addsportlermail.getText(),Integer.parseInt(addsportlerschuld.getText()),addsportlerkrank.getText(),Integer.parseInt(addsportlermv.getText()),Integer.parseInt(addsportlerfr.getText()));
        persontableview.getItems().add(p);
        dbControl.add_Sportler(p);

    }
    @FXML
    void detailsaction() {
        Sportler person = new Sportler();

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
        ObservableList<Sportler> allPerson, SinglePerson;
        allPerson = allpersonview.getItems();
        SinglePerson = allpersonview.getSelectionModel().getSelectedItems();

        Sportler person = allpersonview.getSelectionModel().getSelectedItem();
        System.out.println(person.getSportlernummer());

        String a = person.getSportlernummer();
        SinglePerson.forEach(allPerson::remove);
        dbControl.delete_Person((a));
    }

    @FXML
    void oneditchange(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Sportler person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateSportler(person);
    }

    @FXML
    void oneditchange2(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

         Sportler person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateSportler(person);
    }
    @FXML
    void oneditchange3(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Sportler person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateSportler(person);
    }

    @FXML
    void oneditchang4(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Sportler person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateSportler(person);
    }

    @FXML
    void oneditchange5(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Sportler person = allpersonview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateSportler(person);
    }


}

