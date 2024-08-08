package com.example.demo.show;

import java.time.LocalDateTime;

import com.example.demo.screen.Screen;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shows")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	
	private String movie;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="screen_id" ,referencedColumnName = "id")
	private Screen screen;
	
	private LocalDateTime time;
}
