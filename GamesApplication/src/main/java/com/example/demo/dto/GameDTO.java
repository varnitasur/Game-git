package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class GameDTO {
	
	private int gameId;
	private String gameName;
	@JsonIgnoreProperties("game")
	List<PrizeDTO> listprize;
	@JsonIgnoreProperties("listGames")
	private VenueDTO venue;
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public List<PrizeDTO> getListprize() {
		return listprize;
	}
	public void setListprize(List<PrizeDTO> listprize) {
		this.listprize = listprize;
	}
	public VenueDTO getVenue() {
		return venue;
	}
	public void setVenue(VenueDTO venue) {
		this.venue = venue;
	}
	

}
