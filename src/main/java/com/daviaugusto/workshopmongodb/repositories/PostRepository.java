package com.daviaugusto.workshopmongodb.repositories;



import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.daviaugusto.workshopmongodb.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	
	@Query("{ 'titulo': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitulo(String text);
	
	List<Post> findByTituloContainingIgnoreCase(String text);
	
	@Query("{ $and: [ { data: {$gte: ?1} }, { data: { $lte: ?2} } , { $or: [ { 'titulo': { $regex: ?0, $options: 'i' } }, { 'corpo': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullBusca(String text, Date minDate, Date maxDate);


}
