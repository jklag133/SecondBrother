package com.gemptc.secondbrotherdemo.moviemode;

public class Movie_today {
	String movieId;
	String movieName;
	String pic_url;
	
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
	public Movie_today(String movieId, String movieName, String pic_url) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.pic_url = pic_url;
	}
	
}
