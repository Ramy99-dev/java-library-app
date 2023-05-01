package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.DBConnection;

public class ReservationDao
{
    private Connection conn = null;
    
    public ReservationDao()
    {
       conn = DBConnection.getConnection();
       try 
       {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS reservation " +
                        "(id SERIAL not NULL, " +
                        "idClient INT, " + 
                        "idBook INT,"+
                        "start_date DATE, " +
                        "end_date DATE, " +
                        "PRIMARY KEY ( id ),"+
                        "CONSTRAINT fk_client FOREIGN KEY(idClient) REFERENCES client(id),"+
                        "CONSTRAINT fk_book FOREIGN KEY(idBook) REFERENCES books(id));"; 
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");   	  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }


    
    public ResultSet getReservations()
    {
        try {
            String sql = "SELECT r.id ,c.firstname as firstname , c.lastname as lastname , r.idBook ,start_date , end_date FROM reservation r "+
            "INNER JOIN  client c ON r.idClient = c.id "+
            "INNER JOIN  books b  ON r.idBook = b.id ;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            return  preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public Integer getReservationNumber()
    {
        Integer number = 0;
        try {
            String sql = "SELECT COUNT(id) AS number FROM reservation;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
 
                number = rs.getInt("number");

            }
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
        return number;
    } 

    
}