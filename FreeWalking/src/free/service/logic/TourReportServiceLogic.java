package free.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import free.dao.TourDao;
import free.dao.TourReportDao;
import free.domain.TourReport;
import free.domain.TourReportVersion;
import free.service.TourReportService;

@Service
public class TourReportServiceLogic implements TourReportService{
	@Autowired
	private TourReportDao dao;

	@Override
	public boolean registerTourReport(TourReport tourReport) {
		return dao.createReport(tourReport);
	}

	@Override
	public boolean removeTourReport(TourReport tourReport) {
		return dao.deleteReport(tourReport.getId());
	}

	@Override
	public TourReport findTourReportById(int tourReportId) {
		return dao.searchReportById(tourReportId);
	}

	@Override
	public List<TourReport> findTourReportByTourId(int tourId) {
		return dao.searchReportByTourId(tourId);
	}

	@Override
	public List<TourReport> findAllTourReport() {
		return dao.searchAllReport();
	}

	@Override
	public List<TourReport> findTourReportByMemberId(String memberId) {
		return dao.searchReportByMemberId(memberId);
	}

	@Override
	public TourReport findTourReportByTourIdMemberId(String memberId, int tourId) {
		return dao.searchReportByTourIdMemberId(tourId, memberId);
	}
	
	@Override
	public List<TourReportVersion> findPostByCountTourReport() {
		return dao.searchPostByCountTourReport();
	}

}
