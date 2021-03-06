package free.domain;

public class File {
	private int id;
	private String type;
	private String name;

	public File() {
		super();
	}

	public File(String type, String name) {
		super();
		this.type = type;
		this.name = name;
	}

	public File(int id, String type, String name) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", type=" + type + ", name=" + name + "]";
	}

}
