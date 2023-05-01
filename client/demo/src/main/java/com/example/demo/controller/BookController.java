package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Book;
import com.example.demo.service.IBookService;

@Controller
public class BookController {

  @Autowired
  private IBookService bookService;

  @RequestMapping("/books")
  public String showRegister(@RequestParam("name") String name , @RequestParam("idClient") Long id,Model model) {
     List<Book> books = bookService.getBooks();
     model.addAttribute("books", books);
     model.addAttribute("name", name);
     System.out.println(books);
     return "index";
  }
    
}
