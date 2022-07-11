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

    /*public void editInfo(Person person) {
        p = person;
        setInfos(p);
    }

    public void setInfos(Person p) {
        editid.setText(p.getId());
        //gdLabel.setText(m.getGeburtsdatumString());
        //geschlechtLabel.setText(m.getGeschlecht());
        //idLabel.setText(m.getId());
        //nameField.setText(m.getName());
        //nachnameField.setText(m.getNachname());
        //rolleLabel.setText(m.getRolle());
        //adressField.setText(m.getAdresse());
        //telefonField.setText(m.getTelefonnummer());
    }

    public void saveInfos() throws IOException {

        String id = editid.getText();
        //String name = nameField.getText();
        //String nname = nachnameField.getText();
        //String telefon = telefonField.getText();
        //String adress = adressField.getId();


        /*if(bn.isEmpty() || name.isEmpty() || nname.isEmpty() || telefon.isEmpty() || adress.isEmpty()) {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pop-up.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            PopUpController popUpController = fxmlLoader.getController();
            popUpController.setMessage("Bitte geben Sie Infos vollständig ein!");
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Warnung!");
            stage.setScene(scene);
            stage.show();

        }else if(Person.checkTelefon(telefon) == false) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pop-up.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            PopUpController popUpController = fxmlLoader.getController();
            popUpController.setMessage("Das Format von eingegebene Telefonnummer ist falsch.");
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Warnung!");
            stage.setScene(scene);
            stage.show();
        } else {*/

            //p.setId(id);
            //mit.setTelefonnummer(telefon);
            //mit.setName(name);
            //mit.setNachname(nname);
            //mit.setBenutzername(bn);

            //DBautovermietung.updateBenutzername(mit.getId(), bn);
             //dbControl.updatePerson(p);
            //MitarbeiterScreenController.mitarbeitersc.mitarbeiterListe();

            //Stage s = (Stage) pane.getScene().getWindow();
            //s.close();

    //}
    /**/


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
