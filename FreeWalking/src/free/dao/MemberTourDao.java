package free.dao;

import java.util.List;

import free.domain.Member;
import free.domain.Tour;

public interface MemberTourDao {
	
	public boolean createMemberTour(String memberId, int tourId);
	
	public boolean deleteMemberTour(String memberId, int tourId);
	
	public List<Tour> searchTourByMemberId(String memberId);
	
	public List<Member> searchMemberByTourId(int tourId);
	
	public boolean findMemberTourByAll(String memberId, int tourId);
	

}
