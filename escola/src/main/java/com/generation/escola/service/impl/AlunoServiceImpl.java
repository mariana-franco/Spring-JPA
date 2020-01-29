package com.generation.escola.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.escola.entity.Aluno;
import com.generation.escola.repository.AlunoRepository;
import com.generation.escola.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	@Override
	public Aluno insertOrUpdate(Aluno entity) {
		Aluno alunoSalvo = this.repository.save(entity);
		return alunoSalvo;
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
		
	}

	@Override
	public List<Aluno> getAll() {
		return (List<Aluno>) this.repository.findAll();
	}

	@Override
	public Aluno getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	@Override
	public List<Aluno> getAllByNome(String nome) {
		return (List<Aluno>)this.repository.findAllByNome(nome);
	}

	@Override
	public Aluno getByNome(String nome) {
		return this.repository.findAlunoByNome(nome);
	}
}
