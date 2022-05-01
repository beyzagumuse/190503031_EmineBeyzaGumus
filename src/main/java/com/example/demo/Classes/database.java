package com.example.demo.Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;


public class database {

    public static Connection conn = null;
    public static Connection connect() {


        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\demo\\sqlite3\\database.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT kurse_name,kurse_preis FROM kurse");
            if (res.next()) {
                System.out.println("username: " + res.getString("kurse_name") + " Preis: " + res.getString("kurse_preis"));
            }

            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ObservableList<Kurse> getDatakurse(){

        Connection conn = connect();
        ObservableList<Kurse> kurselist = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM kurse");
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                kurselist.add(new Kurse(rs.getString("kurse_id"),rs.getString("kurse_name"),rs.getInt("kurse_preis"),rs.getDate("kurse_tage"),rs.getString("trainer_id"),rs.getInt("kurse_anzahlSportler"),rs.getInt("kurse_beginn"),rs.getInt("kurse_end")));
            }
        } catch(Exception e){

        }
        return null;
    }
}
