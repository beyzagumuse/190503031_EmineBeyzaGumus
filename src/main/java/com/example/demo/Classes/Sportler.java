package com.example.demo.Classes;

public class Sportler{

    private String name;
    private String nachname;
    private String telno;
    private String adresse;
    private String email;
    private String sportlernummer;
    private int schuld;
    private String krankenheit; //arraylist or array
    private int muskelv;
    private int fettrate;
    //private Kurse[];

    public Sportler(){}

    public Sportler(String id, String name, String nachname,String telno,String adresse, String email, int schuld , String krankenheit,int muskel,int fett){
        //super( id, name, nachname, telno,adresse, email);
        sportlernummer = id;
        this.name = name;
        this.nachname = nachname;
        this.telno = telno;
        this.adresse = adresse;
        this.email = email;
        this.schuld = schuld;
        this.krankenheit = krankenheit;
        muskelv = muskel;
        fettrate = fett;
    }

    public void addSportler(String sportlernummer, Person a){
        this.sportlernummer = sportlernummer;
        //add new person/sportler in database

    }

    public void deleteSportler(String sportlernummer){
          //delete sportler with sportlernummer from database
    }

    public void searchSportler(String sportlernummer){
          //search sportler with sportlernummer in database
    }

    public void editSportler(String sportlernummer /*informationen for edit*/){
        //change informationen über sportler
    }


    /*@Override
    public String getName(){
        return "Personal: " + name;
    }

    @Override
    public String toString(){
        String s = "PersonalId: " + id + "\nName: " + name + "\nNachname: " + nachname;
        return super.toString();
    }*/


    public void setSportlernummer(String sportlernummer) {
        this.sportlernummer = sportlernummer;
    }

    public void setSchuld(int schuld) {
        this.schuld = schuld;
    }

    public void setMuskelv(int muskelv) {
        this.muskelv = muskelv;
    }

    public void setKrankenheit(String krankenheit) {
        this.krankenheit = krankenheit;
    }

    public void setFettrate(int fettrate) {
        this.fettrate = fettrate;
    }

    public String getSportlernummer() {
        return sportlernummer;
    }

    public String getKrankenheit() {
        return krankenheit;
    }

    public int getSchuld() {
        return schuld;
    }

    public int getMuskelv() {
        return muskelv;
    }

    public int getFettrate() {
        return fettrate;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getNachname() {
        return nachname;
    }


    public void setNachname(String nachname) {
        this.nachname = nachname;
    }


    public String getTelno() {
        return telno;
    }


    public void setTelno(String telno) {
        this.telno = telno;
    }


    public String getAdresse() {
        return adresse;
    }


    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}
