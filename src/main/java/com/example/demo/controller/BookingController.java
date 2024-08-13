package com.example.demo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDTO;

import jakarta.validation.Valid;

@RestController
public class BookingController {
	
	@PostMapping("/book")
	public void bookTicket(@RequestBody @Valid BookDTO details) {
		System.out.println(details);
	}
}
