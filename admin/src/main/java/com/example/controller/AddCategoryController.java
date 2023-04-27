package com.example.controller;

import com.example.DAO.CategoryDao;
import com.example.Models.Category;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddCategoryController {
    
    @FXML
    private TextField categoryName;

    @FXML
    private TextField description;

    @FXML
    void addCategory(MouseEvent event) {
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category(categoryName.getText() , description.getText());
        categoryDao.addCategory(category);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

}
