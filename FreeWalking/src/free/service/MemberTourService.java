package free.service;

import java.util.List;

import free.domain.Member;
import free.domain.Tour;
import free.domain.TourV2;

public interface MemberTourService {

	public boolean registerMemberTour(String memberId, int tourId);
	
	public boolean removeMemberTour(int tourId, String memberId);
	
	public boolean removeMemberTour(int tourId);
	
	public List<Member> findMemberByMemberTour(int tourId);
	
	public List<TourV2> findTourByMemberTour(String memberId);
	
	public boolean findMemberTourByAll(String memberId, int tourId);
}
