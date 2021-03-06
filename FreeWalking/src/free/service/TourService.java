package free.service;

import java.sql.Date;
import java.util.List;

import free.domain.Place;
import free.domain.Tour;
import free.domain.TourV2;

public interface TourService {

	public boolean registerTour(Tour tour);

	public boolean modifyTour(Tour tour);

	public boolean removeTour(int tourId);

	public List<Tour> findAllTour();

	public Tour findTourByTourId(int tourId);

	public List<TourV2> findTourByMemberId(String memberId);

	public List<Tour> findTourByPlaceDate(Date date, Place place);

	public List<Tour> findTourByMemberDate(String memberId, Date date);

	public List<TourV2> findTourByCondition(String firstDate, String lastDate, int people, int placeId);

	public List<Tour> findTourByGuideIdStartdate(String guideId, String startDate);

	public TourV2 findTourV2ByTourId(int id);
	
	public List<TourV2> findTourByToday(int placeId);
	
	public List<Tour> findAllTourByPlaceId(int placeId);
	
	public List<Tour> findTourByCorrectDate(String startDate);
}
