package com.daviaugusto.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daviaugusto.workshopmongodb.domain.User;
import com.daviaugusto.workshopmongodb.dto.UserDTO;
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
	
	public User insert (User obj) {
		 return repository.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
		
	}
	
	public User updade(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getNome(), obj.getEmail());
	}

}
