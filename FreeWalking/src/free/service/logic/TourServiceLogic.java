package free.service.logic;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.FileDao;
import free.dao.TourDao;
import free.domain.File;
import free.domain.Place;
import free.domain.Tour;
import free.service.TourService;

@Service
public class TourServiceLogic implements TourService {
	
	@Autowired
	private TourDao dao;
	@Autowired
	private FileDao fdao;

	@Override
	public boolean registerTour(Tour tour) {
		return fdao.createTourFile(tour.getFile(), dao.createTour(tour));
	}

	@Override
	public boolean modifyTour(Tour tour) {
		return dao.updateTour(tour);
	}

	@Override
	public boolean removeTour(int tourId) {
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
	public List<Tour> findTourByMemberId(String memberId) {
		return dao.searchTourByMemberId(memberId);
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
	public List<Tour> findTourByCondition(String firstDate, String lastDate, int people, int placeId) {
		List<Tour> tours = dao.searchTourByCondition(firstDate, lastDate, people, placeId);
		for(Tour t: tours) {
			File f = fdao.searchFileByTourId(t.getId());
			t.setFile(f);
		}
		return tours;
	}
}
