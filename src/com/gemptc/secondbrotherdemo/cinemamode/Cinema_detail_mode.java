package com.gemptc.secondbrotherdemo.cinemamode;

public class Cinema_detail_mode {

	String reason;
	MovieAndCinema_info result;
	int error_code;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public MovieAndCinema_info getResult() {
		return result;
	}

	public void setResult(MovieAndCinema_info result) {
		this.result = result;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public Cinema_detail_mode(String reason, MovieAndCinema_info result,
			int error_code) {
		super();
		this.reason = reason;
		this.result = result;
		this.error_code = error_code;
	}

	public Cinema_detail_mode() {
		super();
	}

}



