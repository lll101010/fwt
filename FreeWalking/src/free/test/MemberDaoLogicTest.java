package free.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import free.dao.logic.MemberDaoLogic;
import free.domain.Member;

public class MemberDaoLogicTest {
	
	MemberDaoLogic dao = new MemberDaoLogic();
	
	@Test
	public void testCreateMember() {
		Member m = new Member("a", "a", "a", "a", 1, "a", "1");
		assertTrue(dao.createMember(m));
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
