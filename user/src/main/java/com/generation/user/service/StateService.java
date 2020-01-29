package com.generation.user.service;

import java.util.List;

import com.generation.user.entity.State;



public interface StateService {
	
	State insertOrUpdate(State entity);

	void delete(int id);

	List<State> getAll();

	State getById(int id);

}
