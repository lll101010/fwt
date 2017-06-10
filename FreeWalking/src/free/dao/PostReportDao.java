package free.dao;

import java.util.List;

import free.domain.Post;
import free.domain.PostReport;
import free.domain.PostReportVersion;

public interface PostReportDao {
	
	public boolean createReport(PostReport postReport);
	
	public boolean deleteReport(PostReport postReport);
	
	public PostReport searchReportById(int reportId);
	
	public List<PostReport> searchReportByMemberId(String memberId);
	
	public List<PostReport> searchReportByPostId(int postId);
	
	public PostReport searchReportByPostIdMemberId(int postId, String memberId);
	
	public List<PostReport> searchAllReport();
	
	public List<PostReportVersion> searchPostByCountPostReport();

}
