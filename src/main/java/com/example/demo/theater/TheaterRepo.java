package com.example.demo.theater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepo extends JpaRepository<Theater, Integer>{
}
