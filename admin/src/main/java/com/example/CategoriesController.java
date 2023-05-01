package com.example;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.DAO.CategoryDao;
import com.example.Models.Category;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CategoriesController {


    @FXML
    private TableView<Category> categories;

    @FXML
    private TableColumn<Category, Long> idCol;

    @FXML
    private TableColumn<Category, Long> nameCol;
    
    CategoryDao categoryDao = new CategoryDao();

    @FXML
    public void initialize()
    { 
       

        categories.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        MenuItem mi1 = new MenuItem("Edit");
        mi1.setOnAction((ActionEvent event) -> {
            Category category = categories.getSelectionModel().getSelectedItem();
            showEditCategory(category);
         });
        
        MenuItem mi2 = new MenuItem("Delete");
        mi2.setOnAction((ActionEvent event) -> {
            ObservableList<Category> ListCategoriesRemoved = categories.getSelectionModel().getSelectedItems();

            for (Category category : ListCategoriesRemoved) {
               
                categories.getItems().remove(categories.getItems().indexOf(category));
                categoryDao.deleteCategory(category.getIdCategory());
            }
        });

        ContextMenu menu = new ContextMenu();
        menu.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        menu.getItems().add(mi2);
        menu.getItems().add(mi1);
      
        categories.setContextMenu(menu);

        categoryDao = new CategoryDao();
        ResultSet rs = categoryDao.getCategories();
        ObservableList<Category> categoriesList = FXCollections.observableArrayList();

        try {
            while (rs.next()) {
 
                Category category = new Category((long)(rs.getInt("id")),rs.getString("name"),rs.getString("description"));
                categoriesList.add(category);

            }
            categories.getItems().addAll(categoriesList);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        nameCol.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("idCategory"));
    }

    @FXML
    void showAddCategory(MouseEvent event) {
        Stage stage = new Stage();
        Scene scene;
        try {
            scene = new Scene(loadFXML("addCategory"), 550,300);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setOnHiding(e -> {
            updateCategoritesList();
        });

    }

    void showEditCategory(Category category) {
        Stage stage = new Stage();
        Scene scene;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editCategory.fxml"));
            scene = new Scene(loader.load(), 550,300);
            EditCategoryController controller = loader.getController();
            controller.initData(category);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setOnHiding(e -> {
            updateCategoritesList();
        });
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private void updateCategoritesList()
    {
        ObservableList<Category> categoriesList = FXCollections.observableArrayList();
            CategoryDao categoryDao = new CategoryDao();
            ResultSet rs = categoryDao.getCategories();
    
            try {
                while (rs.next()) {
     
                    Category category = new Category((long)(rs.getInt("id")),rs.getString("name"),rs.getString("description"));
                    categoriesList.add(category);
    
                }
                categories.getItems().clear();
                categories.getItems().addAll(categoriesList);
            } catch (SQLException exc) {
                // TODO Auto-generated catch block
                exc.printStackTrace();
            }
            categories.refresh();
    }
    
}
