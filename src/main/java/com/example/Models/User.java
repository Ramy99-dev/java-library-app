package com.example.Models;

import java.util.Date;

public class User {

    private Long idUser;
    private String firstname;  
    private String lastname; 
    private Date birthday ; 


    public User() {
    }


    public User(Long idUser, String firstname, String lastname, Date birthday) {
        this.idUser = idUser;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
    }

   
    public Long getIdUser() {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    
}
