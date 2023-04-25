package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Book;

public interface IBookRepo extends JpaRepository<Book,Long> {
    
    
   
}

