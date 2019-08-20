package com.diego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diego.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	//List<User> findByName(String name);
	
	User findByName(String name);
	
	
	//@Query("select u from User u where u.name like = ?1")
	@Query("select u from User u where u.name like %?1%")
	User findByNameQualquerCoisa(String name);
	
	
	//Missão
	//Implementar todos os métodos magicos 
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
	
	

}
