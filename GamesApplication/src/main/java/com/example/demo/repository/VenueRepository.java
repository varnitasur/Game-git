package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer>{

	Optional<Venue> findByvenueName(String venueName);
}
