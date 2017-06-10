package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.PostDao;
import free.domain.Post;

@Repository
public class PostDaoLogic implements PostDao {
	private static final String SQL_INSERT_POST = "INSERT INTO post_free VALUES(post_free_seq.nextVal, ?, ?, ?, ?, ?)";
	private static final String SQL_UPDATE_POST = "UPDATE post_free SET title=?, contents=?, placeId=? WHERE id=?";
	private static final String SQL_DELETE_POST = "DELETE FROM post_free WHERE id=?";
	private static final String SQL_SELECT_POST_TITLE = "SELECT * FROM post_free WHERE LIKE %?%";
	private static final String SQL_SELECT_POST_ID = "SELECT * FROM post_free WHERE id=?";
	private static final String SQL_SELECT_POST_MEMBERID = "SELECT * FROM post_free WHERE registerId=?";
	private static final String SQL_SELECT_POST_PLACEID = "SELECT * FROM post_free WHERE placeId=?";

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean createPost(Post post) {
		return jdbcTemplate.update(SQL_INSERT_POST, new Object[] { post.getTitle(), post.getContents(),
				post.getRegistDate(), post.getPlaceId(), post.getRegisterId() }) > 0;
	}

	@Override
	public boolean updatePost(Post post) {
		return jdbcTemplate.update(SQL_UPDATE_POST,
				new Object[] { post.getTitle(), post.getContents(), post.getPlaceId(), post.getId() }) > 0;
	}

	@Override
	public boolean deletePost(int postId) {
		return jdbcTemplate.update(SQL_DELETE_POST, new Object[] { postId }) > 0;
	}

	@Override
	public List<Post> searchPostByTitle(String title) {
		return jdbcTemplate.query(SQL_SELECT_POST_TITLE, new Object[]{title}, PostDaoLogic::mappingPost);
	}

	@Override
	public Post searchPostByPostId(int postId) {
		return (Post) jdbcTemplate.queryForObject(SQL_SELECT_POST_ID, new Object[]{postId}, PostDaoLogic::mappingPost);
	}

	@Override
	public List<Post> searchPostByMemberId(String memberId) {
		return jdbcTemplate.query(SQL_SELECT_POST_MEMBERID, new Object[]{memberId}, PostDaoLogic::mappingPost);
	}

	@Override
	public List<Post> searchPostByPlaceId(int placeId) {
		return jdbcTemplate.query(SQL_SELECT_POST_PLACEID, new Object[]{placeId}, PostDaoLogic::mappingPost);
		
	}

	private static Post mappingPost(ResultSet rs, int rowNum) throws SQLException {
		Post p = new Post();
		p.setId(rs.getInt("id"));
		p.setTitle(rs.getString("title"));
		p.setContents(rs.getString("contents"));
		p.setRegistDate(rs.getDate("registDate"));
		p.setPlaceId(rs.getInt("placeId"));
		p.setRegisterId(rs.getString("registerId"));
		return p;
	}
}
