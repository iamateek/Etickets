package com.E_MovieTicketsBooking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.E_MovieTicketsBooking.model.BookingTicketsDetails;
import com.E_MovieTicketsBooking.service.BookAShowService;

@WebServlet("/BookAShowController")
public class BookAShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		System.out.println("controller");
		String seatsCategories=request.getParameter("seatsCategories");
		String [] selectedSeats= request.getParameterValues("availableSeats");
		int noofseats=0;
		int ammount=0;
		StringBuffer bookedSeats=new StringBuffer("");
		for(String seat:selectedSeats)
		{
			bookedSeats=bookedSeats.append(",").append(seat);
			noofseats++;
		}
		if(seatsCategories.equals("platinum"))
			ammount=noofseats*120;
		else if(seatsCategories.equals("gold"))
			ammount=noofseats*100;
		else if(seatsCategories.equals("silver"))
			ammount=noofseats*80;
		BookingTicketsDetails bookingTicketsDetails=new BookingTicketsDetails();
//		                      bookingTicketsDetails.setBooking_id(booking_id);
		                      bookingTicketsDetails.setBooking_seats(new String(bookedSeats));
		                      bookingTicketsDetails.setBooking_amount(ammount);
		                      bookingTicketsDetails.setBooking_date(request.getParameter("showdate"));
		                      bookingTicketsDetails.setCinema_id(request.getParameter("showcinema"));
		                      bookingTicketsDetails.setCity_id(request.getParameter("showcity"));
		                      bookingTicketsDetails.setMovie_id(request.getParameter("showmovie"));
		                      bookingTicketsDetails.setSeat_category(seatsCategories);
		                      bookingTicketsDetails.setShow_id(request.getParameter("showtime"));
		                      
		                      
		/*-------------------------------------------------------display------------------------------*/
		                  System.out.println(bookingTicketsDetails.getBooking_seats());
		                  System.out.println(bookingTicketsDetails.getBooking_amount());
		                  System.out.println(bookingTicketsDetails.getBooking_date());
		                  System.out.println(bookingTicketsDetails.getCinema_id());
		                  System.out.println(bookingTicketsDetails.getCity_id());
		                  System.out.println(bookingTicketsDetails.getMovie_id());
		                  System.out.println(bookingTicketsDetails.getSeat_category());
		                  System.out.println(bookingTicketsDetails.getShow_id());
		/*-------------------------------------------------------display------------------------------*/

		 BookAShowService bookAShowService=new BookAShowService();
		         try {
		          			boolean status= bookAShowService.saveBookingInfoService(bookingTicketsDetails);
		          			if(status)
		          			{   out.println("Ticket Booking Successfull");
		          				RequestDispatcher newRequestDispatcher=request.getRequestDispatcher("GenerateBookingReportController");
		          				                 newRequestDispatcher.include(request, response);
		          			}
		          			  out.println("Ticket Booking Faild");
		          			RequestDispatcher newRequestDispatcher=request.getRequestDispatcher("LoadWelcomeController");
				                 newRequestDispatcher.include(request, response);	
		          	 } catch (ClassNotFoundException e) {
		          				
		          	         e.printStackTrace();
		          	 } catch (SQLException e) {
		          	
		          			 e.printStackTrace();
		          	 }
			
	}
}
