package free.service.logic;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.FileDao;
import free.dao.MemberLocationDao;
import free.dao.MemberTourDao;
import free.dao.PlaceDao;
import free.dao.TourDao;
import free.domain.File;
import free.domain.MemberLocation;
import free.domain.Place;
import free.domain.Tour;
import free.domain.TourV2;
import free.service.TourService;

@Service
public class TourServiceLogic implements TourService {
	
	@Autowired
	private TourDao dao;
	@Autowired
	private FileDao fdao;
	@Autowired
	private PlaceDao pdao;
	@Autowired
	private MemberTourDao mTdao;
	@Autowired
	private MemberLocationDao mldao;
	
	@Override
	public boolean registerTour(Tour tour) {
		int tourid = dao.createTour(tour);
		MemberLocation ml = new MemberLocation();
		ml.setMemberid(tour.getGuideId());
		ml.setTourid(tourid);
		ml.setLatitude("0");
		ml.setLongitude("0");
		mldao.createMemberLocation(ml);
		return fdao.createTourFile(tour.getFile(), tourid);
	}
 
	@Override
	public boolean modifyTour(Tour tour) {
		return dao.updateTour(tour);
	}
 
	@Override
	public boolean removeTour(int tourId) {
		mTdao.deleteMemberTourByTourId(tourId);
		return dao.deleteTour(tourId);
	}
 
	@Override
	public List<Tour> findAllTour() {
		return dao.searchAllTour();
	}
 
	@Override
	public Tour findTourByTourId(int tourId) {
		return dao.searchTourByTour(tourId);
	}
 
	@Override
	public List<TourV2> findTourByMemberId(String memberId) {
		
		List<TourV2> tourList = dao.searchTourByMemberId(memberId);
		
		for(TourV2 t : tourList) {
			t.setPlace(pdao.searchPlaceById(t.getPlaceId()));
			File f = fdao.searchFileByTourId(t.getId());
			t.setFile(f);
		}
		
		return tourList;
	}
 
	@Override
	public List<Tour> findTourByPlaceDate(Date date, Place place) {
		return dao.searchTourByDatePlace(date, place.getId());
	}
 
	@Override
	public List<Tour> findTourByMemberDate(String memberId, Date date) {
		return dao.searchTourByMemberIdDate(memberId, date);
	}
 
	
	@Override
	public List<TourV2> findTourByCondition(String firstDate, String lastDate, int people, int placeId) {
		List<TourV2> tours = dao.searchTourByCondition(firstDate, lastDate, people, placeId);
		for(TourV2 t: tours) {
			File f = fdao.searchFileByTourId(t.getId());
			t.setFile(f);
		}
		return tours;
	}
	
	@Override
	public List<Tour> findTourByGuideIdStartdate(String guideId, String startDate) {
		return dao.searchTourByGuideIdStartDate(guideId, startDate);
	}
	
	@Override
	public TourV2 findTourV2ByTourId(int id) {
		return dao.searchTourV2ById(id);
	}
	
	@Override
	public List<TourV2> findTourByToday(int placeId) {
		return dao.searchTourByToday(placeId);
	}
	
	@Override
	public List<Tour> findAllTourByPlaceId(int placeId) {
		return dao.searchAllTourByPlaceId(placeId);
	}
	
	@Override
	public List<Tour> findTourByCorrectDate(String startDate) {
		return dao.searchTourByCorrectDate(startDate);
	}
}
