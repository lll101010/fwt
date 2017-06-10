package free.domain;

public class Member {
	private String id;
	private String password;
	private String name;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private File file;

	public Member() {
		super();
	}

	public Member(String id, String password, String name, String gender, int age, String email, String phone) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", email=" + email
				+ ", phone=" + phone + ", file=" + file + "]";
	}

}
