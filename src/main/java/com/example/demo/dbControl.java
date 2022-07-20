package com.example.demo;

import com.example.demo.Classes.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.demo.Classes.database.connect;

public class dbControl {

    database db = new database();
    public static Statement stmt;
    public  static PreparedStatement pstmt;

    public static PreparedStatement pstmt2;
    public  static ResultSet rs;

    public static Connection conn = database.connect();

    public static void addRechnung(Rechnung r) {
        String query = "INSERT INTO rechnung(rechnung_id,sportler_id,kurse_id,rechnung_kursetage,rechnung_preis) VALUES (?,?,?,?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1, r.getRechnungsnummer());
            pstmt.setString(2, r.getSportlernummer());
            pstmt.setString(3,r.getKursenummer());
            pstmt.setString(4,r.getKurseTage());
            pstmt.setInt(5,r.getPreis());

            pstmt.executeUpdate();
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


    //KURSE


    public static ArrayList<Kurse> getKurse() {
        ArrayList<Kurse> kurse = new ArrayList<>();
        SimpleDateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Statement stmt = dbControl.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM kursee");
            while (rs.next()) {
                String id = rs.getString("kurse_id");
                String name = rs.getString("kurse_name");
                int preis = rs.getInt("kurse_preis");
                String kurse_tage = rs.getString("kurse_tage");
                Date tag = (Date) dformat.parse(kurse_tage);
                String trainer = rs.getString("trainer_id");
                int anzahl = rs.getInt("kurse_anzahl");
                int beginn = rs.getInt("kurse_beginn");
                int end = rs.getInt("kurse_end");



                kurse.add(new Kurse(id, name, preis,tag,trainer,anzahl,beginn,end));
            }

        }catch(SQLException | ParseException e) {
            e.printStackTrace();
        }
        return kurse;
    }


    public static void addKursee(String kurse_id, String kurse_name, int kurse_preis,Date kurse_tage, String trainer_id,int kurse_anzahlSportler, int beginn,int end) throws ParseException {
        String query = "INSERT INTO kursee(kurse_id,kurse_name,kurse_preis,kurse_tage,trainer_id,kurse_anzahl,kurse_beginn,kurse_end) VALUES(?,?,?,?,?,?,?,?)";

        SimpleDateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
        try {


            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1, kurse_id);
            pstmt.setString(2, kurse_name);
            pstmt.setInt(3, kurse_preis);
            pstmt.setString(4, dformat.format(kurse_tage));
            pstmt.setString(5,trainer_id);
            pstmt.setInt(6,kurse_anzahlSportler);
            pstmt.setInt(7,beginn);
            pstmt.setInt(8,end);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

/*
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
    }*/

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


    public static ObservableList<Kurse> getDatakurse(){

        Connection conn = connect();
        ObservableList<Kurse> kurselist = FXCollections.observableArrayList();
        SimpleDateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
        try{
            Statement stmt = conn.createStatement();
            //PreparedStatement ps = conn.prepareStatement("SELECT * FROM kurse");
            ResultSet rs = stmt.executeQuery("SELECT * FROM kursee");

            while(rs.next()){
                Date datum = (Date) dformat.parse("kurse_tage");
                //System.out.println(rs.getString("kurse_id") + rs.getString("kurse_name") + rs.getInt("kurse_preis") + rs.getString("kurse_tage") + " " + rs.getString("trainer_id") + " " + rs.getInt("kurse_anzahlSportler") + rs.getInt("beginn") + rs.getInt("end"));
                kurselist.add(new Kurse(rs.getString("kurse_id"),rs.getString("kurse_name"),rs.getInt("kurse_preis"),rs.getString("kurse_tage"),rs.getString("trainer_id"),rs.getInt("kurse_anzahl"),rs.getInt("kurse_beginn"),rs.getInt("kurse_end")));
            }
        } catch(Exception e){

        }
        //System.out.println(kurselist);
        return kurselist;
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

    public static void delete_Kurse(String person_id) {
        String query = "DELETE FROM kursee WHERE kurse_id = ? ";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1, person_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateKurs(Kurse kurse){
        //String id = "UPDATE person SET person_id =  '"+p.getId()+"'  WHERE person_id = '" + p.getId()+"'";
        String name = "UPDATE kurse SET kurse_name = '" + kurse.getKursename() + "' WHERE kurse_id = '" + kurse.getKursenummer()+"'";
        //int preis = Integer.parseInt("UPDATE kurse SET kurse_preis = '" + kurse.getPreis() + "' WHERE kurse_id = '" + kurse.getKursenummer()+"'");
        String tag = "UPDATE kurse SET kurse_tage = '" + kurse.getTage() + "' WHERE kurse_id = '" + kurse.getKursenummer()+"'";
        String trainer = "UPDATE kurse SET trainer_id = '" + kurse.getTrainer() + "' WHERE kurse_id = '" + kurse.getKursenummer()+"'";
        //int anzahl = Integer.parseInt("UPDATE kurse SET kurse_anzahlSportler = '" + kurse.getAnzahlSportler() + "' WHERE kurse_id = '" + kurse.getKursenummer()+"'");
        //int beginn = Integer.parseInt("UPDATE kurse SET kurse_beginn = '" + kurse.getBeginn() + "' WHERE kurse_id = '" + kurse.getKursenummer()+"'");
        //int end = Integer.parseInt("UPDATE kurse SET kurse_end = '" + kurse.getEnd() + "' WHERE kurse_id = '" + kurse.getKursenummer()+"'");



        try {
            Statement stm = conn.createStatement();
            //stm.execute(id);
            stm.execute(name);
            //stm.execute(String.valueOf(preis));
            stm.execute(tag);
            stm.execute(trainer);
            //stm.execute(String.valueOf(anzahl));
            //stm.execute(String.valueOf(beginn));
            //stm.execute(String.valueOf(end));



            //stm.execute(km);
            //stm.execute(typ);
            //stm.execute(preis);


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

 // SPORTLER

    public static ObservableList<Sportler> getDatasportler(){


        ObservableList<Sportler> sportlerlist = FXCollections.observableArrayList();
        try{
            //Connection conn = database.connect();
            //Statement stmt = conn.createStatement();
            //PreparedStatement ps = conn.prepareStatement("SELECT * FROM kurse");
            ResultSet rs = conn.createStatement().executeQuery("SELECT person.person_id,person.person_name,person.person_nachname,person.person_telno,person.person_adresse,person.person_email,sportlerr.schuld,sportlerr.krank,sportlerr.muskelv,sportlerr.fettrate FROM person,sportlerr WHERE person_id == sportler_id");



            while(rs.next()){
                //System.out.println(rs.getString("kurse_id") + rs.getString("kurse_name") + rs.getInt("kurse_preis") + rs.getString("kurse_tage") + " " + rs.getString("trainer_id") + " " + rs.getInt("kurse_anzahlSportler") + rs.getInt("beginn") + rs.getInt("end"));
                //personlist.add(new Person(rs.getString("kurse_name")));

               /*
                p.setSportlernummer(rs.getString("sportler_id"));
                p.setName(rs.getString("sportler_name"));
                p.setNachname(rs.getString("sportler_nachname"));
                p.setTelno(rs.getString("sportler_telno"));
                p.setAdresse(rs.getString("sportler_adresse"));
                p.setEmail(rs.getString("sportler_email"));
                p.setSchuld(rs.getInt("spotler_schuld"));
                p.setKrankenheit(rs.getString("sportler_schuld"));
                p.setMuskelv(rs.getInt("sportler_muskelv"));
                p.setFettrate(rs.getInt("sportler_fettrate"));
                */

                String id = rs.getString("person_id");
                String name = rs.getString("person_name");
                String nachname = rs.getString("person_nachname");
                String telno = rs.getString("person_telno");
                String add = rs.getString("person_adresse");
                String mail = rs.getString("person_email");
                int schuld = rs.getInt("schuld");
                String krank = rs.getString("krank");
                int muskelv = rs.getInt("muskelv");
                int fett = rs.getInt("fettrate");
                Sportler p = new Sportler(id,name,nachname,telno,add,mail,schuld,krank,muskelv,fett);

                sportlerlist.add(p);

            }
        } catch(Exception e){

        }
        //System.out.println(kurselist);
        return sportlerlist;
    }

/*
    public static void add_Sportler(Sportler p) {

        String id = p.getId();
        String name = p.getName();
        String nachname = p.getNachname();
        String telno = p.getTelno();
        String adress = p.getAdresse();
        String email = p.getEmail();

        String query = "INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) VALUES (?,?,?,?,?,?)";
        String query2 = "INSERT INTO sportlerr(sportler_id,schuld,krankheit,muskelv,fettrate) VALUES(?,?,?,?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1,id);
            pstmt.setString(2, p.getName());
            pstmt.setString(3, p.getNachname());
            pstmt.setString(4,p.getTelno());
            pstmt.setString(5,p.getAdresse());
            pstmt.setString(6,p.getAdresse());
            //pstmt.setString(2, password);

            pstmt.executeUpdate();
            pstmt.close();
            //conn.close();

            pstmt2 = dbControl.conn.prepareStatement(query2);
            pstmt2.setString(1,id);
            pstmt2.setInt(2,p.getSchuld());
            pstmt2.setString(3,p.getKrankenheit());
            pstmt2.setInt(4,p.getMuskelv());
            pstmt2.setInt(5,p.getFettrate());

            pstmt2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
*/

    public static void add_Sportler(Sportler p) {

        String id = p.getId();
        String name = p.getName();
        String nachname = p.getNachname();
        String telno = p.getTelno();
        String adress = p.getAdresse();
        String email = p.getEmail();
        int schuld = p.getSchuld();
        String krank =p.getKrankenheit();
        int muskel = p.getMuskelv();
        int fett = p.getFettrate();


        String query = "INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) VALUES (?,?,?,?,?,?)";
        String query2 = "INSERT INTO sportlerr(sportler_id,schuld,krankheit,muskelv,fettrate) VALUES (?,?,?,?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);

            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3,nachname);
            pstmt.setString(4, telno);
            pstmt.setString(5,adress);
            pstmt.setString(6,email);
            pstmt.executeUpdate();
            //pstmt.executeUpdate(query2);
            pstmt.close();
            //conn.close();


            pstmt2 = dbControl.conn.prepareStatement(query2);

            pstmt2.setString(1,id);
            pstmt2.setInt(2,schuld);
            pstmt2.setString(3,krank);
            pstmt2.setInt(4,muskel);
            pstmt2.setInt(5,fett);

            pstmt2.executeUpdate();
            pstmt2.close();

            //conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void updateSportler(Sportler p) {

        //String id = "UPDATE person SET person_id =  '"+p.getId()+"'  WHERE person_id = '" + p.getId()+"'";
        String name = "UPDATE sportler SET sportler_name = '" + p.getName() + "' WHERE person_id = '" + p.getSportlernummer()+"'";
        String nachname = "UPDATE sportler SET sportler_nachname =  '"+p.getNachname()+"'  WHERE person_id = '" + p.getSportlernummer()+"'";
        String telno = "UPDATE sportler SET sportler_telno =  '"+p.getTelno()+"'  WHERE person_id = '" + p.getSportlernummer()+"'";
        String adresse = "UPDATE sportler SET sportler_adresse =  '"+p.getAdresse()+"'  WHERE person_id = '" + p.getSportlernummer()+"'";
        String email = "UPDATE sportler SET sportler_email =  '"+p.getEmail()+"'  WHERE person_id = '" + p.getSportlernummer()+"'";
        int schuld = Integer.parseInt("UPDATE sportler SET sportler_schuld =  '"+p.getSchuld()+"'  WHERE person_id = '" + p.getSportlernummer()+"'");
        String krank = "UPDATE sportler SET sportler_email =  '"+p.getEmail()+"'  WHERE person_id = '" + p.getSportlernummer()+"'";
        int muskel = Integer.parseInt("UPDATE sportler SET sportler_muskelv =  '"+p.getMuskelv()+"'  WHERE person_id = '" + p.getSportlernummer()+"'");
        int fett = Integer.parseInt("UPDATE sportler SET sportler_fettrate =  '"+p.getFettrate()+"'  WHERE person_id = '" + p.getSportlernummer()+"'");
        //String typ = "UPDATE Autos SET Getriebetyp = '" + auto.getGetriebetyp() + "' WHERE Nummernschild = '" + auto.getNummernschild()+"'";
        //String preis = "UPDATE Autos SET Mietpreise =  '" +  auto.getMietpreise() + "'  WHERE Nummernschild = '" + auto.getNummernschild()+"'";




        try {
            Statement stm = conn.createStatement();
            //stm.execute(id);
            stm.execute(name);
            stm.execute(nachname);
            stm.execute(telno);
            stm.execute(adresse);
            stm.execute(email);
            stm.execute(String.valueOf(schuld));
            stm.execute(krank);
            stm.execute(String.valueOf(muskel));
            stm.execute(String.valueOf(fett));


            //stm.execute(km);
            //stm.execute(typ);
            //stm.execute(preis);


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //PERSON

    public static ObservableList<Person> getDataperson(){

        Connection conn = connect();
        ObservableList<Person> personlist = FXCollections.observableArrayList();
        try{
            Statement stmt = conn.createStatement();
            //PreparedStatement ps = conn.prepareStatement("SELECT * FROM kurse");
            ResultSet rs = stmt.executeQuery("SELECT * FROM person");

            while(rs.next()){
                //System.out.println(rs.getString("kurse_id") + rs.getString("kurse_name") + rs.getInt("kurse_preis") + rs.getString("kurse_tage") + " " + rs.getString("trainer_id") + " " + rs.getInt("kurse_anzahlSportler") + rs.getInt("beginn") + rs.getInt("end"));
                //personlist.add(new Person(rs.getString("kurse_name")));
                Person p = new Person();
                p.setId(rs.getString("person_id"));
                p.setName(rs.getString("person_name"));
                p.setNachname(rs.getString("person_nachname"));
                p.setTelno(rs.getString("person_telno"));
                p.setAdresse(rs.getString("person_adresse"));
                p.setEmail(rs.getString("person_email"));
                personlist.add(p);

            }
        } catch(Exception e){

        }
        //System.out.println(kurselist);
        return personlist;
    }

    public static void addPerson(String person_id, String person_name, String person_nachname, String person_telno, String person_adresse, String person_mail) {
        String query = "INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) VALUES(?,?,?,?,?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1, person_id);
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

    public static void add_Person(Person p) {

        String id = p.getId();
        String name = p.getName();
        String nachname = p.getNachname();
        String telno = p.getTelno();
        String adress = p.getAdresse();
        String email = p.getEmail();

        String query = "INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) VALUES (?,?,?,?,?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1,id);
            pstmt.setString(2, p.getName());
            pstmt.setString(3, p.getNachname());
            pstmt.setString(4,p.getTelno());
            pstmt.setString(5,p.getAdresse());
            pstmt.setString(6,p.getAdresse());
            //pstmt.setString(2, password);

            pstmt.executeUpdate();
            pstmt.close();
            //conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void add_Personal(Person p) {

        String id = p.getId();
        String name = p.getName();
        String nachname = p.getNachname();
        String telno = p.getTelno();
        String adress = p.getAdresse();
        String email = p.getEmail();

        String query = "INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) VALUES (?,?,?,?,?,?)";
        String query2 = "INSERT INTO personall(personal_id) VALUES(?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1,id);
            pstmt.setString(2, p.getName());
            pstmt.setString(3, p.getNachname());
            pstmt.setString(4,p.getTelno());
            pstmt.setString(5,p.getAdresse());
            pstmt.setString(6,p.getAdresse());
            //pstmt.setString(2, password);

            pstmt.executeUpdate();
            pstmt.close();
            //conn.close();

            pstmt2 = dbControl.conn.prepareStatement(query2);
            pstmt2.setString(1,id);

            pstmt2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void updatePerson(Person p) {

        //String id = "UPDATE person SET person_id =  '"+p.getId()+"'  WHERE person_id = '" + p.getId()+"'";
        String name = "UPDATE person SET person_name = '" + p.getName() + "' WHERE person_id = '" + p.getId()+"'";
        String nachname = "UPDATE person SET person_nachname =  '"+p.getNachname()+"'  WHERE person_id = '" + p.getId()+"'";
        String telno = "UPDATE person SET person_telno =  '"+p.getTelno()+"'  WHERE person_id = '" + p.getId()+"'";
        String adresse = "UPDATE person SET person_adresse =  '"+p.getAdresse()+"'  WHERE person_id = '" + p.getId()+"'";
        String email = "UPDATE person SET person_email =  '"+p.getEmail()+"'  WHERE person_id = '" + p.getId()+"'";
        //String typ = "UPDATE Autos SET Getriebetyp = '" + auto.getGetriebetyp() + "' WHERE Nummernschild = '" + auto.getNummernschild()+"'";
        //String preis = "UPDATE Autos SET Mietpreise =  '" +  auto.getMietpreise() + "'  WHERE Nummernschild = '" + auto.getNummernschild()+"'";




        try {
            Statement stm = conn.createStatement();
            //stm.execute(id);
            stm.execute(name);
            stm.execute(nachname);
            stm.execute(telno);
            stm.execute(adresse);
            stm.execute(email);

            //stm.execute(km);
            //stm.execute(typ);
            //stm.execute(preis);


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void delete_Person(String person_id) {
        String query = "DELETE FROM person WHERE person_id = ? ";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1, person_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static ObservableList<Personal> listPersonal(){
        ObservableList<Personal> arr = FXCollections.observableArrayList();

        try {
            Connection conn = database.connect();
            //ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM person");
            ResultSet rs = conn.createStatement().executeQuery("SELECT person.person_id,person.person_name,person.person_nachname,person.person_telno,person.person_adresse,person.person_email FROM person,personall WHERE person.person_id == personall.personal_id");
            System.out.println(rs);
            while (rs.next()) {

                String s = rs.getString("person_id");
                String s2 = rs.getString("person_name");
                String s3 = rs.getString("person_nachname");
                String s4 = rs.getString("person_telno");
                String s5 = rs.getString("person_adresse");
                String s6 = rs.getString("person_email");
                arr.add(new Personal(s,s2,s3,s4,s5,s6));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    public static void initPerson(){
        ObservableList<Personal> data = FXCollections.observableArrayList();
        try {
            Connection conn = database.connect();
            //ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM person");
            ResultSet rs = conn.createStatement().executeQuery("SELECT person.person_id,person.person_name,person.person_nachname,person.person_telno,person.person_adresse,person.person_email FROM person,personall WHERE person.person_id == personall.personal_id");
            System.out.println(rs);
            while (rs.next()) {

                String s = rs.getString("person_id");
                String s2 = rs.getString("person_name");
                String s3 = rs.getString("person_nachname");
                String s4 = rs.getString("person_telno");
                String s5 = rs.getString("person_adresse");
                String s6 = rs.getString("person_email");
                data.add(new Personal(s,s2,s3,s4,s5,s6));
                //data.add(new Person(rs.getString("person_id"),rs.getString("person_name"),rs.getString("person_nachname"),rs.getString("person_telno"),rs.getString("person_adresse"),rs.getString("person_email")));
            }
        } catch (SQLException e) {
            Logger.getLogger(kursController.class.getName()).log(Level.SEVERE, (String)null, e);
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


    public static void addSportler(String personid, String personname, String personnachname, String telno ,String adresse, String email,int schuld,String krank,int muskel, int fettrate) {
        String query = "INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) VALUES(?,?,?,?,?,?)";
        String query2 = "INSERT INTO sportlerr(sportler_id,schuld,krankheit,muskelv,fettrate) VALUES (?,?,?,?,?)";

        try {
            pstmt = dbControl.conn.prepareStatement(query);

            pstmt.setString(1, personid);
            pstmt.setString(2, personname);
            pstmt.setString(3,personnachname);
            pstmt.setString(4, telno);
            pstmt.setString(5,adresse);
            pstmt.setString(6,email);
            pstmt.executeUpdate();
            pstmt.close();

            pstmt2 = dbControl.conn.prepareStatement(query2);
            pstmt2.setString(1, String.valueOf(personid));
            pstmt2.setInt(2,schuld);
            pstmt2.setString(3,krank);
            pstmt2.setInt(4,muskel);
            pstmt2.setInt(5,fettrate);
            pstmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
/*
    public static void addSportler(int personid, String personname,String personnachname, String telno ,String adresse, String email,int schuld,String krank,int muskel, int fettrate) {
        //String query = "INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) VALUES(?,?,?,?,?,?)";
        String query2 = "INSERT INTO sportler(sportler_id,sportler_name,sportler_nachname,sportler_telno,sportler_adresse,sportler_email,sportler_schuld,sportler_krank,sportler_muskelv,sportler_fettrate) VALUES (?,?,?,?)";

        try {
            //pstmt = dbControl.conn.prepareStatement(query);
            pstmt2 = dbControl.conn.prepareStatement(query2);
            pstmt2.setInt(1, personid);
            pstmt2.setString(2, personname);
            pstmt2.setString(3,personnachname);
            pstmt2.setString(4, telno);
            pstmt2.setString(5,adresse);
            pstmt2.setString(6,email);
            pstmt2.setInt(7,schuld);
            pstmt2.setString(8,krank);
            pstmt2.setInt(9,muskel);
            pstmt2.setInt(10,fettrate);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
*/



    public static void updateBenutzername(String id, String bn) {

        String bname = "UPDATE benutzer SET benutzename = '" + bn + "' WHERE id = '" + id +"'";

        try {
            Statement stm = conn.createStatement();
            stm.execute(bname);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePasswort(String id, String pass) {

        String passwort = "UPDATE benutzer SET password = '" + pass + "' WHERE id = '" + id +"'";

        try {
            Statement stm = conn.createStatement();
            stm.execute(passwort);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateKurse(Kurse kurs) {

        String name = "UPDATE kurse SET kurse_name = '" + kurs.getKursename() + "' WHERE kurse_id = '" + kurs.getKursenummer()+"'";
        String preis = "UPDATE kurse SET kurse_preis =  '"+ kurs.getPreis()+"' WHERE kurse_id = '" + kurs.getKursenummer()+"'" ;
        String tage = "UPDATE kurse SET kurse_tage = '" + kurs.getTage() + "' WHERE kurse_id = '" + kurs.getKursenummer()+"'";
        String trainer = "UPDATE kurse SET trainer_id =  '" +  kurs.getTrainer() + "' WHERE kurse_id = '" + kurs.getKursenummer()+"'" ;
        String anzahl = "UPDATE kurse SET kurse_anzahlSportler =  '" +  kurs.getAnzahlSportler() + "' WHERE kurse_id = '" + kurs.getKursenummer()+"'" ;
        String beginn = "UPDATE kurse SET trainer_beginn =  '" +  kurs.getBeginn() + "' WHERE kurse_id = '" + kurs.getKursenummer()+"'" ;
        String end = "UPDATE kurse SET trainer_end =  '" +  kurs.getEnd() + "' WHERE kurse_id = '" + kurs.getKursenummer()+"'" ;




        try {
            Statement stm = conn.createStatement();
            stm.execute(name);
            stm.execute(preis);
            stm.execute(tage);
            stm.execute(trainer);
            stm.execute(anzahl);
            stm.execute(beginn);
            stm.execute(end);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

//TRAINER

    public static ArrayList<Trainer> getTrainer() {
        ArrayList<Trainer> mitarbeiters = new ArrayList<>();
        //SimpleDateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Statement stmt = database.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM person,trainer WHERE person_id = trainer_id");
            while (rs.next()) {




                String id = rs.getString("person_id");
                String name = rs.getString("person_name");
                String nachname = rs.getString("person_nachname");
                String telno = rs.getString("person_telno");
                //Date geburtsdatum = (Date) dformat.parse(sgeburtsdatum);
                String adresse = rs.getString("person_adresse");
                String email = rs.getString("person_email");
                String trainernummer = rs.getString("trainer_id");




                mitarbeiters.add(new Trainer(id, name, nachname,telno,adresse,email));
                System.out.println(mitarbeiters.get(0).getName());
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mitarbeiters;
    }

    public static void updateTrainer(Trainer p) {

        //String id = "UPDATE person SET person_id =  '"+p.getId()+"'  WHERE person_id = '" + p.getId()+"'";
        String name = "UPDATE person SET person_name = '" + p.getName() + "' WHERE person_id = '" + p.getId()+"'";
        String nachname = "UPDATE person SET person_nachname =  '"+p.getNachname()+"'  WHERE person_id = '" + p.getId()+"'";
        String telno = "UPDATE person SET person_telno =  '"+p.getTelno()+"'  WHERE person_id = '" + p.getId()+"'";
        String adresse = "UPDATE person SET person_adresse =  '"+p.getAdresse()+"'  WHERE person_id = '" + p.getId()+"'";
        String email = "UPDATE person SET person_email =  '"+p.getEmail()+"'  WHERE person_id = '" + p.getId()+"'";
        //String typ = "UPDATE Autos SET Getriebetyp = '" + auto.getGetriebetyp() + "' WHERE Nummernschild = '" + auto.getNummernschild()+"'";
        //String preis = "UPDATE Autos SET Mietpreise =  '" +  auto.getMietpreise() + "'  WHERE Nummernschild = '" + auto.getNummernschild()+"'";




        try {
            Statement stm = conn.createStatement();
            //stm.execute(id);
            stm.execute(name);
            stm.execute(nachname);
            stm.execute(telno);
            stm.execute(adresse);
            stm.execute(email);

            //stm.execute(km);
            //stm.execute(typ);
            //stm.execute(preis);


        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete_Trainer(String person_id) {
        String query = "DELETE FROM person WHERE person_id = ?";
        String query2 = "DELETE FROM trainer WHERE trainer_id =?";

        try {
            pstmt = dbControl.conn.prepareStatement(query);
            pstmt.setString(1, person_id);
            pstmt.executeUpdate();

            pstmt2 = dbControl.conn.prepareStatement(query2);
            pstmt2.setString(1,person_id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ObservableList<Trainer> listTrainer(){
        ObservableList<Trainer> mitarbeiters = FXCollections.observableArrayList();


        //SimpleDateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Statement stmt = database.conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT person.person_id,person.person_name,person.person_nachname,person.person_telno,person.person_adresse,person.person_email FROM person,trainer WHERE person_id == trainer_id");
            while (rs.next()) {




                String id = rs.getString("person_id");
                String name = rs.getString("person_name");
                String nachname = rs.getString("person_nachname");
                String telno = rs.getString("person_telno");
                //Date geburtsdatum = (Date) dformat.parse(sgeburtsdatum);
                String adresse = rs.getString("person_adresse");
                String email = rs.getString("person_email");
                //String trainernummer = rs.getString("trainer_id");




                mitarbeiters.add(new Trainer(id, name, nachname,telno,adresse,email));
                System.out.println(mitarbeiters.get(0).getName());
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mitarbeiters;
    }

    public static void add_Trainer(Trainer p) {

        String id = p.getId();
        String name = p.getName();
        String nachname = p.getNachname();
        String telno = p.getTelno();
        String adress = p.getAdresse();
        String email = p.getEmail();

        String query = "INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) VALUES (?,?,?,?,?,?)";
        String query2 = "INSERT INTO trainer(trainer_id) VALUES (?)" ;

        //String query = INSERT INTO person(person_id,person_name,person_nachname,person_telno,person_adresse,person_email) OUTPUT person.person_id INTO trainer VALUES()  GO
        try {
            pstmt = dbControl.conn.prepareStatement(query);
            //pstmt2 = dbControl.conn.prepareStatement(query2);
            pstmt.setString(1,id);
            pstmt.setString(2, p.getName());
            pstmt.setString(3, p.getNachname());
            pstmt.setString(4,p.getTelno());
            pstmt.setString(5,p.getAdresse());
            pstmt.setString(6,p.getAdresse());
            //pstmt2.setString(7,id);
            //pstmt.setString(2, password);

            pstmt.executeUpdate();
            pstmt.close();
            //conn.close();

            pstmt2 = dbControl.conn.prepareStatement(query2);

            pstmt2.setString(1,id);

            pstmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteTrainer(String id) {
        String query = "DELETE FROM person WHERE person_id = ?" ;
        String query2 = "DELETE FROM trainer WHERE trainer_id = ?";

        try {
            pstmt = database.conn.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();

            pstmt2 = database.conn.prepareStatement(query2);

            pstmt2.setString(1, id);

            pstmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    ObservableList trainers = FXCollections.observableArrayList();



    public void filLComboBoxTrainer() throws SQLException {
        String query = "SELECT trainer_id FROM trainer";
        pstmt = dbControl.conn.prepareStatement(query);
        rs = pstmt.executeQuery();

        while(rs.next()){

            trainers.add(rs.getString("trainer_id"));
        }
        pstmt.close();
        rs.close();
    }

    public static ObservableList<String> listTrainerCombo(){
        ObservableList<String> arr = FXCollections.observableArrayList();

        try {
            Connection conn = database.connect();
            //ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM person");
            ResultSet rs = conn.createStatement().executeQuery("SELECT person_id FROM person,trainer WHERE person_id == trainer_id");
            System.out.println(rs);
            while (rs.next()) {

                String s = rs.getString("person_id");

                arr.add(s);


            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    public static ObservableList<String> listKurseCombo(){
        ObservableList<String> arr = FXCollections.observableArrayList();

        try {
            Connection conn = database.connect();
            //ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM person");
            ResultSet rs = conn.createStatement().executeQuery("SELECT kurse_name FROM kursee");
            System.out.println(rs);
            while (rs.next()) {

                String s = rs.getString("kurse_name");

                arr.add(s);


            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }

    public static ObservableList<String> listSportlerCombo(){
        ObservableList<String> arr = FXCollections.observableArrayList();

        try {
            Connection conn = database.connect();
            //ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM person");
            ResultSet rs = conn.createStatement().executeQuery("SELECT sportler_id FROM sportlerr");
            System.out.println(rs);
            while (rs.next()) {

                String s = rs.getString("sportler_id");

                arr.add(s);


            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }



    public static ObservableList<Sportler> listKurseList2(String value) {
        ObservableList<Sportler> arr = FXCollections.observableArrayList();

        try{
            Connection conn = database.connect();
            ResultSet rs = conn.createStatement().executeQuery("SELECT sportler_id,schuld FROM sportlerr,kurse WHERE kurse_name == '" + value+ "'");

            while(rs.next()){
                arr.add(new Sportler(rs.getString("sportler_id"),rs.getInt("schuld")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arr;
    }

    public static ObservableList<Sportler> listSportlerList(String id){
        ObservableList<Sportler> arr = FXCollections.observableArrayList();

        try {
            Connection conn = database.connect();
            //ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM person");
            ResultSet rs = conn.createStatement().executeQuery("SELECT sportler_id,person_name,person_nachname,kurse_id,schuld FROM person,sportlerr WHERE sportler_id == person_id AND sportler_id == '" + id +"'");
            System.out.println(rs);
            while (rs.next()) {

                String s = rs.getString("sportler_id");
                String s2 = rs.getString("person_name");
                String s3 = rs.getString("person_nachname");
                String s4 = rs.getString("kurse_id");
                int s5 = rs.getInt("schuld");
                arr.add(new Sportler(s,s2,s3,s4,s5));
                //arr.add(new Kurse(s,s3,s2));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }


    public static ObservableList<Kurse> listTrainerList(String id){
        ObservableList<Kurse> arr = FXCollections.observableArrayList();

        try {
            Connection conn = database.connect();
            //ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM person");
            ResultSet rs = conn.createStatement().executeQuery("SELECT trainer_id,kurse_name,kurse_anzahl FROM kursee WHERE trainer_id == '" + id +"'");
            System.out.println(rs);
            while (rs.next()) {

                String s = rs.getString("trainer_id");
                String s2 = rs.getString("kurse_name");
                int s3 = rs.getInt("kurse_anzahl");
                arr.add(new Kurse(s,s3,s2));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }
//?????????????
    public static ObservableList<Sportler> listTrainerList2(String id){
        ObservableList<Sportler> arr = FXCollections.observableArrayList();

        try {
            Connection conn = database.connect();
            //ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM person");
            ResultSet rs = conn.createStatement().executeQuery("SELECT person_id,person_name,person_nachname FROM person,sportlerr,kursee WHERE  sportlerr.kurse_id == kursee.kurse_id AND kursee.trainer_id =='" + id +"' ");
            //sportlerr.kurse_id == kursee.kurse_id AND
            System.out.println(rs);
            while (rs.next()) {

                String s = rs.getString("person_id");
                String s2 = rs.getString("person_name");
                String s3 = rs.getString("person_nachname");
                arr.add(new Sportler(s,s2,s3));

            }
        }catch (Exception e){
            System.out.println(e);
        }
        return arr;
    }



}
