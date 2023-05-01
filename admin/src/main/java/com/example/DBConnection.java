package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

   
   static final String DB_URL = "jdbc:postgresql://localhost/libdb";
   static final String USER = "postgres";
   static final String PASS = "password";

   static Connection conn  = null;

   public  static Connection getConnection()
    {
        if(conn != null)
        {
            return conn ;
        }
        else{
            try{
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Database created successfully...");   	
            }
                catch (SQLException e) {
               e.printStackTrace();
            } 
            return conn ;
        }
        
    }
   
    
}
