package com.example.demo.Classes;

import java.sql.*;


public class database {

    public static Connection conn = null;
    public void connect() {


        try {
            // db parameters
            String url = "jdbc:sqlite:D:\\demo\\sqlite3\\database.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM person");
            if (res.next()) {
                System.out.println("username: " + res.getString("username") + " Pass: " + res.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
