package com.example.controller;

import java.io.IOException;

import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class LoginController {
    private final String adminName = "ADMIN";
    private final String adminPassword  = "admin";
    
    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void signIn(ActionEvent event) {
        if(username.getText().equals(adminName) && password.getText().equals(adminPassword) )
        {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.close();

            Scene scene;
            try {
                Screen screen = Screen.getPrimary();
                Rectangle2D bounds = screen.getVisualBounds();
                scene = new Scene(loadFXML("home"), bounds.getWidth(), bounds.getHeight());
                scene.getStylesheets().add("menu.css");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
          

        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

}
