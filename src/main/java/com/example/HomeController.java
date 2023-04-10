package com.example;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

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

}