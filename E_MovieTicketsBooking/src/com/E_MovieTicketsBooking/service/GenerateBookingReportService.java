package com.E_MovieTicketsBooking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.E_MovieTicketsBooking.model.BookingTicketsDetails;
import com.E_MovieTicketsBooking.repository.GenerateBookingReportRepository;

public class GenerateBookingReportService {

	
	public BookingTicketsDetails getResultSet() throws SQLException, ClassNotFoundException
	{
		GenerateBookingReportRepository myrepository = new GenerateBookingReportRepository();
		BookingTicketsDetails bookingDetail = myrepository.getAllDetails();
		return bookingDetail;
				
	}
	
}
