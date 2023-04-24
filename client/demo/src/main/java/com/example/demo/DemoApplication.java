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
/*@EntityScan(basePackages = "java.com.example.demo.models")
@EnableJpaRepositories(basePackages = "java.com.example.demo.repo")
@ComponentScan(basePackageClasses=RegisterController.class)*/
public class DemoApplication  { 
	
	public static void main(String[] args) {
       
		SpringApplication.run(DemoApplication.class, args);
		
		
	}

	

}	
