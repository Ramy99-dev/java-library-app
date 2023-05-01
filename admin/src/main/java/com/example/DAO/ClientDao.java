package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.DBConnection;

public class ClientDao {

    private Connection conn = null;
    
    public ClientDao()
    {
       conn = DBConnection.getConnection();
       try 
       {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS client " +
                    "(id SERIAL not NULL, " +
                    " firstname VARCHAR(255), " + 
                    " lastname VARCHAR(255), " + 
                    " email VARCHAR(255), " + 
                    " password VARCHAR(255), " +
                    " PRIMARY KEY ( id ))"; 
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");   	  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public ResultSet getClients()
    {
        try {
            String sql = "SELECT * FROM client";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            return  preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Integer getClientNumber()
    {
        Integer number = 0;
        try {
            String sql = "SELECT COUNT(id) AS number FROM client;";
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
