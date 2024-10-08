package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
	@Query("select new Seat(s.id,s.column,s.row) from Seat s join s.screen t join t.shows x where x.id = ?1")
	public List<Seat> findSeatByShow(int show_id);
}
