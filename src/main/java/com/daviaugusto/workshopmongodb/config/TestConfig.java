package com.daviaugusto.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.daviaugusto.workshopmongodb.domain.Post;
import com.daviaugusto.workshopmongodb.domain.User;
import com.daviaugusto.workshopmongodb.dto.CommentDTO;
import com.daviaugusto.workshopmongodb.dto.PostDTO;
import com.daviaugusto.workshopmongodb.repositories.PostRepositoty;
import com.daviaugusto.workshopmongodb.repositories.UserRepositoty;



@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepositoty repository;
	
	@Autowired
	private PostRepositoty postRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		repository.deleteAll();
		postRepository.deleteAll();
		
		User davi = new User(null, "Davi Augusto", "davi@gmail.com");
		User daniel = new User(null, "Daniel Miranda", "daniel@gmail.com");
		User suzy = new User(null, "Suzy Cristina", "suzy@gmail.com");
		User maria = new User(null, "Maria Santos", "maria@gmail.com");
		
		
		repository.saveAll(Arrays.asList(daniel, suzy, maria, davi));
		
		Post post1 = new Post(null, sdf.parse("18/05/2023"), "Aniversário", "Parabens para mim, 18 anos", new PostDTO(maria));
		Post post2 = new Post(null, sdf.parse("15/03/2023"), "Receita de Bolo", "Coloque três chicaras de açucar, depois acrescente leite", new PostDTO(suzy));
		
		CommentDTO com1 = new CommentDTO(null, "Feliz Aniversário", sdf.parse("19/05/2023"), new PostDTO(davi));
		CommentDTO com2 = new CommentDTO(null, "Meus Parabéns Maria, muitos anos de vida", sdf.parse("19/05/2023"), new PostDTO(suzy));
		CommentDTO com3 = new CommentDTO(null, "Ótima receita, vou fazer depois", sdf.parse("18/03/2023"), new PostDTO(daniel));
		
		post1.getComments().addAll(Arrays.asList(com1, com2));
		post2.getComments().addAll(Arrays.asList(com3));
	
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPost().add(post1);
		suzy.getPost().add(post2);
		repository.saveAll(Arrays.asList(maria, suzy));
		
	}

}
