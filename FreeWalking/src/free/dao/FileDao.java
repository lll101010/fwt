package free.dao;

import java.util.List;

import free.domain.File;

public interface FileDao {
	
	public boolean createMemberFile(File file, String memberId);
	
	public boolean createTourFile(File file, int tourId);
	
	public boolean createPostFile(File file, int postId);
	
	public boolean updateMemberFile(File file);
	
	public boolean updateTourFile(File file);
	
	public boolean updatePostFile(File file);
	
	public boolean deleteMemberFile(int fileId);
	
	public boolean deleteTourFile(int fileId);
	
	public boolean deletePostFile(int fileId);
	
	public File searchFileById(int fileId);
	
	public List<File> searchFileByPostId(int postId);
	
	public List<File> searchFileByTourId(int tourId);
	

}
