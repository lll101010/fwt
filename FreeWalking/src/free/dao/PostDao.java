package free.dao;

import java.util.List;

import free.domain.Post;

public interface PostDao {

	public boolean createPost(Post post);
	
	public boolean updatePost(Post post);
	
	public boolean deletePost(int postId);
	
	public List<Post> searchPostByTitle(String title);
	
	public Post searchPostByPostId(int postId);
	
	public List<Post> searchPostByMemberId(String memberId);
	
	public List<Post> searchPostByPlaceId(int placeId);
}
