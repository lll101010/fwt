package daotest;

import static org.junit.Assert.*;

import org.junit.Test;

import free.dao.MemberDao;
import free.dao.PlaceDao;
import free.dao.logic.MemberDaoLogic;
import free.dao.logic.PlaceDaoLogic;
import free.domain.Member;
import free.domain.Place;


public class MemberDaoTest {

	PlaceDao dao = new PlaceDaoLogic();
	
	@Test
	public void testCreateMember() {
		Place p = dao.searchPlaceById(1);
		
		System.out.println(p.getLatitude());
	}
//
//	@Test
//	public void testUpdateMember() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDeleteMember() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSearchMemberById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSearchAllMember() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSearchByNamePhone() {
//		fail("Not yet implemented");
//	}

}
