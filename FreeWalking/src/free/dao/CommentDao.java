package free.dao;

import java.util.List;

import free.domain.Comment;

public interface CommentDao {
	
	public boolean createComment(Comment comment);
	
	public boolean updateComment(Comment comment);
	
	public boolean deleteComment(int commentId);
	
	public List<Comment> searchCommentByPostId(int postId);

}
