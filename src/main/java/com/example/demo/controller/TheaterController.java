package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TheaterRepo;
import com.example.demo.entity.Theater;

import jakarta.websocket.server.PathParam;

@RestController
public class TheaterController {
	
	@Autowired
	private TheaterRepo repo;
	
	@GetMapping("/theater")
	public List<Theater> getTheaters(){
		return repo.findAll();
	}
	
	@GetMapping("/theater/{id}")
	public Optional<Theater> getTheater(@PathVariable("id") int theater_id) {
		System.out.println(theater_id);
		return repo.findById(theater_id);
	}
	
	
}
