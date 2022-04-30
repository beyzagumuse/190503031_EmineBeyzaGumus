package com.example.demo;

import com.example.demo.Classes.database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private Stage primaryStage;
    private AnchorPane mainLayout;
    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
        //Parent parent = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        /*FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("log.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Login!");
        stage.setScene(scene);
        stage.show();*/
        this.primaryStage = primaryStage;
        //this.primaryStage.setTitle("Sportcentrum");


        showMainView();
        //showKurseScene();


        //database connection
        database db = new database();
        db.connect();
    }

    public void showMainView() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(HelloApplication.class.getResource("homepage.fxml"));
        mainLayout = fxmlLoader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*public static void showKurseScene() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HelloApplication.class.getResource("kurs.fxml"));
        Scene scene = new Scene(loader.load(),600,400);
        stage.setScene(scene);

    }*/

    public static void main(String[] args) {
        launch();
    }
}