package free.domain;

public class TourReport {
	private int id;
	private String contents;
	private int tourId;
	private String memberId;

	public TourReport() {
		super();
	}

	public TourReport(String contents, int tourId, String memberId) {
		super();
		this.contents = contents;
		this.tourId = tourId;
		this.memberId = memberId;
	}

	public TourReport(int id, String contents, int tourId, String memberId) {
		super();
		this.id = id;
		this.contents = contents;
		this.tourId = tourId;
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "TourReport [id=" + id + ", contents=" + contents + ", tourId=" + tourId + ", memberId=" + memberId
				+ "]";
	}

}
