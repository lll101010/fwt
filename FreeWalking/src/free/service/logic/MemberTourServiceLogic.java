package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.MemberTourDao;
import free.domain.Member;
import free.domain.Tour;
import free.service.MemberTourService;

@Service
public class MemberTourServiceLogic implements MemberTourService{
	@Autowired
	private MemberTourDao dao;
	
	@Override
	public boolean registerMemberTour(String memberId, int tourId) {
		return dao.createMemberTour(memberId, tourId);
	}

	@Override
	public boolean removeMemberTour(int tourId, String memberId) {
		return dao.deleteMemberTour(memberId, tourId);
	}

	@Override
	public List<Member> findMemberByMemberTour(int tourId) {
		return dao.searchMemberByTourId(tourId);
	}

	@Override
	public List<Tour> findTourByMemberTour(String memberId) {
		return dao.searchTourByMemberId(memberId);
	}

	@Override
	public boolean findMemberTourByAll(String memberId, int tourId) {
		return dao.findMemberTourByAll(memberId, tourId);
	}

}
