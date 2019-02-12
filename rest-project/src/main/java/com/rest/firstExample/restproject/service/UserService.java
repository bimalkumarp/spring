package com.rest.firstExample.restproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@DeleteMapping("/Users/{id}")
	public void deleteUser(@PathVariable int id){
		User user=dao.deleteById(id);
		
		if(user==null){
			throw new userException("id-" +id);
		}
	}
	

	@PostMapping("/Users")
	public String createUser(@RequestBody User user){
		User users= dao.save(user);
		
		/*URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(users.getId()).toUri();
		
		return ResponseEntity.created(location).build();*/
		return "Sucessful adding user with id :" +users.getId();
			
	}
	
	/*@GetMapping("/Users/{id}/posts")
	public List<User> retrieveAllPostUsers(@){
		return dao.countUpdate(user);
			
	}*/

}
