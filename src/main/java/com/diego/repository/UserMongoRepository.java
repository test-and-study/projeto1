package com.diego.repository;


import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.diego.entity.UserMongo;

public interface UserMongoRepository extends MongoRepository<UserMongo, Long>{
	
	//List<User> findByName(String name);
	
	List<UserMongo> findByNameIgnoreCaseLike(String name);
	
	
	@Query("{'email' : ?0}")
	List<UserMongo> findByEmailIgnoreCaseLike(String email);
	
	
	//Missão
	//Implementar todos os métodos magicos 
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	
	

}
