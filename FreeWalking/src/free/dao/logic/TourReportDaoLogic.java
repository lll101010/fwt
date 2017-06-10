package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.TourReportDao;
import free.domain.PostReport;
import free.domain.Tour;
import free.domain.TourReport;
import free.domain.TourReportVersion;

@Repository
public class TourReportDaoLogic implements TourReportDao {

	private static final String SQL_INSERT_TOURREPORT = "INSERT INTO tour_report_free VALUES(tour_report_free_seq.nextVal, ?,?,?)";
	private static final String SQL_DELETE_TOURREPORT = "DELETE FROM tour_report_free WHERE id = ?";
	private static final String SQL_SELECT_TOURREPORT_ID = "SELECT * FROM tour_report_free WHERE id=?";
	private static final String SQL_SELECT_TOURREPORT_MEMBERID = "SELECT * FROM tour_report_free WHERE memberId=?";
	private static final String SQL_SELECT_TOURREPORT_TOURID = "SELECT * FROM tour_report_free WHERE tourId=?";
	private static final String SQL_SELECT_TOURREPORT_TOURID_MEMBERID = "SELECT * FROM tour_report_free WHERE tourId=? AND memberId=?";
	private static final String SQL_SELECT_ALL_TOURREPORT = "SELECT * FROM tour_report_free";
	private static final String SQL_SELECT_TOUR_COUNT_TOURREPORT = "SELECT tour.id, tour.startDate, tour.endDate, tour.contents, tour.maxPerson, tour.language, tour.status, tour.placeId, tour.guideId, count"
																+ " FROM tour_free tour,"
																	+ " (SELECT id, count(id) count"
																	 + " FROM (SELECT t.id"
																	 	   + " FROM tour_free t, tour_report_free tr"
																	 	   + " WHERE t.id = tr.tourId)"
																	 + " GROUP BY id"
																	 + " ORDER BY id desc) dual"
																+ " WHERE tour.id = dual.id";
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean createReport(TourReport report) {
		return jdbcTemplate.update(SQL_INSERT_TOURREPORT, new Object[]{report.getContents(), report.getTourId(), report.getMemberId()}) > 0;
	}

	@Override
	public boolean deleteReport(int tourReportId) {
		return jdbcTemplate.update(SQL_DELETE_TOURREPORT, new Object[]{tourReportId}) > 0;
	}

	@Override
	public TourReport searchReportById(int reportId) {
		return (TourReport)jdbcTemplate.queryForObject(SQL_SELECT_TOURREPORT_ID, new Object[]{reportId}, TourReportDaoLogic::mappingTourReport);
	}

	@Override
	public List<TourReport> searchReportByMemberId(String memberId) {
		return jdbcTemplate.query(SQL_SELECT_TOURREPORT_MEMBERID, new Object[]{memberId}, TourReportDaoLogic::mappingTourReport);
	}

	@Override
	public List<TourReport> searchReportByTourId(int tourId) {
		return jdbcTemplate.query(SQL_SELECT_TOURREPORT_TOURID, new Object[]{tourId}, TourReportDaoLogic::mappingTourReport);
	}

	@Override
	public TourReport searchReportByTourIdMemberId(int tourId, String memberId) {
		return (TourReport) jdbcTemplate.queryForObject(SQL_SELECT_TOURREPORT_TOURID_MEMBERID, new Object[]{tourId, memberId}, TourReportDaoLogic::mappingTourReport);
	}

	@Override
	public List<TourReport> searchAllReport() {
		return jdbcTemplate.query(SQL_SELECT_ALL_TOURREPORT, new Object[]{}, TourReportDaoLogic::mappingTourReport);
	}
	
	@Override
	public List<TourReportVersion> searchPostByCountTourReport() {
		return jdbcTemplate.query(SQL_SELECT_TOUR_COUNT_TOURREPORT, new Object[]{}, TourReportDaoLogic::mappingTourReportVersion);
	}
	
	public static TourReport mappingTourReport(ResultSet rs, int rowNum) throws SQLException {
		TourReport t = new TourReport();
		t.setId(rs.getInt("id"));
		t.setContents(rs.getString("contents"));
		t.setTourId(rs.getInt("tourId"));
		t.setMemberId(rs.getString("memberId"));
		return t;
	}
	
	public static TourReportVersion mappingTourReportVersion(ResultSet rs, int rowNum) throws SQLException {
		TourReportVersion t = new TourReportVersion();
		t.setId(rs.getInt("id"));
		t.setStartDate(rs.getDate("startDate"));
		t.setEndDate(rs.getDate("endDate"));
		t.setContents(rs.getString("contents"));
		t.setMaxPerson(rs.getInt("maxPerson"));
		t.setLanguage(rs.getString("language"));
		t.setStatus(rs.getString("status"));
		t.setPlaceId(rs.getInt("placeId"));
		t.setGuideId(rs.getString("guideId"));
		t.setCount(rs.getInt("count"));
		return t;
	}

}
