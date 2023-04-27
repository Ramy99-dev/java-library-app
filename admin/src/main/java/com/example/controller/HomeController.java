package com.example.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.App;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController {


    
    @FXML
    private AnchorPane content;

    @FXML
    void showAuthors(MouseEvent event) {
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("authors.fxml"));
            Parent root = loader.load();
            loader.getController();

    
            content.getChildren().clear();
            content.getChildren().add(root);
        } 
        catch (IOException err) 
        {
            System.out.println(err.toString());
        }
    }

    @FXML
    void showBooks(MouseEvent event) {
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("books.fxml"));
            Parent root = loader.load();
            loader.getController();
    
            content.getChildren().clear();
            content.getChildren().add(root);
        } 
        catch (IOException err) 
        {
            System.out.println(err.toString());
        }

    }

    @FXML
    void showCategories(MouseEvent event) {

        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("category.fxml"));
            Parent root = loader.load();
            loader.getController();
    
            content.getChildren().clear();
            content.getChildren().add(root);
        } 
        catch (IOException err) 
        {
            System.out.println(err.toString());
        }

    }

    @FXML
    void showClients(MouseEvent event) {
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("clients.fxml"));
            Parent root = loader.load();
            loader.getController();
    
            content.getChildren().clear();
            content.getChildren().add(root);
        } 
        catch (IOException err) 
        {
            System.out.println(err.toString());
        }
    }

    @FXML
    void showReservations(MouseEvent event) {
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("reservation.fxml"));
            Parent root = loader.load();
            loader.getController();
    
            content.getChildren().clear();
            content.getChildren().add(root);
        } 
        catch (IOException err) 
        {
            System.out.println(err.toString());
        }

    }

    @FXML
    void showDashboard(MouseEvent event) {
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashboard.fxml"));
            Parent root = loader.load();
            loader.getController();
    
            content.getChildren().clear();
            content.getChildren().add(root);
        } 
        catch (IOException err) 
        {
            System.out.println(err.toString());
        }
    }


    @FXML
    void logout(MouseEvent event) {
        
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
        stage = new Stage();
    

        Scene scene;
        try {
            scene = new Scene(loadFXML("login"),  1000, 570);
            scene.getStylesheets().add("login.css");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        
    }

    

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}