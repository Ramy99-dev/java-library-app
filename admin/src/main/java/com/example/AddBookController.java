package com.example;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.DAO.AuthorDao;
import com.example.DAO.BookDao;
import com.example.DAO.CategoryDao;
import com.example.Models.Author;
import com.example.Models.Book;
import com.example.Models.Category;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddBookController {


    @FXML
    private ComboBox<Author> authorField;

    @FXML
    private ComboBox<Category> categoryField;

    @FXML
    private TextField title;

    @FXML
    private Button uploadBtn;

    @FXML
    private Slider quantitySlider;

    @FXML
    private TextField quantity;

    private File selectedFile;

    

    @FXML
    void addBook(MouseEvent event) {
       String imgPath = uploadImg() ;
   
       Book book = new Book(title.getText() , imgPath ,categoryField.getValue().getIdCategory() ,authorField.getValue().getIdAuthor(),Integer.valueOf(quantity.getText()) );
       BookDao bookDao = new BookDao();
       bookDao.addBook(book);

    }

    @FXML
    public void initialize() {
        quantity.setText(String.valueOf(quantitySlider.getValue()));

        quantitySlider.valueProperty().addListener((obs, oldval, newVal) -> 
        {
                 quantitySlider.setValue(newVal.intValue());
                 quantity.setText(String.valueOf(newVal.intValue()));
        });
        

        ObservableList<Author> authorslist = FXCollections.observableArrayList();
        AuthorDao authorDao = new AuthorDao();

        ObservableList<Category> categoriesList = FXCollections.observableArrayList();
        CategoryDao categoryDao = new CategoryDao();
       

        ResultSet rsAuthor = authorDao.getAuthors();
        ResultSet rsCategory = categoryDao.getCategories();

        try {
            while (rsAuthor.next()) {
 
                Author author = new Author((long)(rsAuthor.getInt("id")),rsAuthor.getString("firstname"),rsAuthor.getString("lastname"));
                authorslist.add(author);

            }
            while (rsCategory.next()) {
 
                Category category = new Category((long)(rsCategory.getInt("id")),rsCategory.getString("name"),rsCategory.getString("description"));
                categoriesList.add(category);

            }
           
            authorField.getItems().addAll(authorslist);
            categoryField.getItems().addAll(categoriesList);

        } catch (SQLException exc) {
            // TODO Auto-generated catch block
            exc.printStackTrace();
        }
        
    }

    @FXML
    void selectBookCover(MouseEvent event) {
       FileChooser fc = new FileChooser();
       selectedFile = fc.showOpenDialog(null);

       if(selectedFile != null)
       {

        
        uploadBtn.setText(selectedFile.toString());

       
        
        
        
       }
       else
       {
           System.out.println("Error");
       }
       
    }

    private String  uploadImg()
    {
        String imgName = null;
        try {
            Path source = selectedFile.toPath();
            Path destination = Paths.get(getClass().getResource("/uploads/").toURI()).resolve(selectedFile.getName());
            imgName = selectedFile.getName();
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
        return imgName;

    }

    @FXML
    void cancel(MouseEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    
    
    
}
