package free.dao;

import java.sql.Date;
import java.util.List;

import free.domain.Tour;

public interface TourDao {
	
	public int createTour(Tour tour);
	
	public boolean updateTour(Tour tour);
	
	public boolean deleteTour(int tourId);
	
	public List<Tour> searchTourByMemberId(String memberId);
	
	public Tour searchTourByTour(int tourId);
	
	public List<Tour> searchTourByDatePlace(Date date, int placeId);
	
	public List<Tour> searchAllTour();
	
	public List<Tour> searchTourByMemberIdDate(String memberId, Date date);

	public List<Tour> searchTourByCondition(String firstDate, String lastDate, int people, int placeId);
	
	public int getTourId();
}
