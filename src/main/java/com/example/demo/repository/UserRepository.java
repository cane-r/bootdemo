package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository("userRepo")
public interface UserRepository extends BaseRepository<User, Long> {
	
}
