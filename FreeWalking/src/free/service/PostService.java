package free.service;

import java.util.List;

import free.domain.Post;

public interface PostService {
	
	public boolean registerPost(Post post);
	
	public boolean modifyPost(Post post);
	
	public boolean removePost(int postId);
	
	public List<Post> findPostByPlaceId(int placeId);
	
	public List<Post> findPostByMemberId(String memberId);
	
	public List<Post> findPostByTitle(String title);
	
	public Post findPostByPostId(int postId);
}
