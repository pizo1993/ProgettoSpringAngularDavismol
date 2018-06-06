package net.davismol.springangulardemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.davismol.springangulardemo.exception.ResourceNotFoundException;
import net.davismol.springangulardemo.repository.UserRepository;
import net.davismol.springangulardemo.viewmodels.UserViewModel;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	// Get All Users
	@GetMapping("/users")
	public List<UserViewModel> getAllUsers() {
	    return userRepository.findAll();
	}
	
	// Create a new User
	@PostMapping("/users")
	public UserViewModel createNote(@Valid @RequestBody UserViewModel user) {
	    return userRepository.save(user);
	}
	
	// Get a Single User
	@GetMapping("/users/{id}")
	public UserViewModel getUserById(@PathVariable(value = "id") Long userId) {
	    return userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
	}
	
	// Update a User
	@PutMapping("/users/{id}")
	public UserViewModel updateUser(@PathVariable(value = "id") Long userId,
	                                        @Valid @RequestBody UserViewModel userDetails) {

	    UserViewModel user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	    user.setAge(userDetails.getAge());
	    user.setCountry(userDetails.getCountry());

	    UserViewModel updatedUser = userRepository.save(user);
	    return updatedUser;
	}
	
	// Delete a User
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
	    UserViewModel user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	    userRepository.delete(user);

	    return ResponseEntity.ok().build();
	}
	
}