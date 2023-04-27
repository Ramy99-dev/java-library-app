package com.example.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.App;
import com.example.DAO.BookDao;
import com.example.Models.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class BooksController {

  

    @FXML
    private TableView<Book> books;

    @FXML
    private TableColumn<Book, String> authorCol;

    @FXML
    private TableColumn<Book, Integer> qteCol;

    @FXML
    private TableColumn<Book, Long> refCol;

    @FXML
    private TableColumn<Book, String> titleCol;

    @FXML
    private TableColumn<Book, String> categCol;




    @FXML
    public void initialize() {
        BookDao bookDao = new BookDao();

        books.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        MenuItem mi1 = new MenuItem("Edit");
            mi1.setOnAction((ActionEvent event) -> {
                Book author = books.getSelectionModel().getSelectedItem();
                //showEditAuthor(author);
        });
        
        MenuItem mi2 = new MenuItem("Delete");
        mi2.setOnAction((ActionEvent event) -> {
            /*ObservableList<Book> ListAuthorsRemoved = books.getSelectionModel().getSelectedItems();

            for (Author author : ListAuthorsRemoved) {
                authors.getItems().remove(authors.getItems().indexOf(author));
                authorDao.deleteAuthor(author.getIdAuthor());
            }*/

            

        });

        ContextMenu menu = new ContextMenu();
        menu.getItems().add(mi2);
        menu.getItems().add(mi1);
      
        books.setContextMenu(menu);


        ObservableList<Book> booksList = FXCollections.observableArrayList();
      
        ResultSet rs = bookDao.getBooks();

        try {
            while (rs.next()) {
 
                Book book = new Book((long)(rs.getInt("id")),rs.getString("title"),rs.getString("cover"),rs.getString("firstname") + " " + rs.getString("lastname"),rs.getString("name"),rs.getInt("quantity"));
                booksList.add(book);

            }
            books.getItems().addAll(booksList);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        authorCol.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        categCol.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        refCol.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        qteCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        books.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Book book = books.getSelectionModel().getSelectedItem();

                    Stage stage = new Stage();
                    Scene scene;
                    try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("bookDetails.fxml"));
                        scene = new Scene(loader.load(), 420,500);
                        BookDetailsController controller = loader.getController();
                        controller.initData(book);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                                     
                }
            }
        });

        
    }

    @FXML
    void showAddBook(MouseEvent event) {

        Stage stage = new Stage();
        Scene scene;
        try {
            scene = new Scene(loadFXML("addBook"), 550,300);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*stage.setOnHiding(e -> {
            updateAuthorsList();
        });*/
    }


    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    
}
