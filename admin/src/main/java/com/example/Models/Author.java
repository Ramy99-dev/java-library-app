package com.example.Models;


public class Author {
    

    private Long idAuthor ; 
    private String firstname;  
    private String lastname;
   
    

    public Author() {
    }


    public Author( String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Author(Long id ,  String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.idAuthor = id;

    }
 
    
    public Long getIdAuthor() {
        return this.idAuthor;
    }
   

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    

    @Override
    public String toString() {
        return getIdAuthor() +"-" + getFirstname() +" " + getLastname();
    }



    
}
