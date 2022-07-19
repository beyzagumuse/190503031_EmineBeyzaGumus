package com.example.demo;

import com.example.demo.Classes.Trainer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    void goaddTrainer() {
        addtrainerpane.setVisible(true);
        deletetrainerpane.setVisible(false);
        edittrainerpane.setVisible(false);
        detailspane.setVisible(false);
    }
    @FXML
    void godeleteTrainer() {
        addtrainerpane.setVisible(false);
        deletetrainerpane.setVisible(true);
        edittrainerpane.setVisible(false);
        detailspane.setVisible(false);
    }

    @FXML
    void goeditTrainer() {
        addtrainerpane.setVisible(false);
        deletetrainerpane.setVisible(false);
        edittrainerpane.setVisible(true);
        detailspane.setVisible(false);
    }

    @FXML
    void godetailsTrainer() {
        addtrainerpane.setVisible(false);
        deletetrainerpane.setVisible(false);
        edittrainerpane.setVisible(false);
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


}
