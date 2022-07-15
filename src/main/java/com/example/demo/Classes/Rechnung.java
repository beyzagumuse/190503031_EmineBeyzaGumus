package com.example.demo.Classes;

public class Rechnung{
    private String rechnungsnummer;
    private String sportlernummer;
    private String kursenummer;
    private String kurseTage;


    private int preis;
    //private Kurse[];


    public void addRechnung(){


    }

    public void deleteRechnung(String rechnungsnummer){

    }

    public void searchRechnung(String rechnungsnummer){

    }

    public void editRechnung(String rechnungsnummer){

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

    public void setRechnungsnummer(String rechnungsnummer) {
        this.rechnungsnummer = rechnungsnummer;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getSportlernummer() {
        return sportlernummer;
    }

    public int getPreis() {
        return preis;
    }

    public void setSportlernummer(String sportlernummer) {
        this.sportlernummer = sportlernummer;
    }

    public String getRechnungsnummer() {
        return rechnungsnummer;
    }

    public String getKursenummer() {
        return kursenummer;
    }

    public void setKursenummer(String kursenummer) {
        this.kursenummer = kursenummer;
    }

    public String getKurseTage() {
        return kurseTage;
    }

    public void setKurseTage(String kurseTage) {
        this.kurseTage = kurseTage;
    }
}
