package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Client;

public interface IClientRepo extends JpaRepository<Client,Long> {
    
    Client findByEmail(String email);
}
