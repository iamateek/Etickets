package com.E_MovieTicketsBooking.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.E_MovieTicketsBooking.connection.DatabaseConnection;
import com.E_MovieTicketsBooking.model.BookingTicketsDetails;

public class GenerateBookingReportRepository {
	
public BookingTicketsDetails getAllDetails() throws ClassNotFoundException, SQLException
	
	{
			Connection connection=DatabaseConnection.newConnection();
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT * FROM  booking_tickets WHERE booking_id=(SELECT MAX(booking_id)FROM  booking_tickets)");
			ArrayList<BookingTicketsDetails>list = new ArrayList<BookingTicketsDetails>();
			BookingTicketsDetails b_details=new BookingTicketsDetails();
			while(resultSet.next())
			{
				
				
					b_details.setBooking_id(resultSet.getString(1));
				 	b_details.setCity_id(resultSet.getString(2));
				 	b_details.setCinema_id(resultSet.getString(3));
				 	b_details.setMovie_id(resultSet.getString(4));
				 	b_details.setShow_id(resultSet.getString(5));
				 	b_details.setSeat_category(resultSet.getString(6));
				 	b_details.setBooking_seats(resultSet.getString(7));
				 	b_details.setBooking_amount(resultSet.getInt(8));
				 	b_details.setBooking_date(resultSet.getString(9));
				
			}
			return b_details ;
		
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		GenerateBookingReportRepository m = new GenerateBookingReportRepository();
		BookingTicketsDetails report= m.getAllDetails();
		
		
		
			System.out.println("R:-"+report.getBooking_id()+":"+report.getCity_id()+":"+report.getCinema_id()+":"+report.getMovie_id()+":"+report.getBooking_date()+":"+report.getShow_id()+":"+report.getBooking_seats()+":"+report.getBooking_amount());

		
	}

}
