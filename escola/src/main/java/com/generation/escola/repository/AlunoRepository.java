package com.generation.escola.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.generation.escola.entity.Aluno;



public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

	List<Aluno> findAllByNome(String nome);
	Aluno findAlunoByNome(String nome);

}
