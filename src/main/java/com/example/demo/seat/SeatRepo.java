package com.example.demo.seat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
	@Query("select new Seat(s.id,s.column,s.row) from Seat s join s.screen t join t.shows x where x.id = ?1")
	public List<Seat> findSeatByShow(int show_id);
}
