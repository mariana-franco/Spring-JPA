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

import com.generation.escola.entity.Turno;
import com.generation.escola.service.TurnoService;


@RestController
@CrossOrigin("*")
public class TurnoController {
	
	@Autowired
	private TurnoService service;
	
	@PostMapping("/turno")
	public ResponseEntity<Turno> post(@RequestBody Turno entity){
		try {
			Turno turnoSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(turnoSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@PutMapping("/turno")
	public ResponseEntity<Turno> put(@RequestBody Turno entity){
		try {
			Turno turnoSalvo = this.service.insertOrUpdate(entity);
			return ResponseEntity.ok(turnoSalvo);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@DeleteMapping("/turno/{id}")
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
	
	@GetMapping("/turno/{id}")
	public ResponseEntity<Turno> getById(@PathVariable int id){
		Turno turno = this.service.getById(id);
		
		if(turno == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(turno);
	}
	
	@GetMapping("/turno")
	public ResponseEntity<List<Turno>> getAll(){
		return ResponseEntity.ok(this.service.getAll());
	}
}
