package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Client;
import com.example.demo.repo.IClientRepo;
@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private IClientRepo clientRepo;
    @Override
    public void addClient(Client client) {
        clientRepo.save(client);
    }

    @Override
    public void signIn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'signIn'");
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepo.findByEmail(email);
    }
    
}
