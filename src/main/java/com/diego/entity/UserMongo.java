package com.diego.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserMongo {

	@Id
	private String id;
	private String name;
	private String email;
	
	
	public UserMongo() {
		
	}

	public UserMongo(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	private Set<Role> roles;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
