package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Venue {
	
	@Id
	private int venueId;
	private String venueName;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "venue")
	private List<Game> listGames;
	
	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venue(int venueId, String venueName, List<Game> listGames) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.listGames = listGames;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public List<Game> getListGames() {
		return listGames;
	}

	public void setListGames(List<Game> listGames) {
		this.listGames = listGames;
	}
	
	

	
	
}
