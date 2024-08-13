package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.dao.SeatRepo;
import com.example.demo.dao.ShowRepo;
import com.example.demo.dto.ShowDTO;
import com.example.demo.entity.Seat;
import com.example.demo.entity.Show;

@Service
public class ShowService {

	@Autowired
	private ShowRepo repo;
	@Autowired
	private SeatRepo seatRepo;
	
	public ShowDTO getShowWithAvailableSeats(int id) {
		Show s = repo.findById(id).get();
		ShowDTO ss = new ShowDTO();
		ss.setId(s.getId());
		ss.setMovie(s.getMovie());
		ss.setTime(s.getTime());
		List<Seat> seats = seatRepo.findSeatByShow(id);
		System.out.println(id  + ' ' + seats.size());
		ss.setSeats(seats);
		return ss;
	}
}
