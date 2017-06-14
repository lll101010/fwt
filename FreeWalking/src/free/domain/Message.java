package free.domain;

import java.sql.Date;

public class Message {
	private int id;
	private String contents;
	private String registDate;
	private String fromMemberId;
	private String toMemberId;

	public Message() {
		super();
	}

	public Message(String contents, String registDate, String fromMemberId, String toMemberId) {
		super();
		this.contents = contents;
		this.registDate = registDate;
		this.fromMemberId = fromMemberId;
		this.toMemberId = toMemberId;
	}

	public Message(int id, String contents, String registDate, String fromMemberId, String toMemberId) {
		super();
		this.id = id;
		this.contents = contents;
		this.registDate = registDate;
		this.fromMemberId = fromMemberId;
		this.toMemberId = toMemberId;
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

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getFromMemberId() {
		return fromMemberId;
	}

	public void setFromMemberId(String fromMemberId) {
		this.fromMemberId = fromMemberId;
	}

	public String getToMemberId() {
		return toMemberId;
	}

	public void setToMemberId(String toMemberId) {
		this.toMemberId = toMemberId;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", contents=" + contents + ", registDate=" + registDate + ", fromMemberId="
				+ fromMemberId + ", toMemberId=" + toMemberId + "]";
	}

}
