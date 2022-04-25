import java.io.IOException;
import java.sql.*;
import java.util.Set;

public static void connect() {

    public  static Connection conn = null;
        try {
        // db parameters
        String url = "jdbc:sqlite:C:\Users\Public\YazılımMuh\sqlite\sqlite-tools\kindergarten.db";
        // create a connection to the database
        conn = DriverManager.getConnection(url);

        System.out.println("Connection to SQLite has been established.");
        Statement stmt = conn.createStatement();
        ResultSet res = stmt.executeQuery("SELECT * FROM users");
        if(res.next()){
          System.out.println("username: "+res.getString("username")+" Pass: "+res.getString("password"));
        }
        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
   }
