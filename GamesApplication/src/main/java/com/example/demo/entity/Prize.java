package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prize {
	
	@Id
	private int prizeId;
	private String win;
	@ManyToOne
	private Game game;
	
	public Prize() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prize(int prizeId, String win, Game game) {
		super();
		this.prizeId = prizeId;
		this.win = win;
		this.game = game;
	}

	public int getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(int prizeId) {
		this.prizeId = prizeId;
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	
	

}
