package com.example.controller;

import com.example.DAO.AuthorDao;
import com.example.Models.Author;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditAuthorController {

    @FXML
    private DatePicker birthday;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    Long idAuthor ; 


    @FXML
    public void initialize() {

    }

    void initData(Author author) {
        idAuthor = author.getIdAuthor();
        firstname.setText(author.getFirstname());
        lastname.setText(author.getLastname());
    }

    @FXML
    void editAuthor(MouseEvent event) {

        AuthorDao authorDao = new AuthorDao();
        Author author = new Author(idAuthor,firstname.getText() , lastname.getText());
        authorDao.editAuthor(author);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
