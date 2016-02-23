package com.E_MovieTicketsBooking.service;

import java.sql.SQLException;

import com.E_MovieTicketsBooking.model.BookingTicketsDetails;
import com.E_MovieTicketsBooking.repository.BookAShowRepository;

public class BookAShowService {

	public boolean saveBookingInfoService(BookingTicketsDetails bookingTicketsDetails) throws ClassNotFoundException, SQLException {
		System.out.println("repository");
		
		BookAShowRepository bookAShowRepository=new BookAShowRepository();
		boolean status=bookAShowRepository.saveBookingInfoRepository(bookingTicketsDetails);
        
		
		return status;
	}
}
