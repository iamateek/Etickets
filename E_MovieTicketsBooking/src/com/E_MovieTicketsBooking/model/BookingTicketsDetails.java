package com.E_MovieTicketsBooking.model;

public class BookingTicketsDetails {
 private String booking_id,cinema_id,movie_id,show_id,city_id,seat_category,booking_seats,booking_date;
Integer booking_amount;

public String getBooking_id() {
	return booking_id;
}
public void setBooking_id(String booking_id) {
	this.booking_id = booking_id;
}
public String getCinema_id() {
	return cinema_id;
}
public void setCinema_id(String cinema_id) {
	this.cinema_id = cinema_id;
}
public String getMovie_id() {
	return movie_id;
}
public void setMovie_id(String movie_id) {
	this.movie_id = movie_id;
}
public String getShow_id() {
	return show_id;
}
public void setShow_id(String show_id) {
	this.show_id = show_id;
}
public String getSeat_category() {
	return seat_category;
}
public void setSeat_category(String seat_category) {
	this.seat_category = seat_category;
}
public String getBooking_seats() {
	return booking_seats;
}
public void setBooking_seats(String booking_seats) {
	this.booking_seats = booking_seats;
}
public String getBooking_date() {
	return booking_date;
}
public void setBooking_date(String booking_date) {
	this.booking_date = booking_date;
}
public String getCity_id() {
	return city_id;
}
public void setCity_id(String city_id) {
	this.city_id = city_id;
}
public Integer getBooking_amount() {
	return booking_amount;
}
public void setBooking_amount(Integer booking_amount) {
	this.booking_amount = booking_amount;
}

}
