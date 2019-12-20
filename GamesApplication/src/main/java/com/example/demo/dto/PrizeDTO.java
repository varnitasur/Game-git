package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class PrizeDTO {
	
	private int prizeId;
	private String win;
	@JsonIgnoreProperties("listPrize")
	private GameDTO game;
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
	public GameDTO getGame() {
		return game;
	}
	public void setGame(GameDTO game) {
		this.game = game;
	}
	
	

}
