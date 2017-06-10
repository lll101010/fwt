package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.PlaceDao;
import free.domain.Place;
import free.service.PlaceService;

@Service
public class PlaceServiceLogic implements PlaceService {
	
	@Autowired
	private PlaceDao dao;

	@Override
	public boolean registerPlace(Place place) {
		return dao.createPlace(place);
	}

	@Override
	public boolean modifyPlace(Place place) {
		return dao.updatePlace(place);
	}

	@Override
	public boolean removePlace(int placeId) {
		return dao.deletePlace(placeId);
	}

	@Override
	public List<Place> findAllPlace() {
		return dao.searchAllPlace();
	}

	@Override
	public Place findPlaceByPlaceId(int placeId) {
		return dao.searchPlaceById(placeId);
	}

}
