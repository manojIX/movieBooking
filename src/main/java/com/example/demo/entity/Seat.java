package com.example.demo.entity;

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
	@JoinColumn(name="screen_id" ,referencedColumnName = "id")
	private Screen screen;
	
	@Column(name = "row_id")
	private Character row;
	
	@Column(name = "column_no")
	private int column;
	
	public Seat() {}
	
	public Seat(int id, int col,Character row) {
		this.id=id;
		this.column=col;
		this.row=row;
	}

	public int getId() {
		return id;
	}

	public Screen getScreen() {
		return screen;
	}

	public Character getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
}
