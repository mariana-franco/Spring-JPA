package com.generation.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.user.entity.State;
import com.generation.user.repository.StateRepository;
import com.generation.user.service.StateService;

@Service
public class StateServiceImpl implements StateService{
	
	@Autowired
	private StateRepository repository;

	@Override
	public State insertOrUpdate(State entity) {
		State stateSaved = this.repository.save(entity);
		return stateSaved;
	}

	@Override
	public void delete(int id) {
		this.repository.deleteById(id);
		
	}

	@Override
	public List<State> getAll() {
		return (List<State>) this.repository.findAll();
	}

	@Override
	public State getById(int id) {
		return this.repository.findById(id).orElse(null);
	}

}
