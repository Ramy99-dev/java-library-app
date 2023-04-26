package com.example.Models;

import java.util.Date;

public class Reservation {

    private Long idReservation;
    private Long idClient;
    private Long idBook;
    private Date startDate;
    private Date endDate;


    public Reservation() {
    }


    public Reservation(Long idReservation, Long idClient, Long idBook, Date startDate, Date endDate) {
        this.idReservation = idReservation;
        this.idClient = idClient;
        this.idBook = idBook;
        this.startDate = startDate;
        this.endDate = endDate;
    }




    public Long getIdReservation() {
        return this.idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
    }

    public Long getIdClient() {
        return this.idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdBook() {
        return this.idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
