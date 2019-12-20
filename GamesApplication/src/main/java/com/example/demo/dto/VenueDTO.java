package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class VenueDTO {
	
	private int venueId;
	private String venueName;
	@JsonIgnoreProperties("venue")
	List<GameDTO> listGames;
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
	public List<GameDTO> getListGames() {
		return listGames;
	}
	public void setListGames(List<GameDTO> listGames) {
		this.listGames = listGames;
	}
	

}
