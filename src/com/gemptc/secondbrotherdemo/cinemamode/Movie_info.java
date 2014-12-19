package com.gemptc.secondbrotherdemo.cinemamode;

import java.util.List;

public class Movie_info {
	String movieId;
	String movieName;
	String pic_url;
	List<Ticket_detail> broadcast;

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public List<Ticket_detail> getBroadcast() {
		return broadcast;
	}

	public void setBroadcast(List<Ticket_detail> broadcast) {
		this.broadcast = broadcast;
	}

	public Movie_info(String movieId, String movieName, String pic_url,
			List<Ticket_detail> broadcast) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.pic_url = pic_url;
		this.broadcast = broadcast;
	}

	public Movie_info() {
		super();
	}

}