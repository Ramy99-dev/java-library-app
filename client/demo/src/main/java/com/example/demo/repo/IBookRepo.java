package com.example.demo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Book;

public interface IBookRepo extends JpaRepository<Book,Long> {
    
    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.quantity = b.quantity - 1 WHERE b.id = ?1")
    public void decrementQuantity(Long id);
   
}

