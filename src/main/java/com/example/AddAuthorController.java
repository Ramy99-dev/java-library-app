package com.example;

import java.io.IOException;

import com.example.DAO.AuthorDao;
import com.example.Models.Author;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddAuthorController {
    
    @FXML
    private DatePicker birthday;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    void addAuthor(MouseEvent event) {
            System.out.println("Clicked");
            AuthorDao authorDao = new AuthorDao();
            Author author = new Author(firstname.getText() , lastname.getText());
            authorDao.addAuthor(author);
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.close();
   
    }
}
