package free.domain;

public class PostReport {
	private int id;
	private String contents;
	private int postId;
	private String memberId;

	public PostReport() {
		super();
	}

	public PostReport(String contents, int postId, String memberId) {
		super();
		this.contents = contents;
		this.postId = postId;
		this.memberId = memberId;
	}

	public PostReport(int id, String contents, int postId, String memberId) {
		super();
		this.id = id;
		this.contents = contents;
		this.postId = postId;
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

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "PostReport [id=" + id + ", contents=" + contents + ", postId=" + postId + ", memberId=" + memberId
				+ "]";
	}

}
