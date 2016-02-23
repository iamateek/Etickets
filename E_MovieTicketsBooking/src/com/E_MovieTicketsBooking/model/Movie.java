package com.E_MovieTicketsBooking.model;

import java.util.Set;

public class Movie {
	
	private String movieId;
	private String movieName;
	private String movieReleaseDate;
	private String movieCinemaId;
	private Set<Show> movieShows;
	
	
	public Set<Show> getMovieShows() {
		return movieShows;
	}
	public void setMovieShows(Set<Show> movieShows) {
		this.movieShows = movieShows;
	}
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
	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}
	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}
	
	public String getMovieCinemaId() {
		return movieCinemaId;
	}
	public void setMovieCinemaId(String movieCinemaId) {
		this.movieCinemaId = movieCinemaId;
	}
	
	
	

}
