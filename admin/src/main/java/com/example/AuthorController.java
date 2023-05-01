package com.example;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.DAO.AuthorDao;
import com.example.Models.Author;

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

public class AuthorController {
    
    

    @FXML
    private TableView<Author> authors;

    @FXML
    private TableColumn<Author, Long> idCol;

    @FXML
    private TableColumn<Author, String> firstnameCol;

    @FXML
    private TableColumn<Author, String> lastnameCol;

    
    
    @FXML
    public void initialize() {
        AuthorDao authorDao = new AuthorDao();

        authors.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        MenuItem mi1 = new MenuItem("Edit");
            mi1.setOnAction((ActionEvent event) -> {
                Author author = authors.getSelectionModel().getSelectedItem();
                showEditAuthor(author);
        });
        
        MenuItem mi2 = new MenuItem("Delete");
        mi2.setOnAction((ActionEvent event) -> {
            ObservableList<Author> ListAuthorsRemoved = authors.getSelectionModel().getSelectedItems();

            for (Author author : ListAuthorsRemoved) {
                authors.getItems().remove(authors.getItems().indexOf(author));
                authorDao.deleteAuthor(author.getIdAuthor());
            }

            

        });

        ContextMenu menu = new ContextMenu();
        menu.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
        menu.getItems().add(mi2);
        menu.getItems().add(mi1);
      
        authors.setContextMenu(menu);


        ObservableList<Author> authorslist = FXCollections.observableArrayList();
      
        ResultSet rs = authorDao.getAuthors();

        try {
            while (rs.next()) {
 
                Author author = new Author((long)(rs.getInt("id")),rs.getString("firstname"),rs.getString("lastname"));
                authorslist.add(author);

            }
            authors.getItems().addAll(authorslist);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("idAuthor"));

        
    }

    @FXML
    void showAddAuthor(MouseEvent event) {
        Stage stage = new Stage();
        Scene scene;
        try {
            scene = new Scene(loadFXML("addAuthor"), 550,300);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setOnHiding(e -> {
            updateAuthorsList();
        });
       


    }

    
    void showEditAuthor(Author author) {
        Stage stage = new Stage();
        Scene scene;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("editAuthor.fxml"));
            scene = new Scene(loader.load(), 550,300);
            EditAuthorController controller = loader.getController();
            controller.initData(author);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.setOnHiding(e -> {
            updateAuthorsList();
        });
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private void updateAuthorsList()
    {
        ObservableList<Author> authorslist = FXCollections.observableArrayList();
            AuthorDao authorDao = new AuthorDao();
            ResultSet rs = authorDao.getAuthors();
    
            try {
                while (rs.next()) {
     
                    Author author = new Author((long)(rs.getInt("id")),rs.getString("firstname"),rs.getString("lastname"));
                    authorslist.add(author);
    
                }
                authors.getItems().clear();
                authors.getItems().addAll(authorslist);
            } catch (SQLException exc) {
                // TODO Auto-generated catch block
                exc.printStackTrace();
            }
            authors.refresh();
    }
    
    
    
   

    
}
