package free.service;

import java.util.List;

import free.domain.PostReport;
import free.domain.PostReportVersion;

public interface PostReportService {
	
	public boolean registerPostReport(PostReport postReport);
	
	public boolean removePostReport(PostReport postReport);
	
	public PostReport findPostReport(int postReportId);
	
	public List<PostReport> findPostReportByPostId(int postId);
	
	public List<PostReport> findAllPostReport();
	
	public List<PostReport> findPostReportByMemberId(String memberId);
	
	public PostReport findPostReportByPostIdMemberId(String memberId, int postId);
	
	public List<PostReportVersion> findPostByCountPostReport();
}
