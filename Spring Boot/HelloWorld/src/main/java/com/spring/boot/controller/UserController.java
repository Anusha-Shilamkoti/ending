package com.spring.boot.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dao.UserRepository;
import com.spring.boot.pojos.User;
@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/getAllusers")
	public Iterable<User>getAllusers()
	{
		return userRepository.findAll();
	}
	
	@PostMapping("/saveUser")

	 public User saveUser(@RequestBody User user)

	 {

	 System.out.println(user);
	 userRepository.save(user);
	 return user;

	 }
	@PutMapping("/updateUser/{username}")

	public User updateUser(@RequestBody User user,@PathVariable("username") String username)
 {
		user.setUsername(username);
 System.out.println(user);
 userRepository.save(user);
 return user;
 }
	@GetMapping("/find/{username}")
	public User find( @PathVariable("username")String username)
	{
		
		Optional<User> user=userRepository.findById(username);
		return user.get();
	}
}


		
	

