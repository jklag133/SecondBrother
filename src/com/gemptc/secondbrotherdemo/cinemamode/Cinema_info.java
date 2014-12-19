package com.gemptc.secondbrotherdemo.cinemamode;

public class Cinema_info{
	String id;
	String name;
	String city;
	String telephone;
	String address;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Cinema_info(String id, String name, String city, String telephone,
			String address) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.telephone = telephone;
		this.address = address;
	}
	public Cinema_info() {
		super();
	}
	
}