package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.GameDTO;

public interface GameAppService {

	 String addGameDetails(GameDTO gameDto);

	List<GameDTO> getAllGameDetails(String venueName);

	List<GameDTO> getGameByPrize(String prizeName);

	String deleteByPrize(int prizeId);

}
