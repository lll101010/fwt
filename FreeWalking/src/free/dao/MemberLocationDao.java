package free.dao;

import java.util.List;

import free.domain.MemberLocation;

public interface MemberLocationDao {
	
	public boolean createMemberLocation(MemberLocation memberLocation);
	public boolean updateMemberLocation(MemberLocation memberLocation);
	public List<MemberLocation> searchByTourid(int tourid); 

}
