package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GameDTO;
import com.example.demo.service.GameAppService;


/**
 * @author M1055907
 *
 */
@RestController
public class DemoController {
	
	@Autowired
	GameAppService service;
	
	
	/**
	 * @param gameDto
	 *@return String whether data inserted or not
	 */
	
	@PostMapping("/addGame")
	public String addGame(@RequestBody GameDTO gameDto) {
		String m=service.addGameDetails(gameDto);
		return m;
	}
	/**
	 * @param venueName
	 *@return list of game details
	 */
	
	
	@GetMapping("/getAllGames/{venueName}")
	public List<GameDTO> getAllGames(@PathVariable String venueName){
		return service.getAllGameDetails(venueName);
	}
	
	/**
	 * @param prizeName
	 *@return list of game details by prize
	 */
	@GetMapping("/getGameByPrize/{prizeName}")
	public List<GameDTO> getGameByPrize(@PathVariable String prizeName){
		return service.getGameByPrize(prizeName);
	}
	@DeleteMapping("/deletePrize/{prizeId}")
	public String deletePrize(@PathVariable int prizeId) {
		String d =service.deleteByPrize(prizeId);
		return d;
	}
	
	
}
