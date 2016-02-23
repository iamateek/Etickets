package com.E_MovieTicketsBooking.model;

import java.util.Set;

public class SeatCategory {
	
	
	private String seat_category;
	private String seat_amount;
	private String no_of_seat;
	private Set<SeatStatus>fkey_status;
	public String getSeat_category() {
		return seat_category;
	}
	public void setSeat_category(String seat_category) {
		this.seat_category = seat_category;
	}
	public String getSeat_amount() {
		return seat_amount;
	}
	public void setSeat_amount(String seat_amount) {
		this.seat_amount = seat_amount;
	}
	public String getNo_of_seat() {
		return no_of_seat;
	}
	public void setNo_of_seat(String no_of_seat) {
		this.no_of_seat = no_of_seat;
	}
	public Set<SeatStatus> getFkey_status() {
		return fkey_status;
	}
	public void setFkey_status(Set<SeatStatus> fkey_status) {
		this.fkey_status = fkey_status;
	}

	
}
