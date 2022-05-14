package com.example.demo;

import com.example.demo.Classes.database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class deletekursController implements Initializable {

    private HelloApplication application;

    @FXML
    private TextField txt_id;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private void goKurspage() throws IOException {
        application.showKurseScene();
    }

   /* @FXML
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

    public void initialize(URL url, ResourceBundle rb){}

    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement;
    Statement stm ;

    @FXML
    private void delete(MouseEvent event) throws SQLException {
        this.connection = database.connect();
        stm = connection.createStatement();
        String sql = "DELETE FROM kurse WHERE kurse_id = ?";
        resultSet = stm.executeQuery(sql);


    }



    /*public void deleteOk() throws SQLException {
        database.deleteDataKurse();
    }*/



}
