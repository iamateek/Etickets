package com.E_MovieTicketsBooking.model;

import java.util.Set;

public class Cinema {
	
	private String cinemaId;
	private String cinemaName;
	private String cinemaLocation;
	private String cinemaContact;
	private Set<Movie> cinemaMovies;
	private String cityId;
	
	public Set<Movie> getCinemaMovies() {
		return cinemaMovies;
	}
	public void setCinemaMovies(Set<Movie> cinemaMovies) {
		this.cinemaMovies = cinemaMovies;
	}
	public String getCinemaId() {
		return cinemaId;
	}
	public void setCinemaId(String cinemaId) {
		this.cinemaId = cinemaId;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	public String getCinemaLocation() {
		return cinemaLocation;
	}
	public void setCinemaLocation(String cinemaLocation) {
		this.cinemaLocation = cinemaLocation;
	}
	public String getCinemaContact() {
		return cinemaContact;
	}
	public void setCinemaContact(String cinemaContact) {
		this.cinemaContact = cinemaContact;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	
	

}
