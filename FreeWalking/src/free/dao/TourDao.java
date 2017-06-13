package free.dao;

import java.sql.Date;
import java.util.List;

import free.domain.Tour;
import free.domain.TourV2;

public interface TourDao {
	
	public int createTour(Tour tour);
	
	public boolean updateTour(Tour tour);
	
	public boolean deleteTour(int tourId);
	
	public List<TourV2> searchTourByMemberId(String memberId);
	
	public Tour searchTourByTour(int tourId);
	
	public List<Tour> searchTourByDatePlace(Date date, int placeId);
	
	public List<Tour> searchAllTour();
	
	public List<Tour> searchTourByMemberIdDate(String memberId, Date date);

	public List<TourV2> searchTourByCondition(String firstDate, String lastDate, int people, int placeId);
	
	public List<Tour> searchTourByGuideIdStartDate(String guideId, String startDate);
	
	public TourV2 searchTourV2ById(int id);
	
}
