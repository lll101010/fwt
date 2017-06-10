package free.service;

import java.util.List;

import free.domain.TourReport;
import free.domain.TourReportVersion;

public interface TourReportService {

	public boolean registerTourReport(TourReport tourReport);
	
	public boolean removeTourReport(TourReport tourReport);
	
	public TourReport findTourReportById(int tourReportId);
	
	public List<TourReport> findTourReportByTourId(int tourId);
	
	public List<TourReport> findAllTourReport();
	
	public List<TourReport> findTourReportByMemberId(String memberId);
	
	public TourReport findTourReportByTourIdMemberId(String memberId, int tourId);
	
	public List<TourReportVersion> findPostByCountTourReport();
	
}
