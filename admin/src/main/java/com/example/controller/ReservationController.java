package com.example.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.example.DAO.ReservationDao;
import com.example.Models.Reservation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReservationController {

    @FXML
    private TableView<Reservation> reservations;


    @FXML
    private TableColumn<Reservation, Long> idBookCol;

    @FXML
    private TableColumn<Reservation, Long> idClientCol;

    @FXML
    private TableColumn<Reservation, Long> idCol;


    @FXML
    private TableColumn<Reservation, Date> startDateCol;

    @FXML
    private TableColumn<Reservation, Date> endDateCol;

    @FXML
    public void initialize()
    { 
        ReservationDao reservationDao = new ReservationDao();

        idBookCol.setCellValueFactory(new PropertyValueFactory<>("idBook"));
        idClientCol.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("idReservation"));
        startDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        ObservableList<Reservation> reservationsList = FXCollections.observableArrayList();
      
        ResultSet rs = reservationDao.getReservations();

        try {
            while (rs.next()) {
 
                Reservation reservation = new Reservation((long)(rs.getInt("id")),(long)(rs.getInt("idClient")),(long)(rs.getInt("idBook")),rs.getDate("start_date"),rs.getDate("end_date"));
                reservationsList.add(reservation);

            }
            reservations.getItems().addAll(reservationsList);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
