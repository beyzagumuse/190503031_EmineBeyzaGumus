package com.example.demo;

import com.example.demo.Classes.Kurse;
import com.example.demo.Classes.Person;
import com.example.demo.Classes.database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

import static com.example.demo.Classes.database.connect;

public class dbControl {

    database db = new database();
    public static Statement stmt;
    public  static PreparedStatement pstmt;

    public static PreparedStatement pstmt2;
    public  static ResultSet rs;

    public static Connection conn = database.connect();

    public static void addKurse(int kurse_id, String kurse_name, int kurse_preis,String kurse_tage, String trainer_id,int kurse_anzahlSportler, int beginn,int end) {
        String query = "INSERT INTO kurse(kurse_id,kurse_name,kurse_preis,kurse_tage,trainer_id,kurse_anzahlSportler,beginn,end) VALUES(?,?,?,?,?,?,?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setInt(1, kurse_id);
            pstmt.setString(2, kurse_name);
            pstmt.setInt(3, kurse_preis);
            pstmt.setString(4,kurse_tage);
            pstmt.setString(5,trainer_id);
            pstmt.setInt(6,kurse_anzahlSportler);
            pstmt.setInt(7,beginn);
            pstmt.setInt(8,end);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printKurseData(int kurse_id) {
        String query = "SELECT * FROM kurse WHERE kurse_id = ?";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
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


    public static ObservableList<Person> getDataperson(){

        Connection conn = connect();
        ObservableList<Person> personlist = FXCollections.observableArrayList();
        try{
            Statement stmt = conn.createStatement();
            //PreparedStatement ps = conn.prepareStatement("SELECT * FROM kurse");
            ResultSet rs = stmt.executeQuery("SELECT person_id FROM person");

            while(rs.next()){
                //System.out.println(rs.getString("kurse_id") + rs.getString("kurse_name") + rs.getInt("kurse_preis") + rs.getString("kurse_tage") + " " + rs.getString("trainer_id") + " " + rs.getInt("kurse_anzahlSportler") + rs.getInt("beginn") + rs.getInt("end"));
                //kurselist.add(new Kurse(rs.getInt("kurse_id"),rs.getString("kurse_name"),rs.getInt("kurse_preis"),rs.getString("kurse_tage"),rs.getString("trainer_id"),rs.getInt("kurse_anzahlSportler"),rs.getInt("beginn"),rs.getInt("end")));
            }
        } catch(Exception e){

        }
        //System.out.println(kurselist);
        return personlist;
    }




    public static void deleteKurse(int kurse_id) {
        String query = "DELETE FROM kurse WHERE kurse_id = ?";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setInt(1, kurse_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void editKurseId(int kurse_id) {
        String query = "UPDATE kurse SET kurse_id = '"+kurse_id+"'";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            //pstmt.setInt(1, kurse_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }





    public static void addAdmin(String benutzename, String password) {
        String query = "INSERT INTO benutzer(benutzename,password) VALUES(?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1, benutzename);
            pstmt.setString(2, password);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void printBenutzerData(String benutzename) {
        String query = "SELECT * FROM benutzer WHERE benutzename = ?";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1, benutzename);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("benutzename:" + rs.getString("benutzename") + "|" + "password:" + rs.getString("password") );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public static void deleteAdmin(String benutzename) {
        String query = "DELETE FROM benutzer WHERE benutzename = ?";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1, benutzename);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void addSportler(int personid, String personname, String telno ,String adresse, String email,int muskel, int fettrate,String krank) {
        String query = "INSERT INTO person(person_id,person_name,person_telno,person_adresse,person_email) VALUES(?,?,?,?,?)";
        String query2 = "INSERT INTO sportler(sportler_muskelv,sportler_fettrate,sportler_krankheit) VALUES (?,?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt2 = dbControl.conn.prepareStatement(query2);
            pstmt.setInt(1, personid);
            pstmt.setString(2, personname);
            pstmt.setString(3, telno);
            pstmt.setString(4,adresse);
            pstmt.setString(5,email);
            pstmt2.setInt(6,muskel);
            pstmt2.setInt(7,fettrate);
            pstmt2.setString(8,krank);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void addPerson(int person_id, String person_name, String person_nachname, String person_telno, String person_adresse, String person_mail) {
        String query = "INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) VALUES(?,?,?,?,?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setInt(1, person_id);
            pstmt.setString(2, person_name);
            pstmt.setString(3, person_nachname);
            pstmt.setString(4, person_telno);
            pstmt.setString(5,person_adresse);
            pstmt.setString(6,person_mail);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



   /* public static void updatePerson(Person person) {

        String person_id = "UPDATE person SET person_id = '" +person.getId() ;
        //String telefonnummer = "UPDATE Kunde SET Telefonnummer ='"+ kunde.getTelefonnummer() + "' WHERE TrId=" + kunde.getId();
        //String vorstrafen = "UPDATE Kunde SET VorstrafenNote = '"+ kunde.getVorstrafeNote() + "' WHERE TrId=" + kunde.getId();
        //String name = "UPDATE Kunde SET Name= '" + kunde.getName() + "' WHERE TrId=" + kunde.getId();
        //String nachname = "UPDATE Kunde SET Nachname= '" + kunde.getNachname()+ "' WHERE TrId=" + kunde.getId();


        try {
            Statement statement = conn.createStatement();
            statement.execute(person_id);
            //statement.execute(telefonnummer);
            //statement.execute(vorstrafen);
            //statement.execute(name);
            //statement.execute(nachname);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /*
    public static void updatePerson(Person p) {

        String id = "UPDATE person SET person_id = '" +p.getId() + "' WHERE person_id =  " + p.getId();
        //String telefonnummer = "UPDATE Mitarbeiter SET Telefonnummer ='"+ m.getTelefonnummer() + "' WHERE TrId=" + m.getId();
        //String name ="UPDATE Mitarbeiter SET Name ='"+ m.getName() + "' WHERE TrId=" + m.getId();
        //String nachname = "UPDATE Mitarbeiter SET Nachname ='"+ m.getNachname() + "' WHERE TrId=" + m.getId();

        try {
            Statement statement = conn.createStatement();
            statement.execute(id);
            //statement.execute(telefonnummer);
            //statement.execute(name);
            //statement.execute(nachname);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
