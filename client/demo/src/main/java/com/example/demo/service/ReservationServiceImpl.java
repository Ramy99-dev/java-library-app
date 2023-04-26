package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Reservation;
import com.example.demo.repo.IReservationRepo;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private IReservationRepo reservationRepo;

    @Override
    public void addReservation(Reservation reservation) {
        reservationRepo.save(reservation);
    }
    
}
