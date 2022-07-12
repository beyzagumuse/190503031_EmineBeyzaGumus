package com.example.demo.Classes;

public class benutzer {
    private String benutzername;
    private String password;

    public benutzer(String name, String pass){
        benutzername = name;
        password = pass;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
