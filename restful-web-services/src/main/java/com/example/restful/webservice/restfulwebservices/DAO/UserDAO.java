package com.example.restful.webservice.restfulwebservices.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.restful.webservice.restfulwebservices.bean.User;

@Component
public class UserDAO {
	
	private static List<User> users=new ArrayList<>();
	private static int userCount=3;
	
	static {
		users.add(new User(1,"Vikash Singh",new Date()));
		users.add(new User(2,"Jai Singh",new Date()));
		users.add(new User(3,"Akash Singh",new Date()));
	}

	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id)
				return user;
		}
		return null;
	}
	public User deleteById(int id) {
		Iterator<User> iterator=users.iterator();
		while(iterator.hasNext()) {
			User user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
