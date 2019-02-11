package com.rest.firstExample.restproject.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.firstExample.restproject.dao.UserDao;
import com.rest.firstExample.restproject.model.User;

@RestController
public class UserService {
	
	@Autowired
	UserDao dao;
	
	@GetMapping("/Users")
	public List<User> getAllUsers(){
		return dao.findAll();
	}
	
	@GetMapping("/Users/{id}")
	public User getSingleUser(@PathVariable int id){
		User user= dao.findOne(id);
		
		if(user==null){
			throw new userException("id-"+id);
		}
		return user;
	}
	
	

	@PostMapping("/Users")
	public String createUser(@RequestBody User user){
		User users= dao.save(user);
		
		/*URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(users.getId()).toUri();
		
		return ResponseEntity.created(location).build();*/
		return "Sucessful adding user with id :" +users.getId();
			
	}

}
