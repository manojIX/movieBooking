package com.example.demo.screen;

import java.util.List;

import com.example.demo.show.Show;
import com.example.demo.theater.Theater;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class Screen {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String name;
	
	@OneToMany(mappedBy = "screen")
	@JsonManagedReference
	private List<Show> shows;
	
	@ManyToOne(optional = false , cascade = CascadeType.ALL)
	@JoinColumn(name="theater_id" ,referencedColumnName = "id")
	@JsonBackReference
	Theater theater;

	public List<Show> getShows() {
		return shows;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Theater getTheater() {
		return theater;
	}
	
	
	
	
}
