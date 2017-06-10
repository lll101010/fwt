package free.service;

import java.util.List;

import free.domain.Member;

public interface MemberService {

	public boolean registerMember(Member member);
	
	public boolean modifyMember(Member member);
	
	public boolean removeMember(String memberId);
	
	public List<Member> findAllMember();
	
	public Member findMemberByMemberId(String memberId);
	
	public String findIdByNamePhone(String name, String phone);
}
