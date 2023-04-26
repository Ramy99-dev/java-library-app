package com.example.demo;



import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.models.Client;


@SpringBootApplication
public class DemoApplication  { 
	
	public static void main(String[] args) {
       
		SpringApplication.run(DemoApplication.class, args);
		
		
	}

	

}	
