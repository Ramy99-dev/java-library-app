package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.example.DBConnection;
import com.example.Models.Author;

public class AuthorDao {

    private Connection conn = null;
    
    public AuthorDao()
    {
       conn = DBConnection.getConnection();
       try 
       {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS authors " +
                    "(id SERIAL not NULL, " +
                    " firstname VARCHAR(255), " + 
                    " lastname VARCHAR(255), " + 
                    " birthday DATE, " + 
                    " PRIMARY KEY ( id ))"; 
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");   	  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    public void addAuthor(Author author)
    {
        try {
            String sql = "INSERT INTO authors (firstname,lastname,birthday) "
            + "VALUES(?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, author.getFirstname());
            preparedStatement.setString(2, author.getLastname());
            preparedStatement.setDate(3, java.sql.Date.valueOf("2013-09-04"));

            preparedStatement.executeUpdate();

            System.out.println("Author Inserted successfully ...");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

       
    }

    public ResultSet getAuthors()
    {
        try {
            String sql = "SELECT * FROM authors";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            return  preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteAuthor(long id)
    {
        
        try {
            String sql = "DELETE  FROM authors WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

    public void editAuthor(Author author)
    {
        System.out.println(author);
        
        try {
            String sql = "UPDATE  authors SET firstname = ? , lastname = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, author.getFirstname());
            preparedStatement.setString(2, author.getLastname());
            preparedStatement.setLong(3, author.getIdAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
    
}
