package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.PostDao;
import free.domain.Post;
import free.service.PostService;

@Service
public class PostServiceLogic implements PostService {
	@Autowired
	private PostDao dao;

	@Override
	public boolean registerPost(Post post) {
		return dao.createPost(post);
	}

	@Override
	public boolean modifyPost(Post post) {
		return dao.updatePost(post);
	}

	@Override
	public boolean removePost(int postId) {
		return dao.deletePost(postId);
	}

	@Override
	public List<Post> findPostByPlaceId(int placeId) {
		return dao.searchPostByPlaceId(placeId);
	}

	@Override
	public List<Post> findPostByMemberId(String memberId) {
		return dao.searchPostByMemberId(memberId);
	}

	@Override
	public List<Post> findPostByTitle(String title) {
		return dao.searchPostByTitle(title);
	}


	@Override
	public Post findPostByPostId(int postId) {
		return dao.searchPostByPostId(postId);
	}

}
