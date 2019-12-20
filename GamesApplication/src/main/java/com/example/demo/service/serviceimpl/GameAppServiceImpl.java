package com.example.demo.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.GameDTO;
import com.example.demo.dto.PrizeDTO;
import com.example.demo.dto.VenueDTO;
import com.example.demo.entity.Game;
import com.example.demo.entity.Prize;
import com.example.demo.entity.Venue;
import com.example.demo.exception.ErrorConstant;
import com.example.demo.exception.ServiceException.NoSuchPrizeFound;
import com.example.demo.exception.ServiceException.NoSuchVenueFound;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.PrizeRepository;
import com.example.demo.repository.VenueRepository;
import com.example.demo.service.GameAppService;

@Service
public class GameAppServiceImpl implements GameAppService {
	
	@Autowired
	GameRepository gameRepose;
	@Autowired
	PrizeRepository prizeRepose;
	@Autowired
	VenueRepository venueRepose;
	
	
	ModelMapper modelMapper = new ModelMapper();
	
	private Game convertDTOToEntity(GameDTO gameDto) {
		return modelMapper.map(gameDto,Game.class);
	}
	
	private Prize convertDTOToEntity(PrizeDTO prizeDto) {
		return modelMapper.map(prizeDto,Prize.class);
	}
	
	private Venue convertDTOToEntity(VenueDTO venueDto) {
		return modelMapper.map(venueDto,Venue.class);
	}
	
	
	private GameDTO convertEntityToDTO(Game game) {
		return modelMapper.map(game,GameDTO.class);
	}
	
	private PrizeDTO convertEntityToDTO(Prize prize) {
		return modelMapper.map(prize,PrizeDTO.class);
	}
	
	private VenueDTO convertEntityToDTO(Venue venue) {
		return modelMapper.map(venue,VenueDTO.class);
	}
	
	

	@Override
	public String addGameDetails(GameDTO gameDto) {
		Game game= convertDTOToEntity(gameDto);
		game.setVenue(game.getVenue());
		game.getListPrize().forEach(i->{
			i.setGame(game);
		});
		gameRepose.save(game);
		return "AddedSuccesfully";
	}

	@Override
	public List<GameDTO> getAllGameDetails(String venueName) throws ServiceException {
		Optional<Venue> venue=venueRepose.findByvenueName(venueName);
		try {
			venue.orElseThrow(()->new NoSuchVenueFound(ErrorConstant.NoSuchVenueFound));
		} catch (NoSuchVenueFound e) {
			throw new ServiceException(e.getMessage());
		}
		Venue venueObj= venue.get();
		
		return venueObj.getListGames().parallelStream().map(i->convertEntityToDTO(i)).collect(Collectors.toList());
	}

	@Override
	public List<GameDTO> getGameByPrize(String prizeName) throws ServiceException {
		Optional<Prize> prize=prizeRepose.findBywin(prizeName);
		try {
			prize.orElseThrow(()->new NoSuchPrizeFound(ErrorConstant.NoSuchVenueFound));
		} catch (NoSuchPrizeFound e) {
			throw new ServiceException(e.getMessage());
		}
		List<Game> gameList=new ArrayList<Game>();
		gameRepose.findAll().forEach(i->
		{
			i.getListPrize().forEach(j->{
				if(j.getWin().equalsIgnoreCase(prizeName)) {
					gameList.add(i);
				}
			});
		});
		return gameList.parallelStream().map(k->convertEntityToDTO(k)).collect(Collectors.toList());
	}

	@Override
	public String deleteByPrize(int prizeId) {
		prizeRepose.deleteById(prizeId);
		return "deleted";
	}

}
