package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class BookDTO {
	
	@NotNull(message="User id must not be null")
	private Integer user_id;
	@NotNull
	private Integer theater_id;
	@NotNull
	private Integer screen_id;
	@NotNull(message = "Seat id must not be null")
	private Integer seat_id;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTheater_id() {
		return theater_id;
	}
	public void setTheater_id(int theater_id) {
		this.theater_id = theater_id;
	}
	public int getScreen_id() {
		return screen_id;
	}
	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	@Override
	public String toString() {
		return "BookDTO [user_id=" + user_id + ", theater_id=" + theater_id + ", screen_id=" + screen_id + ", seat_id="
				+ seat_id + "]";
	}
}
