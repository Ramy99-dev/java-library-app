package com.example.demo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long idclient ;
    private Long idbook;
    private Date start_date;
    private Date end_date;


    public Reservation() {
    }


    public Reservation(Long id, Long idClient, Long idBook, Date start_date, Date end_date) {
        this.id = id;
        this.idclient = idClient;
        this.idbook = idBook;
        this.start_date = start_date;
        this.end_date = end_date;
    }




    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdClient() {
        return this.idclient;
    }

    public void setIdClient(Long idClient) {
        this.idclient = idClient;
    }

    public Long getIdBook() {
        return this.idbook;
    }

    public void setIdBook(Long idBook) {
        this.idbook = idBook;
    }

    public Date getStart_date() {
        return this.start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return this.end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    
}
