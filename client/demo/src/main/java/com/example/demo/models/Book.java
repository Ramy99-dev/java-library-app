package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ; 
    private String title; 
    private String cover ;
    private Long categoryid ;
    private Long authorid;
    private int quantity ; 

    

    public Book() {
    }

    public Book( String title, String cover, Long category, Long author, int quantity) {
        this.title = title;
        this.cover = cover;
        this.categoryid = category;
        this.authorid = author;
        this.quantity = quantity;
    }


    public Book(Long idBook, String title, String cover, Long category, Long author, int quantity) {
        this.id = idBook;
        this.title = title;
        this.cover = cover;
        this.categoryid = category;
        this.authorid = author;
        this.quantity = quantity;
    }

   
    public Long getIdBook() {
        return this.id;
    }

    public void setIdBook(Long idBook) {
        this.id = idBook;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategory() {
        return this.categoryid;
    }

    public void setCategory(Long category) {
        this.categoryid = category;
    }
     

    public Long getAuthor() {
        return this.authorid;
    }

    public void setAuthor(Long author) {
        this.authorid = author;
    }


    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    public String getcover() {
        return this.cover;
    }

    public void setcover(String cover) {
        this.cover = cover;
    }   


   

    
}
