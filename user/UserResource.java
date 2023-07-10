package br.com.compassuol.pb.challenge.products.user;

import java.util.List;

import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDAOService service;

	public UserResource(UserDAOService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable long id){
		return service.findOne(id);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = service.save(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PutMapping("/users/{id}") 
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User updatedUser) {
		User existingUser = service.findOne(id);

		if (existingUser == null) {
			throw new NotFoundException("User not found");
		}

		existingUser.setFirstName(updatedUser.getFirstName());
		existingUser.setLastName(updatedUser.getLastName());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setPassword(updatedUser.getPassword());

		User updatedUserResult = service.save(existingUser);
		return new ResponseEntity<>(updatedUserResult, HttpStatus.OK);
	}
}