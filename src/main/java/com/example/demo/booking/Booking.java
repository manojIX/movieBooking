package com.example.demo.booking;

import com.example.demo.screen.Screen;
import com.example.demo.seat.Seat;
import com.example.demo.show.Show;
import com.example.demo.theater.Theater;
import com.example.demo.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="user_id" ,referencedColumnName = "id")
	private User user;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="theater_id" ,referencedColumnName = "id")
	private Theater theater;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="screen_id" ,referencedColumnName = "id")
	private Screen screen;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="show_id" ,referencedColumnName = "id")
	private Show show;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="seat_id" ,referencedColumnName = "id")
	private Seat seat;
}
