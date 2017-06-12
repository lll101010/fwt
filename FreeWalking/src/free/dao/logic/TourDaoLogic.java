package free.dao.logic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import free.dao.TourDao;
import free.domain.Tour;
import free.domain.TourV2;

@Repository
public class TourDaoLogic implements TourDao {
	
	private static final String SQL_INSERT_TOUR = "INSERT INTO tour_free VALUES(tour_free_seq.nextVal, TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss'), TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss'), ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_TOUR = "UPDATE tour_free SET contents=?, maxperson=?, language=? , title=? WHERE ID=?";
	private static final String SQL_DELETE_TOUR = "DELETE FROM tour_free WHERE id=?";
	private static final String SQL_SELECT_TOUR_MEMBERID = "SELECT id, TO_CHAR(startdate, 'yyyy-MM-dd hh24:mi:ss') startdate, TO_CHAR(enddate, 'yyyy-MM-dd hh24:mi:ss') enddate, contents, maxperson, language, status, placeId, guideId, title  FROM tour_free WHERE guideid=?";
	private static final String SQL_SELECT_TOUR_TOURID = "SELECT id, TO_CHAR(startdate, 'yyyy-MM-dd hh24:mi:ss') startdate, TO_CHAR(enddate, 'yyyy-MM-dd hh24:mi:ss') enddate, contents, maxperson, language, status, placeId, guideId, title  FROM tour_free WHERE id=?";
	private static final String SQL_SELECT_TOUR_DATE_PLACE = "SELECT id, TO_CHAR(startdate, 'yyyy-MM-dd hh24:mi:ss') startdate, TO_CHAR(enddate, 'yyyy-MM-dd hh24:mi:ss') enddate, contents, maxperson, language, status, placeId, guideId, title  FROM tour_free WHERE startDate > ? AND startDate < ? + 1 AND placeId=?";
	private static final String SQL_SELECT_ALL_TOUR = "SELECT id, TO_CHAR(startdate, 'yyyy-MM-dd hh24:mi:ss') startdate, TO_CHAR(enddate, 'yyyy-MM-dd hh24:mi:ss') enddate, contents, maxperson, language, status, placeId, guideId, title  FROM tour_free";
	private static final String SQL_SELECT_TOUR_MEMBERID_DATE = "SELECT id, TO_CHAR(startdate, 'yyyy-MM-dd hh24:mi:ss') startdate, TO_CHAR(enddate, 'yyyy-MM-dd hh24:mi:ss') enddate, contents, maxperson, language, status, placeId, guideId, title  FROM tour_free WHERE startDate > ? AND startDate < ? + 1 AND guideId=?";
	private static final String SQL_SELECT_TOURV2_CONDITION = "SELECT id, TO_CHAR(startdate, 'yyyy-MM-dd hh24:mi:ss') startdate, TO_CHAR(enddate, 'yyyy-MM-dd hh24:mi:ss') enddate, contents, maxperson, language, status, placeId, guideId, title, currentPerson" 
			 + " FROM (SELECT id, startdate, enddate, contents, maxperson, language, status, placeId, guideId, title, nvl(currentperson, 0) currentperson"
			 	   + " FROM tour_free t FULL OUTER JOIN (SELECT tourId, count(*) currentperson"
			 	   									 + " FROM member_tour_free"
			 	   									 + " GROUP BY tourId) dual"
			 	   									 + " ON t.id = dual.tourId)"
			 + " WHERE startDate > TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss')"
			 + " AND startDate < TO_DATE(?, 'yyyy-MM-dd hh24:mi:ss')"
			 + " AND currentPerson + ? <= maxperson"
			 + " AND placeId=?"
			 + " AND startDate > sysdate "
			 + " ORDER BY startDate";
	private static final String SQL_SELECT_GUIDEID_STARTDATE = "SELECT id, TO_CHAR(startdate, 'yyyy-MM-dd hh24:mi:ss') startdate, TO_CHAR(enddate, 'yyyy-MM-dd hh24:mi:ss') enddate, contents, maxperson, language, status, placeId, guideId, title FROM tour_free" 
															+ " WHERE guideId=? AND startdate=TO_DATE(?,'yyyy-MM-dd hh24:mi:ss')";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	@Override
	public int createTour(Tour tour) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(SQL_INSERT_TOUR, new String[] { "id" });
				ps.setString(1, tour.getStartDate());
				ps.setString(2, tour.getEndDate());
				ps.setString(3, tour.getContents());
				ps.setInt(4, tour.getMaxPerson());
				ps.setString(5, tour.getLanguage());
				ps.setString(6, tour.getStatus());
				ps.setInt(7, tour.getPlaceId());
				ps.setString(8, tour.getGuideId());
				ps.setString(9, tour.getTitle());

				return ps;
			}
		}, keyHolder);
		//
		// jdbcTemplate.update(SQL_INSERT_TOUR, new
		// Object[]{tour.getStartDate(), tour.getEndDate(), tour.getContents(),
		// tour.getMaxPerson(),
		// tour.getLanguage(), tour.getStatus(), tour.getPlaceId(),
		// tour.getGuideId(), tour.getTitle()});
		//
		Number n = keyHolder.getKey();

		return n.intValue();
	}

	

	@Override
	public boolean updateTour(Tour tour) {
		return jdbcTemplate.update(SQL_UPDATE_TOUR, new Object[]{tour.getContents(), tour.getMaxPerson(), tour.getLanguage(), tour.getId(), tour.getTitle()}) > 0;
	}

	@Override
	public boolean deleteTour(int tourId) {
		return jdbcTemplate.update(SQL_DELETE_TOUR, new Object[]{tourId}) > 0;
	}

	@Override
	public List<Tour> searchTourByMemberId(String memberId) {
		return jdbcTemplate.query(SQL_SELECT_TOUR_MEMBERID, new Object[]{memberId}, TourDaoLogic::mappingTour);
	}

	@Override
	public Tour searchTourByTour(int tourId) {
		return (Tour)jdbcTemplate.queryForObject(SQL_SELECT_TOUR_TOURID, new Object[]{tourId}, TourDaoLogic::mappingTour);
	}

	@Override
	public List<Tour> searchTourByDatePlace(Date date, int placeId) {
		return jdbcTemplate.query(SQL_SELECT_TOUR_DATE_PLACE, new Object[]{date, date, placeId}, TourDaoLogic::mappingTour);
	}

	@Override
	public List<Tour> searchAllTour() {
		return jdbcTemplate.query(SQL_SELECT_ALL_TOUR, TourDaoLogic::mappingTour);
	}

	@Override
	public List<Tour> searchTourByMemberIdDate(String memberId, Date date) {
		return jdbcTemplate.query(SQL_SELECT_TOUR_MEMBERID_DATE, new Object[]{date, date, memberId}, TourDaoLogic::mappingTour);
	}
	
	@Override
	public List<TourV2> searchTourByCondition(String firstDate, String lastDate, int people, int placeId) {
		return jdbcTemplate.query(SQL_SELECT_TOURV2_CONDITION, new Object[]{firstDate, lastDate, people, placeId}, TourDaoLogic::mappingTourV2);
	}
	
	@Override
	public List<Tour> searchTourByGuideIdStartDate(String guideId, String startDate) {
		return jdbcTemplate.query(SQL_SELECT_GUIDEID_STARTDATE, new Object[]{guideId, startDate}, TourDaoLogic::mappingTour);
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
		t.setTitle(rs.getString("title"));
		return t;
	}
	public static TourV2 mappingTourV2(ResultSet rs, int rowNum) throws SQLException {
		TourV2 t = new TourV2();
		t.setId(rs.getInt("id"));
		t.setStartDate(rs.getString("startDate"));
		t.setEndDate(rs.getString("endDate"));
		t.setContents(rs.getString("contents"));
		t.setMaxPerson(rs.getInt("maxPerson"));
		t.setLanguage(rs.getString("language"));
		t.setStatus(rs.getString("status"));
		t.setPlaceId(rs.getInt("placeId"));
		t.setGuideId(rs.getString("guideId"));
		t.setTitle(rs.getString("title"));
		t.setCurrentPerson(rs.getInt("currentPerson"));
		return t;
	}

}
