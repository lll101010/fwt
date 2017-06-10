package free.domain;

import java.sql.Date;

public class Tour {
	private int id;
	private String startDate;
	private String endDate;
	private String contents;
	private int maxPerson;
	private String language;
	private String status;
	private int placeId;
	private String guideId;
	private File file;
	private String title;
	
	public Tour() {
		super();
	}

	public Tour(String startDate, String endDate, String contents, int maxPerson, String language, String status,
			int placeId, String guideId, File file, String title) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.contents = contents;
		this.maxPerson = maxPerson;
		this.language = language;
		this.status = status;
		this.placeId = placeId;
		this.guideId = guideId;
		this.file = file;
		this.title = title;
	}

	public Tour(int id, String startDate, String endDate, String contents, int maxPerson, String language, String status,
			int placeId, String guideId, File file, String title) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.contents = contents;
		this.maxPerson = maxPerson;
		this.language = language;
		this.status = status;
		this.placeId = placeId;
		this.guideId = guideId;
		this.file = file;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Tour [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", contents=" + contents
				+ ", maxPerson=" + maxPerson + ", language=" + language + ", status=" + status + ", placeId=" + placeId
				+ ", guideId=" + guideId + ", file=" + file + ", title=" + title + "]";
	}

	

}
