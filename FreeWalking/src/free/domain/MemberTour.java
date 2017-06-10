package free.domain;

public class MemberTour {
	private String memberId;
	private int tourId;

	public MemberTour() {
		super();
	}

	public MemberTour(String memberId, int tourId) {
		super();
		this.memberId = memberId;
		this.tourId = tourId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	
}
