package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.PostReportDao;
import free.domain.Post;
import free.domain.PostReport;
import free.domain.PostReportVersion;

@Repository
public class PostReportDaoLogic implements PostReportDao {
	private static final String SQL_INSERT_POSTREPORT = "INSERT INTO post_report_free VALUES(post_report_free_seq.nextVal, ?,?,?)";
	private static final String SQL_DELETE_POSTREPORT = "DELETE FROM post_report_free WHERE id=?";
	private static final String SQL_SELECT_POSTREPORT_ID = "SELECT * FROM post_report_free WHERE id = ?";
	private static final String SQL_SELECT_POSTREPORT_MEMBERID = "SELECT * FROM post_report_free WHERE memberId = ?";
	private static final String SQL_SELECT_POSTREPORT_POSTID = "SELECT * FROM post_report_free WHERE postId = ?";
	private static final String SQL_SELECT_POSTREPORT_POSTIDMEMBERID = "SELECT * FROM post_report_free WHERE postId=? AND memberId=?";
	private static final String SQL_SELECT_ALL_POSTREPORT = "SELECT * FROM post_report_free";
	private static final String SQL_SELECT_POST_BY_COUNT_POSTREPORT_ORDERBY_DESC = "SELECT post.id, post.title, post.contents, post.registdate, post.placeId, post.registerId, count"
																				+ " FROM post_free post, (SELECT id, count(id) count  "
																									  + " FROM (SELECT p.id, p.title, p.contents, p.registDate, p.placeId, p.registerId"
																									  		+ " FROM post_free p, post_report_free pr"
																									  		+ " WHEREe p.id = pr.postId)"
																									  + " GROUP BY id "
																									  + " ORDER BY id desc) dual"
																				+ " WHERE post.id = dual.id";

 
 
      
        
  
  


	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean createReport(PostReport postReport) {
		return jdbcTemplate.update(SQL_INSERT_POSTREPORT, new Object[]{postReport.getContents(), postReport.getPostId(), postReport.getMemberId()}) > 0;
	}

	@Override
	public boolean deleteReport(PostReport postReport) {
		return jdbcTemplate.update(SQL_DELETE_POSTREPORT, new Object[]{postReport.getId()}) > 0;
	}

	@Override
	public PostReport searchReportById(int reportId) {
		return (PostReport) jdbcTemplate.queryForObject(SQL_SELECT_POSTREPORT_ID, new Object[]{reportId}, PostReportDaoLogic::mappingPostReport);
	}

	@Override
	public List<PostReport> searchReportByMemberId(String memberId) {
		return jdbcTemplate.query(SQL_SELECT_POSTREPORT_MEMBERID, new Object[]{memberId}, PostReportDaoLogic::mappingPostReport);
	}

	@Override
	public List<PostReport> searchReportByPostId(int postId) {
		return jdbcTemplate.query(SQL_SELECT_POSTREPORT_POSTID, new Object[]{postId}, PostReportDaoLogic::mappingPostReport);
	}

	@Override
	public PostReport searchReportByPostIdMemberId(int postId, String memberId) {
		return (PostReport)jdbcTemplate.queryForObject(SQL_SELECT_POSTREPORT_POSTIDMEMBERID, new Object[]{postId, memberId}, PostReportDaoLogic::mappingPostReport);
	}

	@Override
	public List<PostReport> searchAllReport() {
		return jdbcTemplate.query(SQL_SELECT_ALL_POSTREPORT, new Object[]{}, PostReportDaoLogic::mappingPostReport);
	}
	
	@Override
	public List<PostReportVersion> searchPostByCountPostReport() {
		return jdbcTemplate.query(SQL_SELECT_POST_BY_COUNT_POSTREPORT_ORDERBY_DESC, new Object[]{}, PostReportDaoLogic::mappingPost);
	}
	
	private static PostReport mappingPostReport(ResultSet rs, int rowNum) throws SQLException {
		PostReport p = new PostReport();
		p.setId(rs.getInt("id"));
		p.setContents(rs.getString("contents"));
		p.setPostId(rs.getInt("postId"));
		p.setMemberId(rs.getString("memberId"));
		return p;
	}
	
	private static PostReportVersion mappingPost(ResultSet rs, int rowNum) throws SQLException {
		PostReportVersion p = new PostReportVersion();
		p.setId(rs.getInt("id"));
		p.setTitle(rs.getString("title"));
		p.setContents(rs.getString("contents"));
		p.setRegistDate(rs.getDate("registDate"));
		p.setPlaceId(rs.getInt("placeId"));
		p.setRegisterId(rs.getString("registerId"));
		p.setReportCount(rs.getInt("count"));
		return p;
	}

}
