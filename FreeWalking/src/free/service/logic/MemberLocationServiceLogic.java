package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.MemberLocationDao;
import free.domain.MemberLocation;
import free.service.MemberLocationService;

@Service
public class MemberLocationServiceLogic implements MemberLocationService{

	@Autowired
	private MemberLocationDao dao;
	
	@Override
	public boolean update(MemberLocation memberLocation) {
		// TODO Auto-generated method stub
		return dao.updateMemberLocation(memberLocation);
	}

	@Override
	public List<MemberLocation> searchByTourid(int tourid) {
		// TODO Auto-generated method stub
		return dao.searchByTourid(tourid);
	}

}
