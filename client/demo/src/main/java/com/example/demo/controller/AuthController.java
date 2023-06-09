package com.example.demo.controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.models.Client;
import com.example.demo.service.IClientService;

@Controller
public class AuthController {
  @Autowired
  private IClientService clientService;

  @RequestMapping("/register")
  public String showRegister() {
      return "register";
  }

  @PostMapping("/submit-register")
  public String register(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname ,  @RequestParam("password") String password , @RequestParam("confirm_password") String confirmPassword , @RequestParam("email") String email ,Model model) throws InterruptedException {
    if(!confirmPassword.equals(password))
    {
      model.addAttribute("errMsg", "Password doesn't match");
      return "register";
    }
    else
    {
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
    model.addAttribute("errMsg", "User already exist");
    return "register";
    }
    
  }

  @RequestMapping("/login")
  public String showLogin() {
      return "login";
  }

  @PostMapping("/submit-login")
  public Object login(@RequestParam("email") String email, @RequestParam("password") String password , Model model ) {
    Client client = clientService.getClientByEmail(email);
    if(client != null)
    { 
        if(password.equals(client.getPassword()))
        {
          RedirectView redirectView = new RedirectView();
          redirectView.setUrl("auth?idClient="+client.getId()+"&firstname="+client.getFirstname());
          return redirectView;
        }
    }
    model.addAttribute("errMsg", "Invalid credentials");
    return "login";
  }

  @GetMapping("/auth")
  public String auth(@RequestParam("idClient") Long idClient, @RequestParam("firstname") String firstname )
  {
   return "auth";
  }
}
