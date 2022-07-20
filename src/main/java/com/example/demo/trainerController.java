package com.example.demo;

import com.example.demo.Classes.Person;
import com.example.demo.Classes.Trainer;
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

public class trainerController {

    @FXML
    private TextField addadresse1;

    @FXML
    private TextField addid1;

    @FXML
    private TextField addmail1;

    @FXML
    private TextField addname1;

    @FXML
    private TextField addtel1;

    @FXML
    private TextField addnachname;

    @FXML
    private AnchorPane addtrainerpane;

    @FXML
    private AnchorPane deletetrainerpane;

    @FXML
    private Button detailsclose;

    @FXML
    private AnchorPane detailspane;

    @FXML
    private AnchorPane edittrainerpane;

    @FXML
    private Button finishaddtrainer;

    @FXML
    private Button homebtn;

    @FXML
    private AnchorPane personpane;

    @FXML
    private TableColumn<Trainer, String> idcol;

    @FXML
    private TableColumn<Trainer, String> mailcol;

    @FXML
    private TableColumn<Trainer, String> namecol;

    @FXML
    private TableColumn<Trainer, String> nnamecol;

    @FXML
    private TableColumn<Trainer, String> addcol;

    @FXML
    private TableColumn<Trainer, String> telcol;

    @FXML
    private TableView<Trainer> trainerview;


    HelloApplication application;

    public void initialize(){

        idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nnamecol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        telcol.setCellValueFactory(new PropertyValueFactory<>("telno"));
        addcol.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        mailcol.setCellValueFactory(new PropertyValueFactory<>("email"));
        trainerview.setItems(ListPersonal());

        trainerview.setEditable(true);

        namecol.setCellFactory(TextFieldTableCell.forTableColumn());
        nnamecol.setCellFactory(TextFieldTableCell.forTableColumn());
        telcol.setCellFactory(TextFieldTableCell.forTableColumn());
        addcol.setCellFactory(TextFieldTableCell.forTableColumn());
        mailcol.setCellFactory(TextFieldTableCell.forTableColumn());



    }

    public ObservableList ListPersonal(){
        ObservableList arr = dbControl.listTrainer();
        return arr;
    }
    @FXML
    void buttonadd() {

        Trainer p = new Trainer(addid1.getText(),addname1.getText(),addnachname.getText(),addtel1.getText(),addadresse1.getText(),addmail1.getText());
        trainerview.getItems().add(p);
        dbControl.add_Trainer(p);

    }

    @FXML
    private TextField deletefield;

    @FXML
    private void deleteTrainer() throws IOException {
        //dbControl.printKurseData(Integer.parseInt(id_deletekurs.getText()));
        dbControl.deleteTrainer((deletefield.getText()));
        System.out.println("Trainer wurde vom Datenbank geloescht.");
        //goKurspage();
    }



    @FXML
    void goPersonChoice() throws IOException {
        application.showHomepageScene();
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



    @FXML
    void closedetails(){
        closePane(detailspane);
    }

    @FXML
    void closePane(AnchorPane pane) {
        pane.setVisible(false);
    }

    @FXML
    void deleteaction() {
        ObservableList<Trainer> allPerson, SinglePerson;
        allPerson = trainerview.getItems();
        SinglePerson = trainerview.getSelectionModel().getSelectedItems();

        Trainer person = trainerview.getSelectionModel().getSelectedItem();
        System.out.println(person.getId());

        String a = person.getId();
        SinglePerson.forEach(allPerson::remove);
        dbControl.delete_Trainer((a));
    }


    @FXML
    void oneditchange(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Trainer person = trainerview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateTrainer(person);
    }

    @FXML
    void oneditchange2(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Trainer person = trainerview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateTrainer(person);
    }

    @FXML
    void oneditchange3(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Trainer person = trainerview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateTrainer(person);
    }

    @FXML
    void oneditchange4(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Trainer person = trainerview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateTrainer(person);
    }

    @FXML
    void oneditchange5(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Trainer person = trainerview.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        //person.setName(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateTrainer(person);
    }




}
