package com.example.demo.Classes;

public class Person {
    private String id;
    private String name;
    private String nachname;
    private String telno;
    private String adresse;
    private String email;

    public Person(){}

    public Person(String id,String name,String nachname){
        this.id = id;
        this.nachname = nachname;
        this.name = name;
    }
    public Person(String name){
        this.name = name;
    }


    public Person(String id, String name, String nachname,String telno,String adresse, String email){
        this.id = id;
        this.name = name;
        this.nachname = nachname;
        this.telno = telno;
        this.adresse = adresse;
        this.email = email;
    }
    /*public Person(String a) {



    }


    public boolean checkId(String id){
        if ((id.length() == 7) && id.matches("[0-9]+")) {
            return true;
        }
        return false;
    }*/


    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelno(String telno){
        this.telno = telno;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setNachname(String nachname){
        this.nachname = nachname;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTelno() {
        return telno;
    }

    public String getNachname() {
        return nachname;
    }
}
