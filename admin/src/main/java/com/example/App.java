package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.rmi.Naming;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;


import com.example.Models.Client;


/**
 * JavaFX App
 */

 public class App extends Application {

    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException, InterruptedException, ClassNotFoundException {
        scene = new Scene(loadFXML("login"), 1000, 570);
        scene.getStylesheets().add("login.css");
        stage.setScene(scene);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/img/logo-app-bg.png")));
        stage.setResizable(false);
        stage.show();
    
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

        
    
}