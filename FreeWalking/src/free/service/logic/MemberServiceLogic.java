package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.MemberDao;
import free.domain.Member;
import free.service.MemberService;

@Service
public class MemberServiceLogic implements MemberService{
	@Autowired
	private MemberDao dao;

	@Override
	public boolean registerMember(Member member) {
		return dao.createMember(member);
	}

	@Override
	public boolean modifyMember(Member member) {
		return dao.updateMember(member);
	}

	@Override
	public boolean removeMember(String memberId) {
		return dao.deleteMember(memberId);
	}

	@Override
	public List<Member> findAllMember() {
		return dao.searchAllMember();
	}

	@Override
	public Member findMemberByMemberId(String memberId) {
		
		return dao.searchMemberById(memberId);
	}

	@Override
	public String findIdByNamePhone(String name, String phone) {
		return dao.searchByNamePhone(name, phone);
	}

}
