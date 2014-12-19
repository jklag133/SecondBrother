package com.gemptc.secondbrotherdemo.cinemamode;

public class Cinema_local {
	String  id;   
	String cityName;
	String cinemaName;
	String address;
	String telephone;
	double latitude;
	double longitude;
	String trafficRoutes;
	String distance; 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getTrafficRoutes() {
		return trafficRoutes;
	}
	public void setTrafficRoutes(String trafficRoutes) {
		this.trafficRoutes = trafficRoutes;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public Cinema_local(String id, String cityName, String cinemaName,
			String address, String telephone, double latitude,
			double longitude, String trafficRoutes, String distance) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.cinemaName = cinemaName;
		this.address = address;
		this.telephone = telephone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.trafficRoutes = trafficRoutes;
		this.distance = distance;
	}
	public Cinema_local() {
		super();
	}
	
	
}
