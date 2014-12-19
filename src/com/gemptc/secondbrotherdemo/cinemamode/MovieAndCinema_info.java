package com.gemptc.secondbrotherdemo.cinemamode;

import java.util.List;

public class MovieAndCinema_info{
	Cinema_info cinema_info;
	List<Movie_info> lists;
	public Cinema_info getCinema_info() {
		return cinema_info;
	}
	public void setCinema_info(Cinema_info cinema_info) {
		this.cinema_info = cinema_info;
	}
	public List<Movie_info> getLists() {
		return lists;
	}
	public void setLists(List<Movie_info> lists) {
		this.lists = lists;
	}
	public MovieAndCinema_info(Cinema_info cinema_info, List<Movie_info> lists) {
		super();
		this.cinema_info = cinema_info;
		this.lists = lists;
	}
	public MovieAndCinema_info() {
		super();
	}
	
	

}
