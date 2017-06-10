package free.dao;

import java.util.List;

import free.domain.TourReport;
import free.domain.TourReportVersion;

public interface TourReportDao {

	public boolean createReport(TourReport report);
	
	public boolean deleteReport(int tourReportId);
	
	public TourReport searchReportById(int reportId);
	
	public List<TourReport> searchReportByMemberId(String memberId);
	
	public List<TourReport> searchReportByTourId(int tourId);
	
	public TourReport searchReportByTourIdMemberId(int tourId, String memberId);
	
	public List<TourReport> searchAllReport();
	
	public List<TourReportVersion> searchPostByCountTourReport();
}
