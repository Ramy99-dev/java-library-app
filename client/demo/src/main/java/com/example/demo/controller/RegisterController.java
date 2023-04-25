package com.example.demo.controller;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.models.Client;
import com.example.demo.service.IClientService;

@Controller
public class RegisterController {
  @Autowired
  private IClientService clientService;

  @RequestMapping("/register")
  public String showRegister() {
      return "register";
  }

  @PostMapping("/submit-register")
  public String register(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname ,  @RequestParam("password") String password , @RequestParam("email") String email) throws InterruptedException {
    if(clientService.getClientByEmail(email) == null)
    {
      Client client = new Client();
      client.setFirstname(firstname);
      client.setLastname(lastname);
      client.setPassword(password);
      client.setEmail(email);
      Client newClient = clientService.addClient(client);

      try {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to socket server");
        
        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
        String clientId = "client1";
        output.writeObject(clientId);
        output.flush();
        System.out.println("Registered as " + clientId);

        
        HashMap<String, Object> message = new HashMap<>();
        HashMap<String, Object> clientMap = new HashMap<>();
        message.put("content", "Hello from " + clientId);
        message.put("destClientId", "client2");
        clientMap.put("id",newClient.getId());
        clientMap.put("firstname", newClient.getFirstname());
        clientMap.put("lastname", newClient.getLastname());
        clientMap.put("email",newClient.getEmail());
        message.put("client",clientMap);
        output.writeObject(message);
        output.flush();
          
        
        
      
      } catch (IOException e) {
        System.err.println("Failed to connect to socket server ");
        e.printStackTrace();
     }

     
      

      return "login";
    }
    return "register";
    
  }

  @RequestMapping("/login")
  public String showLogin() {
      return "login";
  }

  @PostMapping("/submit-login")
  public Object login(@RequestParam("email") String email, @RequestParam("password") String password  ) {
    Client client = clientService.getClientByEmail(email);
    if(client != null)
    { 
        if(password.equals(client.getPassword()))
        {
          RedirectView redirectView = new RedirectView();
          redirectView.setUrl("books");
          return redirectView;
        }
    }
    
    return "login";
  }
}
