package com.example.Models;


public class Category {

    private Long idCategory ;
    private String categoryName ;
    private String description ; 
    



    public Category() {
    }


    public Category( String categoryName, String description) {
     
        this.categoryName = categoryName;
        this.description = description;
    }


    public Category(Long idCategory, String categoryName, String description) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
        this.description = description;
        
    }
    


    public Long getIdCategory() {
        return this.idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return getIdCategory() +"-" + getCategoryName();
    }
    



     
    
}
