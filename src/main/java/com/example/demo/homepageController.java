package com.example.demo;

import javafx.fxml.FXML;

import java.io.IOException;

public class homepageController {

    private HelloApplication application;

    /*@FXML
    private Button kurse_btn;

    @FXML
    private ComboBox<String> person_combobox;

    @FXML
    private Button rechnung_btn;

    ObservableList<String> person_comboboxList = FXCollections.observableArrayList("Personal", "Trainer", "Sportler");

    @FXML
    protected void initilaze(){
        person_combobox.setValue("Personal");
        person_combobox.setValue("Trainer");
        person_combobox.setValue("Sportler");
        person_combobox.setItems(person_comboboxList);
    }

    @FXML
    protected void kursebtnlogin(ActionEvent event) throws Exception {
        try {
            kurse_btn.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("mate.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e){

            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    protected void onRechnungButtonClick() {
        System.out.println("Hello its rechnung!");

    }

    @FXML
    protected void onKurseButtonClick() {
        System.out.println("Hello its kurse!");

    }



    @FXML
    protected void rechnungbtnlogin(ActionEvent event) throws Exception{
        try {
            rechnung_btn.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("mate.fxml"));
            Stage mainStage = new Stage();
            Scene scene = new Scene(root);
            mainStage.setScene(scene);
            mainStage.show();
        } catch (Exception e){

            JOptionPane.showMessageDialog(null, e);
        }
    }*/
    @FXML
    private void goKurse() throws IOException {
        application.showKurseScene();
    }

    @FXML
    private void goRechnung() throws IOException {
        application.showRechnungScene();
    }

    @FXML
    private void goPerson() throws IOException {
        application.showPersonScene();
    }



}