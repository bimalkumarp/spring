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
import com.rest.firstExample.restproject.model.Post;
import com.rest.firstExample.restproject.model.User;

@RestController
public class UserService {
	
	@Autowired
	UserDao dao;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return dao.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getSingleUser(@PathVariable int id){
		User user= dao.findOne(id);
		
		if(user==null){
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		User user=dao.deleteById(id);
		
		if(user==null){
			throw new UserNotFoundException("id-" +id);
		}
	}
	

	@PostMapping("/users")
	public String createUser(@RequestBody User user){
		User users= dao.save(user);
		
		/*URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(users.getId()).toUri();
		
		return ResponseEntity.created(location).build();*/
		return "Sucessful adding user with id :" +users.getId();
			
	}
	
	
	@PostMapping("/users/{id}/posts")
	public void createPost(@PathVariable int id, @RequestBody Post post){
		
		
		 dao.createPost(id,post);
		
		 
			
	}
	
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getPosts(@PathVariable int id){
		
		
		return dao.getPosts(id);
		
		 
			
	}
	
	
}
