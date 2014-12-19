package com.gemptc.secondbrotherdemo.cinemamode;

import java.util.List;

public class Cinema {
	String reason;
	List<Cinema_local> result;
	String error_code;
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public List<Cinema_local> getResult() {
		return result;
	}
	public void setResult(List<Cinema_local> result) {
		this.result = result;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	public Cinema(String reason, List<Cinema_local> result, String error_code) {
		super();
		this.reason = reason;
		this.result = result;
		this.error_code = error_code;
	}
	public Cinema() {
		super();
	}
	
}
