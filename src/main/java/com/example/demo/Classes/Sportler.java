package com.example.demo.Classes;

public class Sportler extends Person {


    private String sportlernummer;
    private int schuld;
    private String krankenheit; //arraylist or array
    private int muskelv;
    private int fettrate;

    private String kurse_id;
    //private Kurse[];

    public Sportler() {
    }

    public Sportler(String id,String name,String nachname){
        super(id,name,nachname);
        sportlernummer = id;
    }

    public Sportler(String id, int schuld){
        super(id);
        sportlernummer = id;
        this.schuld = schuld;
    }


    public Sportler(String id, String name, String nachname,String kurse,int schuld ){
        super(id,name,nachname);
        sportlernummer = id;
        kurse_id = kurse;
        this.schuld = schuld;
    }

    public Sportler(String id, String name, String nachname, String telno,String adresse,String email){
        super(id,name,nachname,telno,adresse,email);
    }
    public Sportler(String id, String name, String nachname, String telno, String adresse, String email, int schuld, String krankenheit, int muskel, int fett) {
        super(id, name, nachname, telno, adresse, email);
        this.sportlernummer = id;
        this.schuld = schuld;
        this.krankenheit = krankenheit;
        this.muskelv = muskel;
        this.fettrate = fett;
    }

    public Sportler(String id, String name, String nachname, String telno, String adresse, String email, int schuld, String krankenheit, int muskel, int fett,String kurse) {
        super(id, name, nachname, telno, adresse, email);
        this.sportlernummer = id;
        this.schuld = schuld;
        this.krankenheit = krankenheit;
        this.muskelv = muskel;
        this.fettrate = fett;
        kurse_id = kurse;
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

    public String getKurse_id() {
        return kurse_id;
    }

    public void setKurse_id(String kurse_id) {
        this.kurse_id = kurse_id;
    }
}




