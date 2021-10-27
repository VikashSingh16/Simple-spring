package com.example.restful.webservice.restfulwebservices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.example.restful.webservice.restfulwebservices.DAO.UserDAO;
import com.example.restful.webservice.restfulwebservices.bean.User;
import com.example.restful.webservice.restfulwebservices.exception.UserNotFoundException;

import java.net.URI;

@RestController
public class UserResource {
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return userDAO.findAll();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable int id) {
		User user=userDAO.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id: "+id);
		
		EntityModel<User> resource=EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> creatingUser(@Valid @RequestBody  User user) {
		
		userDAO.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
	 return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteByid(@PathVariable int id) {
		User user=userDAO.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("id: "+id);
		
	}

}
