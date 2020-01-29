package com.generation.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.user.entity.User;
import com.generation.user.service.UserService;



@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public ResponseEntity<User> post(@RequestBody User entity){
		try {
			User userSaved = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(userSaved);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> put(@RequestBody User entity){
		try {
			User userSaved = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(userSaved);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		if(this.service.getById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			this.service.delete(id);
			return ResponseEntity.ok("Removido com sucesso.");
		} catch (Exception err) {
			return ResponseEntity.badRequest().body(err.getMessage());
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getById(@PathVariable int id){
		User user = this.service.getById(id);
		
		if(user == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAll(){
		return ResponseEntity.ok(this.service.getAll());
	}
	
	@GetMapping("/user/names/{name}")
	public ResponseEntity<List<User>> getAllByName(@PathVariable String name){
		return ResponseEntity.ok(this.service.getAllByNome(name));
	}
	
	@GetMapping("/user/name/{name}")
	public ResponseEntity<User> getByName(@PathVariable String name){
		return ResponseEntity.ok(this.service.getByNome(name));
	}

}
