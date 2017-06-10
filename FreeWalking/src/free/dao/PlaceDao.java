package free.dao;

import java.util.List;

import free.domain.Place;

public interface PlaceDao {
	
	public boolean createPlace(Place place);
	
	public boolean updatePlace(Place place);
	
	public boolean deletePlace(int placeId);
	
	public Place searchPlaceById(int placeId);
	
	public List<Place> searchAllPlace();

}
