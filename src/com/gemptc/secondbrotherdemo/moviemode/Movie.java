package com.gemptc.secondbrotherdemo.moviemode;

import java.util.List;

public class Movie {
	String reason;
//	Movie_today movie;
	List<Movie_today> result;
	String error_code;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<Movie_today> getListmovietoday() {
		return result;
	}
	public void setListmovietoday(List<Movie_today> listmovietoday) {
		this.result = listmovietoday;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public Movie(String reason, List<Movie_today> listmovietoday,
			String error_code) {
		super();
		this.reason = reason;
		this.result = listmovietoday;
		this.error_code = error_code;
	}
	public Movie() {
		super();
	}
	
	
}
