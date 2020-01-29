package com.generation.escola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.generation.escola.entity.Turno;
import com.generation.escola.repository.TurnoRepository;
import com.generation.escola.service.TurnoService;

@Service
public class TurnoServiceImpl implements TurnoService {
	
	@Autowired
	private TurnoRepository repository;

	@Override
	public Turno insertOrUpdate(Turno entity) {
		Turno turnoSalvo = this.repository.save(entity);
		return turnoSalvo;
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
		
	}

	@Override
	public List<Turno> getAll() {
		return (List<Turno>) this.repository.findAll();
	}

	@Override
	public Turno getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

}
