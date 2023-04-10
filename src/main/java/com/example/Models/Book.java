package com.example.Models;


public class Book {

    private Long idBook ; 
    private String title; 
    private String coverImg ;
    private Long category ;
    private Long author;
    private int quantity ; 
    private String authorName;
    private String categoryName;
    

    public Book() {
    }

    public Book( String title, String coverImg, Long category, Long author, int quantity) {
        this.title = title;
        this.coverImg = coverImg;
        this.category = category;
        this.author = author;
        this.quantity = quantity;
    }


    public Book(Long idBook, String title, String coverImg, Long category, Long author, int quantity) {
        this.idBook = idBook;
        this.title = title;
        this.coverImg = coverImg;
        this.category = category;
        this.author = author;
        this.quantity = quantity;
    }

    public Book(Long idBook, String title, String coverImg, String categoryName, String authorName, int quantity) {
        this.idBook = idBook;
        this.title = title;
        this.coverImg = coverImg;
        this.categoryName = categoryName;
        this.authorName = authorName;
        this.quantity = quantity;
    }

    
    

    

    public Long getIdBook() {
        return this.idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategory() {
        return this.category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
     

    public Long getAuthor() {
        return this.author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }


    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    

    public String getCoverImg() {
        return this.coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }
 

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    
    
    
}
