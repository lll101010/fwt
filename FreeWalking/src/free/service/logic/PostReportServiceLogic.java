package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.PostReportDao;
import free.domain.PostReport;
import free.domain.PostReportVersion;
import free.service.PostReportService;

@Service
public class PostReportServiceLogic implements PostReportService {
	@Autowired
	private PostReportDao dao;

	@Override
	public boolean registerPostReport(PostReport postReport) {
		return dao.createReport(postReport);
	}

	@Override
	public boolean removePostReport(PostReport postReport) {
		return dao.deleteReport(postReport);
	}

	@Override
	public PostReport findPostReport(int postReportId) {
		return dao.searchReportById(postReportId);
	}

	@Override
	public List<PostReport> findPostReportByPostId(int postId) {
		return dao.searchReportByPostId(postId);
	}

	@Override
	public List<PostReport> findAllPostReport() {
		return dao.searchAllReport();
	}

	@Override
	public List<PostReport> findPostReportByMemberId(String memberId) {
		return dao.searchReportByMemberId(memberId);
	}

	@Override
	public PostReport findPostReportByPostIdMemberId(String memberId, int postId) {
		return dao.searchReportByPostIdMemberId(postId, memberId);
	}
	
	@Override
	public List<PostReportVersion> findPostByCountPostReport() {
		return dao.searchPostByCountPostReport();
	}

}
