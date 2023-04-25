package com.example.demo.service;

import com.example.demo.models.Client;

public interface IClientService {

    public Client addClient(Client client);
    public void signIn();
    public Client getClientByEmail(String email);
    
}
