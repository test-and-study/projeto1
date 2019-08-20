package com.diego.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.diego.entity.User;
import com.diego.entity.UserMongo;
import com.diego.repository.UserMongoRepository;
import com.diego.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserMongoRepository userMongoRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		System.out.println("Ai pai para!");

		List<User> users = userRepository.findAll();
		//if (users.isEmpty()) {

			this.createUser("Diego", "diego.fernandes.rego@gmail");
			this.createUser("Danielle", "dany@gmail");
			this.createUser("Zilma", "zilma@gmail");
			this.createUser("Antonio", "antonioo@gmail");
			this.createUser("Joao", "joao@gmail");
			this.createUser("Maria", "maria@gmail");
		//}

			
			
		// User user = userRepository.getOne(1L);
		// System.out.println(user.getName()+" / " + user.getEmail());

		// User user = userRepository.findByName("Dieg");
		// System.out.println(user.getId() + " / " + user.getName());

		User user = userRepository.findByNameQualquerCoisa("mam");
		System.out.println(user.getId() + " / " + user.getName());
		
		
		
		
		
		createUserMongo("Diego", "diego.fernandes.rego@gmail");
		createUserMongo("Danielle", "dany@gmail");
		createUserMongo("Zilma", "zilma@gmail");
		createUserMongo("Antonio", "antonioo@gmail");
		createUserMongo("Joao", "joao@gmail");
		createUserMongo("Maria", "maria@gmail");
		
		List<UserMongo> userMongo = userMongoRepository.findByNameIgnoreCaseLike("die");
		
		for (UserMongo userMongo2 : userMongo) {
			System.out.println("mongo " + userMongo2.getName());
		}
		
		
		List<UserMongo> userEmailMongo = userMongoRepository.findByEmailIgnoreCaseLike("dany@gmail");
		for (UserMongo userMongo2 : userEmailMongo) {
			System.out.println("Email -> " + userMongo2.getEmail());
		}

	}

	public void createUser(String name, String email) {
		userRepository.save(new User(name, email));
	}
	
	public void createUserMongo(String name, String email) {
		userMongoRepository.save(new UserMongo(name, email));
	}

}
