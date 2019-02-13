package com.rest.firstExample.restproject.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.rest.firstExample.restproject.model.Post;
import com.rest.firstExample.restproject.model.User;
import com.rest.firstExample.restproject.service.UserNotFoundException;

@Repository
public class UserDao {

	private static Map<Integer,User> users = new HashMap<Integer,User>();
	private static int count=3;

	static {
		
		for(int i=1;i<4;i++){
			users.put(i,new User(i, "User"+i, 25000+i));
		}
		
		 
	}

	public List<User> findAll() {
		return new ArrayList<User>( users.values());
	}

	public User findOne(int id) {
		
		if(!users.containsKey(id)) 
			throw new UserNotFoundException("User ID passed is not Valid"+id);
		
		 return users.get(id);
	}

	public User deleteById(int id) {
		
		if(!users.containsKey(id)) 
			throw new UserNotFoundException("User ID passed is not Valid"+id);
		
		 return users.remove(id);
	}

	public User save(User user) {
		 return users.put(user.getId(), user);
	}

	public void createPost(int id, Post post) {
		if(id>count){
			throw new UserNotFoundException("User ID passed is not Valid"+id);
		}
		User user=users.get(id);
		user.getPosts().add(post);
		 
	}

	public List<Post> getPosts(int id) {
		 
		return users.get(id).getPosts();
		
	}

}
