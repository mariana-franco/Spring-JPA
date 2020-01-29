package com.generation.escola.controller;

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

import com.generation.escola.entity.Turma;
import com.generation.escola.service.TurmaService;


@RestController
@CrossOrigin("*")
public class TurmaController {
	
	@Autowired
	private TurmaService service;
	
	@PostMapping("/turma")
	public ResponseEntity<Turma> post(@RequestBody Turma entity){
		try {
			Turma turmaSalva = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(turmaSalva);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PutMapping("/turma")
	public ResponseEntity<Turma> put(@RequestBody Turma entity){
		try {
			Turma turmaSalva = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(turmaSalva);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("/turma/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		if(this.service.getById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		
		try {
			this.service.delete(id);
			return ResponseEntity.ok("Removida com sucesso.");
		} catch (Exception err) {
			return ResponseEntity.badRequest().body(err.getMessage());
		}
	}
	
	@GetMapping("/turma/{id}")
	public ResponseEntity<Turma> getById(@PathVariable int id){
		Turma turma = this.service.getById(id);
		
		if(turma == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(turma);
	}
	
	@GetMapping("/turma")
	public ResponseEntity<List<Turma>> getAll(){
		return ResponseEntity.ok(this.service.getAll());
	}

}
