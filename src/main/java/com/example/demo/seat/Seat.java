package com.example.demo.seat;

import com.example.demo.screen.Screen;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name="theater_id" ,referencedColumnName = "id")
	private Screen screen;
	
	@Column(name = "row_id")
	private Character row;
	
	@Column(name = "column_no")
	private int column;
}
