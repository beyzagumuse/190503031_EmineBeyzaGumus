package com.example.demo;

import com.example.demo.Classes.Kurse;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    private AnchorPane editpane;


    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }


    private Kurse kurs;
    public void editInfo(Kurse kurs) {
        this.kurs = kurs;
        setInfos(kurs);
    }

    public void setInfos(Kurse a) {
        editKursID.setText(a.getKursenummer());
        editname.setText(a.getKursename());
        editpreis.setText("" + a.getPreis());
        edittage.setText(a.getTage());
        edit_trainer.setText((a.getTrainer()));
        editanzahl.setText(Integer.toString(a.getAnzahlSportler()));
        editbeginn.setText(Integer.toString(a.getBeginn()));
        editend.setText(Integer.toString(a.getEnd()));

    }

    public void saveInfos() {
        String id = editKursID.getText();
        String name = editname.getText();
        int preis = Integer.parseInt(editpreis.getText());
        String tag = edittage.getText();
        String trainer = edit_trainer.getText();
        int anzahl = Integer.parseInt(editanzahl.getText());
        int beginn = Integer.parseInt(editbeginn.getText());
        int end = Integer.parseInt(editend.getText());

        kurs.setKursenummer(id);
        kurs.setKursename(name);
        kurs.setPreis(preis);
        kurs.setTage(tag);
        kurs.setTrainer(trainer);
        kurs.setAnzahlSportler(anzahl);
        kurs.setBeginn(beginn);
        kurs.setEnd(end);


        dbControl.updateKurse(kurs);
        //AutoScreenController.asc.autoList();


        Stage s = (Stage) editpane.getScene().getWindow();
        s.close();

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
        dbControl.printKurseData((editKursID.getText()));
        dbControl.editKurseId(Integer.parseInt(editKursID.getText()));
        System.out.println("Kurs Id'si değiştirildi.");
        goKurspage();
        //
    }

}
