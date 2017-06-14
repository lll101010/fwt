package free.dao;

import java.util.List;

import free.domain.Member;
import free.domain.Tour;
import free.domain.TourV2;

public interface MemberTourDao {
	
	public boolean createMemberTour(String memberId, int tourId);
	
	public boolean deleteMemberTour(String memberId, int tourId);
	
	public boolean deleteMemberTourByTourId(int tourId);
	
	public List<TourV2> searchTourByMemberId(String memberId);
	
	public List<Member> searchMemberByTourId(int tourId);
	
	public boolean findMemberTourByAll(String memberId, int tourId);
	

}
