package com.example.controller;

import com.example.DAO.CategoryDao;
import com.example.Models.Category;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditCategoryController {

    @FXML
    private TextArea description;

    @FXML
    private TextField name;

    Long idCategory ; 

    void initData(Category category) {
        idCategory = category.getIdCategory();
        description.setText(category.getDescription());
        name.setText(category.getCategoryName());
    }

    @FXML
    void editCategory(MouseEvent event) {
        CategoryDao categoryDao = new CategoryDao();
        Category category = new Category(idCategory,name.getText() , description.getText());
        categoryDao.editCategory(category);;
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
