package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.CommentDao;
import free.domain.Comment;
import free.service.CommentService;

@Service
public class CommentServiceLogic implements CommentService{
	@Autowired
	private CommentDao dao;

	@Override
	public boolean registerPost(Comment comment) {
		return dao.createComment(comment);
	}

	@Override
	public boolean modifyPost(Comment comment) {
		return dao.updateComment(comment);
	}

	@Override
	public List<Comment> findCommentByPostId(int postId) {
		return dao.searchCommentByPostId(postId);
	}

}
