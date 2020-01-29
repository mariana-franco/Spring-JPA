package com.generation.escola.service;

import java.util.List;

import com.generation.escola.entity.Turno;


public interface TurnoService {
	
	Turno insertOrUpdate(Turno entity);

	void delete(int id);

	List<Turno> getAll();

	Turno getById(int id);
}
