package com.example;

import java.io.File;

import com.example.Models.Book;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class BookDetailsController {


    @FXML
    private Text author;

    @FXML
    private Text category;

    @FXML
    private ImageView cover;

    @FXML
    private Text title;

    private Book book;

    

    void initData(Book  book) {
        this.book = book;
        Image image = new Image(getClass().getResourceAsStream("/uploads/"+book.getCoverImg()));
        cover.setImage(image);
        title.setText(book.getTitle());
        author.setText("Author : " + book.getAuthorName() );
    }
    
}
