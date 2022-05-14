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


    /*public static Connection connectt() throws SQLException {
        String url = "jdbc:sqlite:D:\\demo\\sqlite3\\database.db";
        Connection con = DriverManager.getConnection(url);
        return con;
    }*/

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


    public static Boolean containIdKurse(String id){
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

    }

    public static ObservableList<Kurse> getDatakurse(){

        Connection conn = connect();
        ObservableList<Kurse> kurselist = FXCollections.observableArrayList();
        try{
            Statement stmt = conn.createStatement();
            //PreparedStatement ps = conn.prepareStatement("SELECT * FROM kurse");
            ResultSet rs = stmt.executeQuery("SELECT * FROM kurse");

            while(rs.next()){
                //System.out.println(rs.getString("kurse_id") + rs.getString("kurse_name") + rs.getInt("kurse_preis") + rs.getString("kurse_tage") + " " + rs.getString("trainer_id") + " " + rs.getInt("kurse_anzahlSportler") + rs.getInt("beginn") + rs.getInt("end"));
                kurselist.add(new Kurse(rs.getString("kurse_id"),rs.getString("kurse_name"),rs.getInt("kurse_preis"),rs.getString("kurse_tage"),rs.getString("trainer_id"),rs.getInt("kurse_anzahlSportler"),rs.getInt("beginn"),rs.getInt("end")));
            }
        } catch(Exception e){

        }
        //System.out.println(kurselist);
        return kurselist;
    }


    /*public static void deleteDataKurse() throws SQLException {
        //conn = database.connect();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("DELETE FROM kurse WHERE kurse_id = *");

        //String sql = "DELETE FROM kurse WHERE kurse_id = ?";
        try{
            //pst = conn.prepareStatement(sql);
            //pst.setString(1, txt_id.getText());
            //pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Delete");
            //UpdateTable();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/




}

