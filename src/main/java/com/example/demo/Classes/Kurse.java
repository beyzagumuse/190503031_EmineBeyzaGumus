package com.example.demo.Classes;

public class  Kurse{
    private int kursenummer;
    private int preis;
    private String tage;
    private String kursename;
    private int anzahlSportler;

    private int beginn;

    private int end;

    private String trainer;

    public Kurse(int kurse_id, String kurse_name, int kurse_preis, String kurse_tage, String trainer, int kurse_anzahlSportler, int kurse_beginn, int kurse_end) {
        super();
        kursenummer = kurse_id;
        kursename = kurse_name;
        preis = kurse_preis;
        tage = kurse_tage;
        anzahlSportler = kurse_anzahlSportler;
        this.trainer = trainer;
        beginn = kurse_beginn;
        end = kurse_end;
    }

    public Kurse(int kurse_id,String kurse_name,int kurse_preis){
        super();
        kursenummer = kurse_id;
        kursename = kurse_name;
        preis = kurse_preis;
    }

    public Kurse(){}

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public void setAnzahlSportler(int anzahlSportler) {
        this.anzahlSportler = anzahlSportler;
    }

    public void setKursename(String kursename) {
        this.kursename = kursename;
    }

    public void setKursenummer(int kursenummer) {
        this.kursenummer = kursenummer;
    }

    public void setTage(String tage) {
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

    public int getKursenummer() {
        return kursenummer;
    }

    public String getTage() {
        return tage;
    }


    public void setBeginn(int beginn) {
        this.beginn = beginn;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public int getBeginn() {
        return beginn;
    }

    public int getEnd() {
        return end;
    }

    public String getTrainer() {
        return trainer;
    }



}








