package com.E_MovieTicketsBooking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.E_MovieTicketsBooking.model.BookingTicketsDetails;
import com.E_MovieTicketsBooking.service.GenerateBookingReportService;


/**
 * Servlet implementation class GenerateBookingReportController
 */
@WebServlet("/GenerateBookingReportController")
public class GenerateBookingReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		
		GenerateBookingReportService service = new GenerateBookingReportService();
			BookingTicketsDetails bookingDetail=null;
			try {
				bookingDetail = service.getResultSet();
				RequestDispatcher rd = request.getRequestDispatcher("ShowBookingReport.jsp");
				request.setAttribute("bookingDetail", bookingDetail);
				rd.forward(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
	}

}
