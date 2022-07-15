package com.example.demo;

import com.example.demo.Classes.Sportler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

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
    private TableColumn<Sportler, Integer> telno_col;

    @FXML
    private TextField addsportlernachname;


    @FXML
    private TextField addsportlerschuld;


    @FXML
    void goaddSportler() {
        addSportlerpane.setVisible(true);
        deleteSportlerpane.setVisible(false);
        editsportlerpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    private void addSportler() throws IOException {
        dbControl.addSportler(Integer.parseInt(addsportlerid.getText()), addsportlername.getText(),addsportlernachname.getText(),addsportlertelno.getText(),addsportleradresse.getText(),addsportlermail.getText(),Integer.parseInt(addsportlerschuld.getText()),addsportlerkrank.getText(),Integer.parseInt(addsportlermv.getText()),Integer.parseInt(addsportlerfr.getText()));
        //dbControl.printSportlerData(Integer.parseInt(addsportlerid.getText()));

        System.out.println("Person wurde zum Datenbank addiert.");

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
/*
    @FXML
    void buttonadd() {

        Sportler p = new Sportler(addsportlerid.getText(),addsportlername.getText(),addsportlernachname.getText(),addsportlertelno.getText(),addsportleradresse.getText(),addsportlermail.getText(),addsportlerschuld.getText(),addsportlerkrank.getText(),addsportlermv.getText(),addsportlerfr.getText());
        persontableview.getItems().add(p);
        dbControl.add_Person(p);

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

    }*/
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
/*
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
        System.out.println(p.getName());
        person.setId(personStringCellEditEvent.getNewValue());
        person.setName(personStringCellEditEvent.getNewValue());
        person.setNachname(personStringCellEditEvent.getNewValue());
        person.setTelno(personStringCellEditEvent.getNewValue());
        person.setAdresse(personStringCellEditEvent.getNewValue());
        person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updatePerson(person);
    }./

/*
    @FXML
    void oneditchange(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Person person = persontableview.getSelectionModel().getSelectedItem();
        person.setName(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updatePerson(person);
    }*/



}

