package com.generation.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.generation.user.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	List<User> findAllByName(String name);
	User findUserByName(String name);
}
