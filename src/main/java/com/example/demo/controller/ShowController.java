package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SeatRepo;
import com.example.demo.dao.ShowRepo;
import com.example.demo.dto.ShowDTO;
import com.example.demo.entity.Seat;
import com.example.demo.entity.Show;
import com.example.demo.service.ShowService;

@RestController
public class ShowController {
	
	@Autowired
	private ShowService service;
	
	@GetMapping("/theater/{theater-id}/screen/{screen-id}/show/{id}")
	public ShowDTO getShow(@PathVariable("id") int id) {
		return service.getShowWithAvailableSeats(id);
	}
}	
