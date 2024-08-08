package com.example.demo.screen;

import com.example.demo.theater.Theater;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String name;
	
	@ManyToOne(optional = false , cascade = CascadeType.ALL)
	@JoinColumn(name="theater_id" ,referencedColumnName = "id")
	Theater theater;
}
