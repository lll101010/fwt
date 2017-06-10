package free.service;

import java.util.List;

import free.domain.Member;
import free.domain.Tour;

public interface MemberTourService {

	public boolean registerMemberTour(String memberId, int tourId);
	
	public boolean removeMemberTour(int tourId, String memberId);
	
	public List<Member> findMemberByMemberTour(int tourId);
	
	public List<Tour> findTourByMemberTour(String memberId);
	
	public boolean findMemberTourByAll(String memberId, int tourId);
}
