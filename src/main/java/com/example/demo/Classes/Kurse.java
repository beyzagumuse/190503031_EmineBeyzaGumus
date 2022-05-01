package com.example.demo.Classes;

import java.util.Date;

public class  Kurse extends Person{
    private String kursenummer;
    private int preis;
    private Date tage; //arraylist or array
    private String kursename;
    private int anzahlSportler;

    private int beginn;

    private int end;

    private Trainer trainer;

    public Kurse(String kurse_id, String kurse_name, int kurse_preis, java.sql.Date kurse_tage, String trainer_id, int kurse_anzahlSportler, int kurse_beginn, int kurse_end) {
        super();
        kursenummer = kurse_id;
        kursename = kurse_name;
        preis = kurse_preis;
        tage = kurse_tage;
        anzahlSportler = kurse_anzahlSportler;
        beginn = kurse_beginn;
        end = kurse_end;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public void setAnzahlSportler(int anzahlSportler) {
        this.anzahlSportler = anzahlSportler;
    }

    public void setKursename(String kursename) {
        this.kursename = kursename;
    }

    public void setKursenummer(String kursenummer) {
        this.kursenummer = kursenummer;
    }

    public void setTage(Date tage) {
        this.tage = tage;
    }

    public int getPreis() {
        return preis;
    }

    public int getAnzahlSportler() {
        return anzahlSportler;
    }

    public String getKursename() {
        return kursename;
    }

    public String getKursenummer() {
        return kursenummer;
    }

    public Date getTage() {
        return tage;
    }

    public void setBeginn(int beginn) {
        this.beginn = beginn;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public int getBeginn() {
        return beginn;
    }

    public int getEnd() {
        return end;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void addKurse(/*kursename,kursenummer,tage,preis,anzahlderSportler*/){
        //create new Kurse() with taken informations

    }

    public void deleteKurse(String kursenummer){
        // delete kurse with kursenummer
    }

    public void searchKurse(String kursenummer){
        //look in database with kursenummer
    }

    public void editKurse(String kursenummer /*informations for edit*/){
      //change kurse details with informations
    }


    /*@Override
    public String getName(){
        return "Personal: " + name;
    }

    @Override
    public String toString(){
        String s = "PersonalId: " + id + "\nName: " + name + "\nNachname: " + nachname;
        return super.toString();
    }

     */
}








