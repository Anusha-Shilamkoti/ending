package com.spring.boot.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.pojos.User;

public interface UserRepository extends CrudRepository<User,String> {

	
	

}
