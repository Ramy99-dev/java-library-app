package com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.Naming;
import java.util.HashMap;

import com.example.Models.Client;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClientController {

    @FXML
    private TableView<Client> clients;

    @FXML
    private TableColumn<Client, String> email;

    @FXML
    private TableColumn<Client, String> firstname;

    @FXML
    private TableColumn<Client, Long> idCol;

    @FXML
    private TableColumn<Client, String> lastname;


    @FXML
    public void initialize()
    {
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        lastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));

        String hostname = "localhost"; 
        int port = 5000;
        
                  

        new Thread(() -> {
            while(true)
            {
                try (Socket socket = new Socket(hostname, port)) {
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());    
                    String clientId = "client2";
                    output.writeObject(clientId);
                    output.flush();
                    System.out.println("Registered as " + clientId);
        
                    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                    HashMap receivedClient = (HashMap) input.readObject();

                    System.out.println(receivedClient);
                    Client client = new Client();
                    client.setFirstname(receivedClient.get("firstname").toString());
                    client.setLastname(receivedClient.get("lastname").toString());
                    client.setEmail(receivedClient.get("email").toString());

                    clients.getItems().add(client);            
            
                    
            
        
                } catch (IOException e) {
                    System.err.println("Failed to connect to server");
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
            }
        }).start();


       
        

        
    }
    
}
