package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class deletekursController {

    private HelloApplication application;


    @FXML
    private TextField id_deletekurs;

    /*@FXML
    void buttondelete(ActionEvent event) throws Exception {

        try {
           /* if (database.containIdKurse(id_deletekurs.getText())) {
                kursController kc = new kursController();
                ObservableList<Kurse> allKurse, oneKurse;
                allKurse = kc.getKursetable().getItems();
                oneKurse = kc.getKursetable().getSelectionModel().getSelectedItems();
                oneKurse.forEach(allKurse::remove);
            } else {
                System.out.println("Bu id'ye sahip bir kurs bulunmamaktadır.");
            }
        }catch(Exception e){

            //JOptionPane.showMessageDialog(null, e);

        }
    }*/





   /* Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;*/

    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }

   /* @FXMLbeyza
    public void deleteOk(){
        conn = database.connect();
        String sql = "DELETE FROM kurse WHERE kurse_id = ?";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Delete");
            //UpdateTable();


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    /*public void initialize(URL url, ResourceBundle rb){}*/

    /*Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Statement stm ;

    @FXML
    private void delete(MouseEvent event) throws SQLException {
        this.connection = database.connect();
        stm = connection.createStatement();
        String sql = "DELETE FROM kurse WHERE kurse_id = ?";
        resultSet = stm.executeQuery(sql);


    }*/



    /*public void deleteOk() throws SQLException {
        database.deleteDataKurse();
    }*/



}
