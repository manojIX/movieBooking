package com.example.demo.screen;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScreenController {
	
	@Autowired
	private ScreenRepo repo;
	
	@GetMapping("/theater/{theater}/screen/{id}")
	public Optional<Screen> getScreen(@PathVariable("id") int id) {
		return repo.findById(id);
	}
}
