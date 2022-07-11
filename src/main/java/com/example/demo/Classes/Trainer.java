package com.example.demo.Classes;

public class Trainer extends Person{

    public Trainer(String id, String name, String nachname,String telno,String adresse, String email){
        super( id, name, nachname, telno,adresse, email);
    }
    private String trainernummer;
    //private Kurse[];



    public void addTrainer(String trainernummer, Person a){
        this.trainernummer = trainernummer;

    }

    public void deleteTrainer(String trainernummer){

    }

    public void searchTrainer(String trainernummer){

    }

    public void editTrainer(String trainernummer){

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



    public void setTrainernummer(String trainernummer) {
        this.trainernummer = trainernummer;
    }

    public String getTrainernummer() {
        return trainernummer;
    }



}
