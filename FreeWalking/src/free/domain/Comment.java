package free.domain;

import java.sql.Date;

public class Comment {
	private int id;
	private Date registDate;
	private String contents;
	private int postId;
	private String memberId;

	public Comment() {
		super();
	}

	public Comment(Date registDate, String contents, int postId, String memberId) {
		super();
		this.registDate = registDate;
		this.contents = contents;
		this.postId = postId;
		this.memberId = memberId;
	}

	public Comment(int id, Date registDate, String contents, int postId, String memberId) {
		super();
		this.id = id;
		this.registDate = registDate;
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

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
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
		return "Comment [id=" + id + ", registDate=" + registDate + ", contents=" + contents + ", postId=" + postId
				+ ", memberId=" + memberId + "]";
	}

}
