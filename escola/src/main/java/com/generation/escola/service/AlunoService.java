package com.generation.escola.service;

import java.util.List;

import com.generation.escola.entity.Aluno;

public interface AlunoService {

	Aluno insertOrUpdate(Aluno entity);

	void delete(int id);

	List<Aluno> getAll();

	Aluno getById(int id);

	List<Aluno> getAllByNome(String nome);

	Aluno getByNome(String nome);
}
