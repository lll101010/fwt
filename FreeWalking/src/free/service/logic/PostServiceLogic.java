package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.FileDao;
import free.dao.PostDao;
import free.domain.File;
import free.domain.Post;
import free.service.PostService;

@Service
public class PostServiceLogic implements PostService {
	@Autowired
	private PostDao dao;
	
	@Autowired
	private FileDao fileDao;

	@Override
	public boolean registerPost(Post post, List<File> files) {
		
		boolean flag = false;
		int postId = dao.createPost(post);
		
		if(postId > 0){
			
			System.out.println(postId);
			
			for(File file : files){
			flag = fileDao.createPostFile(file, postId);
			}
		}
		
		return flag;
	}

	@Override
	public boolean modifyPost(Post post) {
		return dao.updatePost(post);
	}

	@Override
	public boolean removePost(int postId) {
		
		List<File> files = findFileByPostId(postId);
		
		for(File file : files){
			fileDao.deletePostFile(file.getId());
		}
		
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

	@Override
	public List<File> findFileByPostId(int postId) {
		return fileDao.searchFileByPostId(postId);
	}

}
