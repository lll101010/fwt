package free.dao;

import java.util.List;

import free.domain.Member;

public interface MemberDao {
	
	public boolean createMember(Member member);
	
	public boolean updateMember(Member member);
	
	public boolean deleteMember(String memberId);
	
	public Member searchMemberById(String memberId);
	
	public List<Member> searchAllMember();
	
	public String searchByNamePhone(String name, String phone);
}
