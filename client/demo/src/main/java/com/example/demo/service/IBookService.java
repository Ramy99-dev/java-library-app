package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Book;

public interface IBookService {

    public List<Book> getBooks();
    public Book getBook(Long idBook);
    public void decrementQuantityNumber(Long idBook);
    public void deleteBook(Long idBook);
    
}
