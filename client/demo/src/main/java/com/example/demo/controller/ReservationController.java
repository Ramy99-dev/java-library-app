package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.models.Book;
import com.example.demo.models.Reservation;
import com.example.demo.service.IBookService;
import com.example.demo.service.IReservationService;

@Controller
public class ReservationController {
    
    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IBookService bookService;
    
    
    @GetMapping("/submit-reservation")
    public RedirectView submitReservation(@RequestParam("idClient") Long idClient , @RequestParam("idBook") Long idBook , @RequestParam("date") String date , @RequestParam("name") String name ) {
        Reservation reservation = new Reservation();
        reservation.setIdBook(idBook);
        reservation.setIdClient(idClient);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date startDate;
        try {
            startDate = dateFormat.parse(date);

            Date endDate = new Date(); 
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endDate);
            calendar.add(Calendar.DATE, 15);
            endDate = calendar.getTime();

            reservation.setStart_date(startDate);
            reservation.setEnd_date(endDate);
            reservationService.addReservation(reservation);

            Book book = bookService.getBook(idBook);
            if(book.getQuantity() > 1)
            {
                bookService.decrementQuantityNumber(idBook);
            }
            else
            {
                bookService.deleteBook(idBook);
            }
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/books?idClient="+idClient+"&name="+name);
        return redirectView;
       
     }
}
