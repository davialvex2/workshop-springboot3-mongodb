package com.daviaugusto.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daviaugusto.workshopmongodb.domain.User;
import com.daviaugusto.workshopmongodb.exception.ObjectNotFoundException;
import com.daviaugusto.workshopmongodb.repositories.UserRepositoty;


@Service
public class UserService {
	
	@Autowired
	private UserRepositoty repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
