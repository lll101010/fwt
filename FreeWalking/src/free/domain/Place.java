package free.domain;

import java.util.List;

public class Place {
	private int id;
	private String name;
	private String latitude;
	private String longitude;
	private String country;
	private String address;
	private String contents;
	private String city;
	private String nameKor;
	private int todayGuide;
	private int totalGuide;

	public Place() {
		super();
	}

	public Place(String name, String latitude, String longitude, String country, String address, String contents, String city, String nameKor) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.address = address;
		this.contents = contents;
		this.city = city;
		this.nameKor = nameKor;
	}

	public Place(int id, String name, String latitude, String longitude, String country, String address, String contents, String city, String nameKor) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.address = address;
		this.contents = contents;
		this.city = city;
		this.nameKor = nameKor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNameKor() {
		return nameKor;
	}

	public void setNameKor(String nameKor) {
		this.nameKor = nameKor;
	}
	
	

	public int getTodayGuide() {
		return todayGuide;
	}

	public void setTodayGuide(int todayGuide) {
		this.todayGuide = todayGuide;
	}
	

	public int getTotalGuide() {
		return totalGuide;
	}

	public void setTotalGuide(int totalGuide) {
		this.totalGuide = totalGuide;
	}

	@Override
	public String toString() {
		return "Place [id=" + id + ", name=" + name + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", country=" + country + ", address=" + address + ", contents=" + contents + "]";
	}

	
}
