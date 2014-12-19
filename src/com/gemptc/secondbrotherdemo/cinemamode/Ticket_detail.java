package com.gemptc.secondbrotherdemo.cinemamode;



public class Ticket_detail{
	String hall;//������
	String price;//�۸�
	String ticket_url;
	String time;
	public String getHall() {
		return hall;
	}
	public void setHall(String hall) {
		this.hall = hall;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTicket_url() {
		return ticket_url;
	}
	public void setTicket_url(String ticket_url) {
		this.ticket_url = ticket_url;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Ticket_detail(String hall, String price, String ticket_url,
			String time) {
		super();
		this.hall = hall;
		this.price = price;
		this.ticket_url = ticket_url;
		this.time = time;
	}
	public Ticket_detail() {
		super();
	}
	
}