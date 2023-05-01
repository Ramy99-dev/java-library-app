package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

import com.example.DAO.AuthorDao;
import com.example.DAO.ClientDao;
import com.example.DAO.ReservationDao;

/**
 * JavaFX App
 */

 public class App extends Application {

    private static Scene scene;
    @Override
    public void start(Stage stage) throws IOException, InterruptedException, ClassNotFoundException {
        AuthorDao authorDao = new AuthorDao();
        ClientDao clientDao = new ClientDao();
        ReservationDao reservationDao = new ReservationDao();
        scene = new Scene(loadFXML("login"), 1000, 570);
        scene.getStylesheets().add("login.css");
        stage.setScene(scene);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("/img/logo-app-bg.png")));
        stage.setResizable(false);
        stage.setTitle("Book Explorer");
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