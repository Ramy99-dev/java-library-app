package com.example.controller;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.DAO.BookDao;
import com.example.DAO.CategoryDao;
import com.example.DAO.ClientDao;
import com.example.DAO.ReservationDao;
import com.example.Models.Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;

public class DashboardController {

    @FXML
    private Text numberBooks;

    @FXML
    private Text numberClients;

    @FXML
    private Text numberReservation;

    @FXML
    private PieChart categoryPie;



    @FXML
    public void initialize()
    { 
        

        BookDao bookDao = new BookDao();
        numberBooks.setText(bookDao.getBooksNumber().toString()); 

        ClientDao clientDao = new ClientDao();
        numberClients.setText(clientDao.getClientNumber().toString());

        ReservationDao reservationDao = new ReservationDao();
        numberReservation.setText(reservationDao.getReservationNumber().toString());

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        
        ResultSet rs = bookDao.getCategoryNumbers();
        
        try {
            while(rs.next())
            {
                pieChartData.add( new PieChart.Data(rs.getString("name"), rs.getInt("number")));
            }
            categoryPie.setData(pieChartData);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
