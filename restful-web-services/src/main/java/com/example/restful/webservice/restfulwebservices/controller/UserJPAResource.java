package com.example.restful.webservice.restfulwebservices.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.restful.webservice.restfulwebservices.DAO.PostRepository;
import com.example.restful.webservice.restfulwebservices.DAO.UserDAO;
import com.example.restful.webservice.restfulwebservices.DAO.UserRepository;
import com.example.restful.webservice.restfulwebservices.bean.Post;
import com.example.restful.webservice.restfulwebservices.bean.User;
import com.example.restful.webservice.restfulwebservices.exception.UserNotFoundException;

import java.net.URI;

@RestController
public class UserJPAResource {
	
	
	@Autowired
	private UserRepository repository;
	

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable int id) {
		Optional<User> user=repository.findById(id);
		if(!user.isPresent())
			throw new UserNotFoundException("id: "+id);
		
		EntityModel<User> resource=EntityModel.of(user.get());
		
		WebMvcLinkBuilder linkTo=linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping("/jpa/user")
	public ResponseEntity<Object> creatingUser(@Valid @RequestBody  User user) {
		
		repository.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
	 return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/user/{id}")
	public void deleteByid(@PathVariable int id) {
		repository.deleteById(id);
		
		
	}
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id) {
		Optional<User> userOptional = repository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return userOptional.get().getPosts();
	}


	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userOptional = repository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		User user = userOptional.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}


}
