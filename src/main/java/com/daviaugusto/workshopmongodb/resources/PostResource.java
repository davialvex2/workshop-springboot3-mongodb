package com.daviaugusto.workshopmongodb.resources;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.daviaugusto.workshopmongodb.domain.Post;
import com.daviaugusto.workshopmongodb.resources.util.URL;
import com.daviaugusto.workshopmongodb.services.PostService;

;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findByIdPost(@PathVariable String id){
		Post post = postService.findbyid(id);
		return ResponseEntity.ok().body(post);
		}
	
	@GetMapping(value="/titlesearch")
 	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(defaultValue="") String text) {
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
 