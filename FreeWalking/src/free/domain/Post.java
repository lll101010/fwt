package free.domain;

import java.sql.Date;
import java.util.List;

public class Post {
	private int id;
	private String title;
	private String contents;
	private Date registDate;
	private List<File> files;
	private int placeId;
	private String registerId;

	public Post() {
		super();
	}

	public Post(String title, String contents, Date registDate, List<File> files, int placeId, String registerId) {
		super();
		this.title = title;
		this.contents = contents;
		this.registDate = registDate;
		this.files = files;
		this.placeId = placeId;
		this.registerId = registerId;
	}

	public Post(int id, String title, String contents, Date registDate, List<File> files, int placeId,
			String registerId) {
		super();
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.registDate = registDate;
		this.files = files;
		this.placeId = placeId;
		this.registerId = registerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", contents=" + contents + ", registDate=" + registDate
				+ ", files=" + files + ", placeId=" + placeId + ", registerId=" + registerId + "]";
	}

}
