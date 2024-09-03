package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	Optional<User> findByEmail(String email);
}
