package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.MemberDao;
import free.domain.Member;

@Repository
public class MemberDaoLogic implements MemberDao {

	public static final String SQL_INSERT_MEMBER = "INSERT INTO member_free (id, password, name, gender, age, email, phone) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_MEMBER = "UPDATE member_free SET password=?, email=?, phone=? WHERE id=?";
	private static final String SQL_DELETE_MEMBER = "DELETE FROM member_free WHERE id=?";
	private static final String SQL_SEARCH_MEMBER_ID = "SELECT id, password, name, gender, age, email, phone FROM member_free WHERE id=?";
	private static final String SQL_SEARCH_ALL_MEMBER = "SELECT id, password, name, gender, age, email, phone FROM member_free";
	private static final String SQL_SEARCH_MEMBER_NAME_PHONE = "SELECT id, password, name, gender, age, email, phone FROM member_free WHERE phone=? AND name=?";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean createMember(Member member) {
		return jdbcTemplate.update(SQL_INSERT_MEMBER, new Object[] { member.getId(), member.getPassword(),
				member.getName(), member.getGender(), member.getAge(), member.getEmail(), member.getPhone() }) > 0;
	}

	@Override
	public boolean updateMember(Member member) {
		return jdbcTemplate.update(SQL_UPDATE_MEMBER,
				new Object[] { member.getPassword(), member.getEmail(), member.getPhone(), member.getId() }) > 0;
	}

	@Override
	public boolean deleteMember(String memberId) {
		return jdbcTemplate.update(SQL_DELETE_MEMBER, new Object[] { memberId }) > 0;
	}

	@Override
	public Member searchMemberById(String memberId) {
		return jdbcTemplate.queryForObject(SQL_SEARCH_MEMBER_ID, new Object[] { memberId },
				MemberDaoLogic::mappingMember);
	}

	@Override
	public List<Member> searchAllMember() {
		return jdbcTemplate.query(SQL_SEARCH_ALL_MEMBER, new Object[] {}, MemberDaoLogic::mappingMember);
	}

	@Override
	public String searchByNamePhone(String name, String phone) {
		Member member = (Member) jdbcTemplate.query(SQL_SEARCH_MEMBER_NAME_PHONE, new Object[] { phone, name },
				MemberDaoLogic::mappingMember);
		return member.getId();
	}

	private static Member mappingMember(ResultSet rs, int rowNum) throws SQLException {
		Member m = new Member();
		m.setId(rs.getString("id"));
		m.setPassword(rs.getString("password"));
		m.setName(rs.getString("name"));
		m.setGender(rs.getString("gender"));
		m.setAge(rs.getInt("age"));
		m.setEmail(rs.getString("email"));
		m.setPhone(rs.getString("phone"));
		return m;
	}

}
