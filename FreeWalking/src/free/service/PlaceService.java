package free.service;

import java.util.List;

import free.domain.Place;

public interface PlaceService {
	
	public boolean registerPlace(Place place);
	
	public boolean modifyPlace(Place place);
	
	public boolean removePlace(int placeId);
	
	public List<Place> findAllPlace();
	
	public Place findPlaceByPlaceId(int placeId);

}
