package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Show;

@Repository
public interface ShowRepo extends JpaRepository<Show, Integer> {
	
}
