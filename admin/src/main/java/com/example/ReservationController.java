package com.example;

import com.example.DAO.ReservationDao;

import javafx.fxml.FXML;

public class ReservationController {

    @FXML
    public void initialize()
    { 
        ReservationDao reservationDao = new ReservationDao();
    }
    
}
