package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Book;
import com.example.demo.repo.IBookRepo;

@Service
public class BookServiceImpl implements IBookService{

    @Autowired
    private IBookRepo bookRepo;

    @Override
    public List<Book> getBooks() {
         return bookRepo.findAll();
    }

    @Override
    public Book getBook(Long idBook) {
        return bookRepo.findById(idBook).get();
    }

    @Override
    public void decrementQuantityNumber(Long idBook) {
        bookRepo.decrementQuantity(idBook);
    }

    @Override
    public void deleteBook(Long idBook) {
       bookRepo.deleteById(idBook);
    }
    
}
