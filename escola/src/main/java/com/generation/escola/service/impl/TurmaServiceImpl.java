package com.generation.escola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.escola.entity.Turma;
import com.generation.escola.repository.TurmaRepository;
import com.generation.escola.service.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {
	
	@Autowired
	private TurmaRepository repository;

	@Override
	public Turma insertOrUpdate(Turma entity) {
		Turma turmaSalva = this.repository.save(entity);
		return turmaSalva;
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
		
	}

	@Override
	public List<Turma> getAll() {
		return (List<Turma>) this.repository.findAll();
	}

	@Override
	public Turma getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

}
