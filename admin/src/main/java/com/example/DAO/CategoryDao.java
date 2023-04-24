package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.DBConnection;
import com.example.Models.Category;

public class CategoryDao {

    private Connection conn = null;
    
    public CategoryDao()
    {
       conn = DBConnection.getConnection();
       try 
       {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS category " +
                        "(id SERIAL not NULL, " +
                        " name VARCHAR(255), " + 
                        " description VARCHAR(900), " +
                        " PRIMARY KEY ( id ))"; 
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");   	  
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }


    public void addCategory(Category category)
    {
        try {
            String sql = "INSERT INTO category (name,description) "
            + "VALUES(?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setString(2, category.getCategoryName());

            preparedStatement.executeUpdate();

            System.out.println("Category Inserted successfully ...");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ResultSet getCategories()
    {
        try {
            String sql = "SELECT * FROM category";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            return  preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteCategory(long id)
    {
        
        try {
            String sql = "DELETE  FROM category WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }

    public void editCategory(Category category)
    {
    
        
        try {
            String sql = "UPDATE  category SET name = ? , description = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setString(2, category.getDescription());
            preparedStatement.setLong(3, category.getIdCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
    
    
    
}
