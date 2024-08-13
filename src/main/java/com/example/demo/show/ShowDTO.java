package com.example.demo.show;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.seat.Seat;

public class ShowDTO {
	private int id;
	private String movie;
	private LocalDateTime time;
	
	private List<Seat> seats;
	
	public ShowDTO(int id,String movie , LocalDateTime time) {this.id = id;this.movie = movie;this.time=time;}

	public ShowDTO() {
	}

	public int getId() {
		return id;
	}

	public String getMovie() {
		return movie;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
}
