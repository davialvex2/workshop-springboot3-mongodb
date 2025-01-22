package com.daviaugusto.workshopmongodb.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daviaugusto.workshopmongodb.domain.Post;
import com.daviaugusto.workshopmongodb.exception.ObjectNotFoundException;
import com.daviaugusto.workshopmongodb.repositories.PostRepository;




@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	
	public Post findbyid(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	} 
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitulo(text);
	}
	
}
