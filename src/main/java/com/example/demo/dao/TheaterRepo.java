package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Theater;

@Repository
public interface TheaterRepo extends JpaRepository<Theater, Integer>{
}
