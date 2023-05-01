package com.example;



import com.example.DAO.AuthorDao;
import com.example.Models.Author;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddAuthorController {
    
  

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


    @FXML
    void cancel(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
