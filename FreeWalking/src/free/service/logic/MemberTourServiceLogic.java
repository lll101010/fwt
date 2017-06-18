package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.FileDao;
import free.dao.MemberLocationDao;
import free.dao.MemberTourDao;
import free.dao.PlaceDao;
import free.domain.File;
import free.domain.MemberLocation;
import free.domain.MemberTour;
import free.domain.TourV2;
import free.service.MemberTourService;

@Service
public class MemberTourServiceLogic implements MemberTourService{
	@Autowired
	private MemberTourDao dao;
	@Autowired
	private PlaceDao pdao;
	@Autowired
	private FileDao fdao;
	@Autowired
	private MemberLocationDao mldao;
	
	@Override
	public boolean registerMemberTour(String memberId, int tourId) {
		MemberLocation ml =  new MemberLocation();
		ml.setLatitude("0");
		ml.setLongitude("0");
		ml.setTourid(tourId);
		ml.setMemberid(memberId);
		mldao.createMemberLocation(ml);
		
		return dao.createMemberTour(memberId, tourId);
	}

	@Override
	public boolean removeMemberTour(int tourId, String memberId) {
		return dao.deleteMemberTour(memberId, tourId);
	}
	
	@Override
	public boolean removeMemberTour(int tourId) {
		return dao.deleteMemberTourByTourId(tourId);
	}

	@Override
	public List<MemberTour> findMemberByMemberTour(int tourId) {
		return dao.searchMemberByTourId(tourId);
	}

	@Override
	public List<TourV2> findTourByMemberTour(String memberId) {
		
		List<TourV2> list = dao.searchTourByMemberId(memberId);
		for(TourV2 t : list ){
			t.setPlace(pdao.searchPlaceById(t.getPlaceId()));
			File f = fdao.searchFileByTourId(t.getId());
			t.setFile(f);
		}
		
		return list; 
	}

	@Override
	public boolean findMemberTourByAll(String memberId, int tourId) {
		return dao.findMemberTourByAll(memberId, tourId);
	}

}
