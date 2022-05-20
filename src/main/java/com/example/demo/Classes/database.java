package com.example.demo.Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;


public class database {


    public static Statement stmt;
    public  static PreparedStatement pstmt;
    public  static ResultSet rs;

    public static Connection conn = null;
    public static Connection connect() {


        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\demo\\sqlite3\\database.db";
            // create a connection to the database
            conn = getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            /*Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT kurse_name,kurse_preis FROM kurse");
            if (res.next()) {
                System.out.println("username: " + res.getString("kurse_name") + " Preis: " + res.getString("kurse_preis"));
            }*/

            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



    public static void addKurse(int kurse_id, String kurse_name, int kurse_preis) {
        String query = "INSERT INTO kurse(kurse_id,kurse_name,kurse_preis) VALUES(?,?,?)";

        try {
            pstmt = database.conn.prepareStatement(query);
            pstmt.setInt(1, kurse_id);
            pstmt.setString(2, kurse_name);
            pstmt.setInt(3, kurse_preis);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printKurseData(int kurse_id) {
        String query = "SELECT * FROM kurse WHERE kurse_id = ?";

        try {
            pstmt = database.conn.prepareStatement(query);
            pstmt.setInt(1, kurse_id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("kurse_id:" + rs.getInt("kurse_id") + "|" + "Kursename:" + rs.getString("kurse_name") + "|" + "Preis:" + rs.getInt("kurse_preis"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


        public static Boolean containBenutzer(String userName, String pass){
        //this.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT benutzename , password FROM benutzer");
            while (res.next()){
                String s1 = res.getString("benutzename");
                String s2 = res.getString("password");
                if(s1.equals(userName) && s2.equals(pass)){
                    return true;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;

    }


    /*public static Boolean containIdKurse(String id){
        //this.connect();
        try {
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT kurse_id FROM kurse");
            while (res.next()){
                String s1 = res.getString("kurse_id");
                if(s1.equals(id)){
                    return true;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return false;

    }*/

    public static ObservableList<Kurse> getDatakurse(){

        Connection conn = connect();
        ObservableList<Kurse> kurselist = FXCollections.observableArrayList();
        try{
            Statement stmt = conn.createStatement();
            //PreparedStatement ps = conn.prepareStatement("SELECT * FROM kurse");
            ResultSet rs = stmt.executeQuery("SELECT * FROM kurse");

            while(rs.next()){
                //System.out.println(rs.getString("kurse_id") + rs.getString("kurse_name") + rs.getInt("kurse_preis") + rs.getString("kurse_tage") + " " + rs.getString("trainer_id") + " " + rs.getInt("kurse_anzahlSportler") + rs.getInt("beginn") + rs.getInt("end"));
                kurselist.add(new Kurse(rs.getInt("kurse_id"),rs.getString("kurse_name"),rs.getInt("kurse_preis"),rs.getString("kurse_tage"),rs.getString("trainer_id"),rs.getInt("kurse_anzahlSportler"),rs.getInt("beginn"),rs.getInt("end")));
            }
        } catch(Exception e){

        }
        //System.out.println(kurselist);
        return kurselist;
    }





    public static void deleteKurse(int kurse_id) {
        String query = "DELETE FROM kurse WHERE kurse_id = ?";

        try {
            pstmt = database.conn.prepareStatement(query);
            pstmt.setInt(1, kurse_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void createKurse(Kurse s) {
        try {
            Statement st = connect().createStatement();
            st.execute("INSERT INTO kurse (kurse_id,kurse_name) VALUES('" + s.getId()
                    + "','" + s.getName() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
    }






}

