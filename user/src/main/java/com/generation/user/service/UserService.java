package com.generation.user.service;

import java.util.List;

import com.generation.user.entity.User;


public interface UserService {
	
	User insertOrUpdate(User entity);

	void delete(int id);

	List<User> getAll();

	User getById(int id);

	List<User> getAllByNome(String name);

	User getByNome(String name);

}
