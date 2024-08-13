package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Screen;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Integer>{

}
