package com.company.UserApp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	@Autowired
	UserRepo repo;

	@PostMapping("/addusers")
	public ResponseEntity<User> AddUser(@Valid @RequestBody User user) {
		final var userdb = repo.save(user);

		final var location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userdb.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> DeleteUser(@PathVariable String id) {
		final var userdb = repo.findById(Integer.parseInt(id))
				.orElseThrow(() -> new RuntimeException(String.format("User with Id as %s n't found,id ")));
		repo.delete(userdb);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/user/{id}")
	public ResponseEntity<User> UpdateUser(@Valid @PathVariable String id, @RequestBody User user) {
		final var userdb = repo.findById(Integer.parseInt(id))
				.orElseThrow(() -> new RuntimeException(String.format("User with Id as %s n't found,id ")));

		user.setId(userdb.getId());
		repo.save(user);
		return ResponseEntity.accepted().build();
	}

	@GetMapping("/get/user")
	public ResponseEntity<List<User>> GetUser() {
		return ResponseEntity.ok(repo.findAll());

	}

	@GetMapping("/getting/{id}")
	public ResponseEntity<EntityModel<User>> GettingUsers(@PathVariable String id) {
		final var userdb = repo.findById(Integer.parseInt(id))
				.orElseThrow(() -> new RuntimeException(String.format("User with Id as %s n't found ", id)));
		final EntityModel<User> model = EntityModel.of(userdb);
		final var newLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).GetUser());
		final var link = newLink.withRel("Additional User info Link");
		model.add(link);
		return ResponseEntity.ok(model);

	}

}
