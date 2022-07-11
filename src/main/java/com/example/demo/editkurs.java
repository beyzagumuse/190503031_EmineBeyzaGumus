package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;

public class editkurs {

    private HelloApplication application;
    @FXML
    private TextField editKursID;

    @FXML
    private TextField edit_trainer;

    @FXML
    private TextField edittage;

    @FXML
    private TextField editanzahl;

    @FXML
    private TextField editbeginn;

    @FXML
    private TextField editend;

    @FXML
    private TextField editname;

    @FXML
    private TextField editpreis;

    @FXML
    private DatePicker edittag;

    @FXML
    private ComboBox<?> edittrainer;


    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }

    /*public void edit(){
        try{
            Connection conn = database.connect();
            String value1 = editKursID.getText();
            String value2 = editname.getText();
            String value3 = editpreis.getText();
            String value4 = edittage.getText();
            String value5 = edit_trainer.getText();
            String value6 = editanzahl.getText();
            String value7 = editbeginn.getText();
            String value8 = editend.getText();
            String sql = "update kurse set "
        }
    }*/

    @FXML
    private void editKurseId() throws IOException {
        dbControl.printKurseData(Integer.parseInt(editKursID.getText()));
        dbControl.editKurseId(Integer.parseInt(editKursID.getText()));
        System.out.println("Kurs Id'si değiştirildi.");
        goKurspage();
        //
    }

}
