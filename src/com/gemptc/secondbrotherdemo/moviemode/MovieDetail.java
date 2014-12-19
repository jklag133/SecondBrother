package com.gemptc.secondbrotherdemo.moviemode;

import java.util.List;


public class MovieDetail {
	
	String resultcode;
	String reason;
	List<Movie_detail> result;
	String error_code;
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<Movie_detail> getResult() {
		return result;
	}
	public void setResult(List<Movie_detail> result) {
		this.result = result;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public String getResultcode() {
		return resultcode;
	}
	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}
	public MovieDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieDetail(String resultcode, String reason, List<Movie_detail> result,
			String error_code) {
		super();
		this.resultcode = resultcode;
		this.reason = reason;
		this.result = result;
		this.error_code = error_code;
	}
	
}
