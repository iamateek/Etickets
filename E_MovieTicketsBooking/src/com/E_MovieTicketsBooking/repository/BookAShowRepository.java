package com.E_MovieTicketsBooking.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.E_MovieTicketsBooking.connection.DatabaseConnection;
import com.E_MovieTicketsBooking.model.BookingTicketsDetails;

public class BookAShowRepository {

	public boolean saveBookingInfoRepository(BookingTicketsDetails bookingTicketsDetails) throws ClassNotFoundException, SQLException {
		System.out.println("repository");

		/*int bookingId=4;Integer.parseInt(bookingTicketsDetails.getBooking_id());*/		
		String cinemaId=bookingTicketsDetails.getCinema_id();
		String movieId=bookingTicketsDetails.getMovie_id();
		String showId=bookingTicketsDetails.getShow_id();
		String cityId=bookingTicketsDetails.getCity_id();		
		String seatCat=bookingTicketsDetails.getSeat_category();
		String bookingSeats=bookingTicketsDetails.getBooking_seats();
		Integer bookingAmount=bookingTicketsDetails.getBooking_amount();
		String bookingDate=bookingTicketsDetails.getBooking_date();
		
		
		
		 System.out.println(bookingTicketsDetails.getBooking_seats());
         System.out.println(bookingTicketsDetails.getBooking_amount());
         System.out.println(bookingTicketsDetails.getBooking_date());
         System.out.println(bookingTicketsDetails.getCinema_id());
         System.out.println(bookingTicketsDetails.getCity_id());
         System.out.println(bookingTicketsDetails.getMovie_id());
         System.out.println(bookingTicketsDetails.getSeat_category());
         System.out.println(bookingTicketsDetails.getShow_id());
		
		
		
		

		String saveBooking="insert into booking_tickets (city_id,cinema_id,movie_id,show_id,seat_category,booking_seats,booking_amount,booking_date) values(?,?,?,?,?,?,?,?)";
		Connection con=DatabaseConnection.newConnection();
		PreparedStatement statement=con.prepareStatement(saveBooking);
		/*statement.setInt(1, bookingId);*/
		statement.setString(1, cityId);
		statement.setString(2, cinemaId);
		statement.setString(3, movieId);
		statement.setString(4,showId);
		statement.setString(5, seatCat);
		statement.setString(6, bookingSeats);
		statement.setInt(7, bookingAmount);
		statement.setString(8, bookingDate );
		int effected=statement.executeUpdate();
		if(effected==1)
			return true;
		
		return false;
	}
}
