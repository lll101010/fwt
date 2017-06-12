package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.MemberTourDao;
import free.domain.Member;
import free.domain.MemberTour;
import free.domain.Tour;

@Repository
public class MemberTourDaoLogic implements MemberTourDao {

	private static final String SQL_INSERT_MEMBER_TOUR = "INSERT INTO member_tour_free VALUES(?, ?)";
	private static final String SQL_DELETE_MEMBER_TOUR = "DELETE FROM member_tour_free WHERE memberId=? AND tourId=?";
	private static final String SQL_SELECT_MEMBERTOUR_MEMBERID = "SELECT id, startDate, endDate, contents, maxPerson, language, status, placeId, guideId From tour_free t, member_tour_free mt WHERE t.id=mt.tourId AND mt.memberId=?";
	private static final String SQL_SELECT_MEMBERTOUR_TOURID = "SELECT id, password, name, gender, age, email, phone FROM member_free m, member_tour_free mt WHERE m.id = mt.memberId AND mt.tourId=?";
	private static final String SQL_SELECT_MEMBERTOUR_MEMBERID_TOURID = "SELECT * FROM member_tour_free WHERE memberId=? AND tourId=?";
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public boolean createMemberTour(String memberId, int tourId) {
		return jdbcTemplate.update(SQL_INSERT_MEMBER_TOUR, new Object[]{memberId, tourId}) > 0;
	}

	@Override
	public boolean deleteMemberTour(String memberId, int tourId) {
		return jdbcTemplate.update(SQL_DELETE_MEMBER_TOUR, new Object[]{memberId, tourId}) > 0;
	}

	@Override
	public List<Tour> searchTourByMemberId(String memberId) {
		return jdbcTemplate.query(SQL_SELECT_MEMBERTOUR_MEMBERID, new Object[]{memberId}, MemberTourDaoLogic::mappingTour);
	}

	@Override
	public List<Member> searchMemberByTourId(int tourId) {
		return jdbcTemplate.query(SQL_SELECT_MEMBERTOUR_TOURID, new Object[]{tourId}, MemberTourDaoLogic::mappingMember);
	}

	@Override
	public boolean findMemberTourByAll(String memberId, int tourId) {
		return jdbcTemplate.query(SQL_SELECT_MEMBERTOUR_MEMBERID_TOURID, new Object[]{memberId, tourId}, MemberTourDaoLogic::mappingMemberTour).isEmpty();
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
	public static Tour mappingTour(ResultSet rs, int rowNum) throws SQLException {
		Tour t = new Tour();
		t.setId(rs.getInt("id"));
		t.setStartDate(rs.getString("startDate"));
		t.setEndDate(rs.getString("endDate"));
		t.setContents(rs.getString("contents"));
		t.setMaxPerson(rs.getInt("maxPerson"));
		t.setLanguage(rs.getString("language"));
		t.setStatus(rs.getString("status"));
		t.setPlaceId(rs.getInt("placeId"));
		t.setGuideId(rs.getString("guideId"));
		return t;
	}
	
	public static MemberTour mappingMemberTour(ResultSet rs, int rowNum) throws SQLException {
		MemberTour mt = new MemberTour();
		mt.setMemberId(rs.getString("memberId"));
		mt.setTourId(rs.getInt("tourId"));
		return mt;
	}

}
