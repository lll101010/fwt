package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.FileDao;
import free.domain.File;

@Repository
public class FileDaoLogic implements FileDao {
	private static final String SQL_INSERT_MEMBER_FILE = "INSERT INTO member_file_free VALUES(member_file_seq.nextVal, ?, ?, ? )";
	private static final String SQL_INSERT_TOUR_FILE = "INSERT INTO tour_file_free VALUES(tour_file_seq.nextVal, ?, ?, ? )";
	private static final String SQL_INSERT_POST_FILE = "INSERT INTO post_file_free VALUES(post_file_seq.nextVal, ?, ?, ? )";
	private static final String SQL_UPDATE_MEMBER_FILE = "UPDATE member_file_free SET type=?, name=? WHERE id = ?";
	private static final String SQL_UPDATE_TOUR_FILE = "UPDATE tour_file_free SET type=?, name=? WHERE id = ?";
	private static final String SQL_UPDATE_POST_FILE = "UPDATE post_file_free SET type=?, name=? WHERE id = ?";
	private static final String SQL_DELETE_MEMBER_FILE = "DELETE FROM member_file_free WHERE id = ?";
	private static final String SQL_DELETE_TOUR_FILE = "DELETE FROM tour_file_free WHERE id = ?";
	private static final String SQL_DELETE_POST_FILE = "DELETE FROM post_file_free WHERE id = ?";
	private static final String SQL_SELECT_MEMBER_FILE_ID = "SELECT id, type, name FROM member_file_free WHERE memberId = ?";
	private static final String SQL_SELECT_TOUR_FILE_ID = "SELECT id, type, name FROM tour_file_free WHERE tourId=?";
	private static final String SQL_SELECT_POST_FILE_ID = "SELECT id, type, name FROM post_file_free WHERE postId=?";
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean createMemberFile(File file, String memberId) {
		return jdbcTemplate.update(SQL_INSERT_MEMBER_FILE, new Object[]{ file.getType(), file.getName(), memberId}) > 0 ;
	}

	@Override
	public boolean createTourFile(File file, int tourId) {
		return jdbcTemplate.update(SQL_INSERT_TOUR_FILE, new Object[]{ file.getType(), file.getName(), tourId}) > 0 ;
	}

	@Override
	public boolean createPostFile(File file, int postId) {
		return jdbcTemplate.update(SQL_INSERT_POST_FILE, new Object[]{ file.getType(), file.getName(), postId}) > 0 ;
	}

	@Override
	public boolean updateMemberFile(File file) {
		return jdbcTemplate.update(SQL_UPDATE_MEMBER_FILE, new Object[]{file.getType(), file.getName(), file.getId()}) > 0;
	}

	@Override
	public boolean updateTourFile(File file) {
		return jdbcTemplate.update(SQL_UPDATE_TOUR_FILE, new Object[]{file.getType(), file.getName(), file.getId()}) > 0;
	}

	@Override
	public boolean updatePostFile(File file) {
		return jdbcTemplate.update(SQL_UPDATE_POST_FILE, new Object[]{file.getType(), file.getName(), file.getId()}) > 0;
	}

	@Override
	public boolean deleteMemberFile(int fileId) {
		return jdbcTemplate.update(SQL_DELETE_MEMBER_FILE, new Object[]{fileId}) > 0;
	}

	@Override
	public boolean deleteTourFile(int fileId) {
		return jdbcTemplate.update(SQL_DELETE_TOUR_FILE, new Object[]{fileId}) > 0;
	}

	@Override
	public boolean deletePostFile(int fileId) {
		return jdbcTemplate.update(SQL_DELETE_POST_FILE, new Object[]{fileId}) > 0;
	}

	@Override
	public File searchFileById(int fileId) {
		return (File)jdbcTemplate.queryForObject(SQL_SELECT_MEMBER_FILE_ID, new Object[]{fileId}, FileDaoLogic::mappingMemberFile);
	}

	@Override
	public List<File> searchFileByPostId(int postId) {
		return jdbcTemplate.query(SQL_SELECT_POST_FILE_ID, new Object[]{postId}, FileDaoLogic::mappingPostFile);
	}

	@Override
	public List<File> searchFileByTourId(int tourId) {
		return jdbcTemplate.query(SQL_SELECT_TOUR_FILE_ID, new Object[]{tourId}, FileDaoLogic::mappingTourFile);
	}

	private static File mappingMemberFile(ResultSet rs, int rowNum) throws SQLException {
		File f = new File();
		f.setId(rs.getInt("id"));
		f.setType(rs.getString("type"));
		f.setName(rs.getString("name"));
		return f;
	}

	private static File mappingTourFile(ResultSet rs, int rowNum) throws SQLException {
		File f = new File();
		f.setId(rs.getInt("id"));
		f.setType(rs.getString("type"));
		f.setName(rs.getString("name"));
		return f;
	}

	private static File mappingPostFile(ResultSet rs, int rowNum) throws SQLException {
		File f = new File();
		f.setId(rs.getInt("id"));
		f.setType(rs.getString("type"));
		f.setName(rs.getString("name"));
		return f;
	}

}
