package free.service;

import java.util.List;

import free.domain.Comment;

public interface CommentService {

	public boolean registerPost(Comment comment);
	
	public boolean modifyPost(Comment comment);
	
	public List<Comment> findCommentByPostId(int postId);
}
