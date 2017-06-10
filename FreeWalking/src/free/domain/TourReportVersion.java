package free.domain;

import java.sql.Date;

public class TourReportVersion {
	private int id;
	private Date startDate;
	private Date endDate;
	private String contents;
	private int maxPerson;
	private String language;
	private String status;
	private int placeId;
	private String guideId;
	private File file;
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getGuideId() {
		return guideId;
	}

	public void setGuideId(String guideId) {
		this.guideId = guideId;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
