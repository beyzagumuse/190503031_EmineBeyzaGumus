package com.example.demo;

import com.example.demo.Classes.Kurse;
import com.example.demo.Classes.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.time.LocalDate;

public class kursController {

    private HelloApplication application;

    @FXML
    private TableColumn<Kurse, Integer> kurseanzahl;

    @FXML
    private TableColumn<Kurse, Integer> kursebeginn;

    @FXML
    private TableColumn<Kurse, Integer> kurseend;

    @FXML
    private TableColumn<Kurse,Integer> kurseid;

    @FXML
    private TableColumn<Kurse, String> kursename;

    @FXML
    private TableColumn<Kurse, Integer> kursepreis;

    @FXML
    private TableColumn<Kurse, String> kursetag;

    @FXML
    private TableColumn<Kurse, String> kursetrainer;

    @FXML
    private TableView<Kurse> kursetable;

    public TableView<Kurse> getKursetable() {
        return kursetable;
    }


    @FXML
    private TextField kursid;

    @FXML
    private TextField kursname;

    @FXML
    private TextField kurspreis;

    @FXML
    private DatePicker kurstag;

    @FXML
    private TextField kursend;

    @FXML
    private TextField kursanzahl;

    @FXML
    private TextField kursbeginn;

    @FXML
    private TextField trainerid;

    @FXML
    private TextField editcheck;

    @FXML
    private void goHomepage() throws IOException {
        application.showHomepageScene();
    }

    @FXML
    private void goaddKurs() throws IOException {
        application.showaddKursScene();
    }

    @FXML
    private void godeleteKurs() throws IOException {
        application.showdeleteKursScene();
    }

    @FXML
    private void goeditKurs() throws IOException {
        application.showeditKursScene();
    }

    ObservableList<Kurse> listKurs = FXCollections.observableArrayList();

    //int index =-1;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

/*
    @FXML
    public void initialize() {

        /*
        try {
            Connection conn = database.connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM kursee");

            while (rs.next()) {
                this.listKurs.add(new Kurse(rs.getString("kurse_id"),rs.getString("kurse_name"),rs.getInt("kurse_preis"),rs.getString("kurse_tage"),rs.getString("trainer_id"),rs.getInt("kurse_anzahl"),rs.getInt("kurse_beginn"),rs.getInt("kurse_end")));
            }
        } catch (SQLException e) {
            Logger.getLogger(kursController.class.getName()).log(Level.SEVERE, (String)null, e);
        }*/
    /*
        this.kurseid.setCellValueFactory(new PropertyValueFactory<>("kursenummer"));
        this.kursename.setCellValueFactory(new PropertyValueFactory<>("kursename"));
        this.kursepreis.setCellValueFactory(new PropertyValueFactory<>("preis"));
        this.kursetag.setCellValueFactory(new PropertyValueFactory<>("tagg"));
        this.kursetrainer.setCellValueFactory(new PropertyValueFactory<>("trainer"));
        this.kurseanzahl.setCellValueFactory(new PropertyValueFactory<>("anzahlSportler"));
        this.kursebeginn.setCellValueFactory(new PropertyValueFactory<>("beginn"));
        this.kurseend.setCellValueFactory(new PropertyValueFactory<>("end"));


        listKurs = dbControl.getDatakurse();
        System.out.println(listKurs);
        this.kursetable.setItems(listKurs);

        kursetable.setEditable(true);
        kursename.setCellFactory(TextFieldTableCell.forTableColumn());
        //kursepreis.setCellFactory(TextFieldTableCell.forTableColumn());
        //kursetag.setCellFactory(TextFieldTableCell.forTableColumn());
        kursetrainer.setCellFactory(TextFieldTableCell.forTableColumn());
        //kursebeginn.setCellFactory(TextFieldTableCell.forTableColumn());
        //kurseend.setCellFactory(TextFieldTableCell.forTableColumn());

    }
    */

    public void initialize(){

        this.kurseid.setCellValueFactory(new PropertyValueFactory<>("kursenummer"));
        this.kursename.setCellValueFactory(new PropertyValueFactory<>("kursename"));
        this.kursepreis.setCellValueFactory(new PropertyValueFactory<>("preis"));
        //this.kursetag.setCellValueFactory(new PropertyValueFactory<>("tage"));
        this.kursetrainer.setCellValueFactory(new PropertyValueFactory<>("trainer"));
        this.kurseanzahl.setCellValueFactory(new PropertyValueFactory<>("anzahlSportler"));
        this.kursebeginn.setCellValueFactory(new PropertyValueFactory<>("beginn"));
        this.kurseend.setCellValueFactory(new PropertyValueFactory<>("end"));
        kursetable.setItems(ListKurse());



    }

    @FXML
    public ObservableList ListKurse(){
        ObservableList arr = dbControl.getDatakurse();
        return arr;
    }

    @FXML
    void oneditchange(TableColumn.CellEditEvent<Person,String> personStringCellEditEvent) {

        Kurse kurse = kursetable.getSelectionModel().getSelectedItem();
        //System.out.println(p.getName());
        //person.setId(personStringCellEditEvent.getNewValue());
        kurse.setKursename(personStringCellEditEvent.getNewValue());
        //person.setNachname(personStringCellEditEvent.getNewValue());
        //person.setTelno(personStringCellEditEvent.getNewValue());
        //person.setAdresse(personStringCellEditEvent.getNewValue());
        //person.setEmail(personStringCellEditEvent.getNewValue());
        //dbControl.editPerson(person);
        dbControl.updateKurs(kurse);
    }


    @FXML
    private void addKursee() throws IOException, ParseException {

        LocalDate mydate = kurstag.getValue();
        dbControl.addKursee(kursid.getText(),kursname.getText(),Integer.parseInt(kurspreis.getText()), Date.valueOf(mydate),trainerid.getText(),Integer.parseInt(kursanzahl.getText()),Integer.parseInt(kursbeginn.getText()),Integer.parseInt(kursend.getText()));
        //dbControl.printKurseData(Integer.parseInt(addKursId.getText()));

        System.out.println("Person wurde zum Datenbank addiert.");


    }

    @FXML
    void deleteaction() {
        ObservableList<Kurse> allPerson, SinglePerson;
        allPerson = kursetable.getItems();
        SinglePerson = kursetable.getSelectionModel().getSelectedItems();

        Kurse person = kursetable.getSelectionModel().getSelectedItem();
        System.out.println(person.getKursenummer());

        String a = person.getKursenummer();
        SinglePerson.forEach(allPerson::remove);
        dbControl.delete_Kurse((a));
    }


}
