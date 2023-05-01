package com.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.controlsfx.control.Notifications;

import com.example.DAO.ClientDao;
import com.example.Models.Client;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

        ClientDao clientDao = new ClientDao();
        ObservableList<Client> clientList = FXCollections.observableArrayList();
      
        ResultSet rs = clientDao.getClients();

        try {
            while (rs.next()) {
 
                Client client = new Client((long)(rs.getInt("id")),rs.getString("firstname"),rs.getString("lastname"),rs.getString("firstname") + " " + rs.getString("lastname"),rs.getString("email"));
                clientList.add(client);

            }
            clients.getItems().addAll(clientList);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
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
                    HashMap<Object,Object> receivedClient = (HashMap) input.readObject();

                    System.out.println(receivedClient);
                    Client client = new Client();
                    client.setId(Long.valueOf(receivedClient.get("id").toString()));
                    client.setFirstname(receivedClient.get("firstname").toString());
                    client.setLastname(receivedClient.get("lastname").toString());
                    client.setEmail(receivedClient.get("email").toString());

                    clients.getItems().add(client);   
                    
                    Platform.runLater(() -> {
                        Notifications.create()
                            .title("Client")
                            .text("A new client registered")
                            .showInformation();
                    });
        
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
