package com.rest.firstExample.restproject.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.rest.firstExample.restproject.model.User;

@Repository
public class UserDao {
	
	private static List<User> users= new ArrayList<User>();
	private static List<User> postUsers= new ArrayList<User>();
	private static int count=3;
	public static boolean flag=false;
	
	static{
		users.add(new User(1,"shradha",25000));
		users.add(new User(2,"bimal",55000));
		users.add(new User(3,"sritam",35000));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id){
		for(User user:users){
			if(user.getId()==id){
				return user;
			}
		}
		return null;
	}
	
	public User deleteById(int id){
		Iterator<User> itr=users.iterator();
		while(itr.hasNext()){
			User user=itr.next();
			if(user.getId()==id){
				itr.remove();
				return user;
			}
		}
		return null;
	}
	
	public User save(User user){
		if(user==null){
			user.setId(++count);
			flag=true;
		}
		users.add(user);
		postUsers.add(user);
		return user;
	}
	
	public List<User> countUpdate(User user){
		if(flag==true){
			return postUsers;
		}
		flag=false;
		return null;
	}

}
