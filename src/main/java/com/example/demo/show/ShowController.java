package com.example.demo.show;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.seat.Seat;
import com.example.demo.seat.SeatRepo;

@RestController
public class ShowController {
	
	@Autowired
	private ShowRepo repo;
	@Autowired
	private SeatRepo seatRepo;
	
	@GetMapping("/theater/{theater-id}/screen/{screen-id}/show/{id}")
	public ShowDTO getShow(@PathVariable("id") int id) {
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
