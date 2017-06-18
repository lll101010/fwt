package free.service;

import java.util.List;

import free.domain.MemberLocation;

public interface MemberLocationService {

	public boolean update(MemberLocation memberLocation);
	public List<MemberLocation> searchByTourid(int tourid);
}
