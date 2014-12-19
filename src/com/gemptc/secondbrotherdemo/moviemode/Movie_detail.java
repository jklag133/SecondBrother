package com.gemptc.secondbrotherdemo.moviemode;

public class Movie_detail {
	String title;
	String poster;
	String runtime;
	String rating;
	String release_date;
	String genres;
	String film_locations;
	String plot_simple;
	String directors;
	String actors;
	String rating_count;
	String type;
	String also_known_as;
	String country;
	String year;
	String language;
	String writer;
	String movieid;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getFilm_locations() {
		return film_locations;
	}

	public void setFilm_locations(String film_locations) {
		this.film_locations = film_locations;
	}

	public String getPlot_simple() {
		return plot_simple;
	}

	public void setPlot_simple(String plot_simple) {
		this.plot_simple = plot_simple;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getRating_count() {
		return rating_count;
	}

	public void setRating_count(String rating_count) {
		this.rating_count = rating_count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAlso_known_as() {
		return also_known_as;
	}

	public void setAlso_known_as(String also_known_as) {
		this.also_known_as = also_known_as;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMovieid() {
		return movieid;
	}

	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}

	public Movie_detail(String title, String poster, String runtime,
			String rating, String release_date, String genres,
			String film_locations, String plot_simple, String directors,
			String actors, String rating_count, String type,
			String also_known_as, String country, String year, String language,
			String writer, String movieid) {
		super();
		this.title = title;
		this.poster = poster;
		this.runtime = runtime;
		this.rating = rating;
		this.release_date = release_date;
		this.genres = genres;
		this.film_locations = film_locations;
		this.plot_simple = plot_simple;
		this.directors = directors;
		this.actors = actors;
		this.rating_count = rating_count;
		this.type = type;
		this.also_known_as = also_known_as;
		this.country = country;
		this.year = year;
		this.language = language;
		this.writer = writer;
		this.movieid = movieid;
	}

	public Movie_detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
