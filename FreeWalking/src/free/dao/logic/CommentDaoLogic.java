package free.dao.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import free.dao.CommentDao;
import free.domain.Comment;

@Repository
public class CommentDaoLogic implements CommentDao {
	private static final String SQL_INSERT_COMMENT = "INSERT INTO comment_free VALUES(post_free_seq.nextVal, ?,?,?,?)";
	private static final String SQL_UPDATE_COMMENT = "UPDATE comment_free SET registDate=?, contents=?";
	private static final String SQL_DELETE_COMMENT = "DELETE FROM comment_free WHERE id=?";
	private static final String SQL_SELECT_COMMENT_POSTID = "SELECT * FROM comment_free WHERE postId=?";

	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public boolean createComment(Comment comment) {
		return jdbcTemplate.update(SQL_INSERT_COMMENT, new Object[] { comment.getRegistDate(), comment.getContents(),
				comment.getPostId(), comment.getMemberId() }) > 0;
	}

	@Override
	public boolean updateComment(Comment comment) {
		return jdbcTemplate.update(SQL_UPDATE_COMMENT,
				new Object[] { comment.getRegistDate(), comment.getContents() }) > 0;
	}

	@Override
	public boolean deleteComment(int commentId) {
		return jdbcTemplate.update(SQL_DELETE_COMMENT, new Object[] { commentId }) > 0;
	}

	@Override
	public List<Comment> searchCommentByPostId(int postId) {
		return jdbcTemplate.query(SQL_SELECT_COMMENT_POSTID, new Object[] {postId}, CommentDaoLogic::mappingComment);
	}

	private static Comment mappingComment(ResultSet rs, int rowNum) throws SQLException {
		Comment c = new Comment();
		c.setId(rs.getInt("id"));
		c.setRegistDate(rs.getDate("registDate"));
		c.setContents(rs.getString("contents"));
		c.setPostId(rs.getInt("postId"));
		c.setMemberId(rs.getString("memberId"));
		return c;
	}
}
