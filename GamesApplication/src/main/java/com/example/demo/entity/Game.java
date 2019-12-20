package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Game {

	@Id
	private int gameId;
	private String gameName;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "game")
	List<Prize> listPrize;
	@ManyToOne(cascade = CascadeType.ALL)
	private Venue venue;
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Game(int gameId, String gameName, List<Prize> listPrize, Venue venue) {
		super();
		this.gameId = gameId;
		this.gameName = gameName;
		this.listPrize = listPrize;
		this.venue = venue;
	}

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

	public List<Prize> getListPrize() {
		return listPrize;
	}

	public void setListPrize(List<Prize> listPrize) {
		this.listPrize = listPrize;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	
	
	
}
