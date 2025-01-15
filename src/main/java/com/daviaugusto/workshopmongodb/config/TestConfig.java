package com.daviaugusto.workshopmongodb.config;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.daviaugusto.workshopmongodb.domain.User;
import com.daviaugusto.workshopmongodb.repositories.UserRepositoty;



@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepositoty repository;
	

	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();
		
		User davi = new User(null, "Davi Augusto", "davi@gmail.com");
		User daniel = new User(null, "Daniel Miranda", "daniel@gmail.com");
		User suzy = new User(null, "Suzy Cristina", "suzy@gmail.com");
		User maria = new User(null, "Maria Santos", "maria@gmail.com");
		
		
		repository.saveAll(Arrays.asList(daniel, suzy, maria, davi));
		
	
	}

}
