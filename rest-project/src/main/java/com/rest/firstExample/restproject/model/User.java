package com.rest.firstExample.restproject.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name;
	private int salary;
	private List<Post> posts;
	
	public User(){
		
	}

	public User(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	public List<Post> getPosts() {
		if(posts==null){
			posts=new ArrayList<Post>();
		}
      return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	

}
