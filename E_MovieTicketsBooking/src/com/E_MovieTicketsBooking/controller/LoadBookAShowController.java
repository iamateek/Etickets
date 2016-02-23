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

import com.E_MovieTicketsBooking.model.SeatCategory;
import com.E_MovieTicketsBooking.service.LoadBookAShowService;

/**
 * Servlet implementation class LoadBookAShowController
 */
@WebServlet("/LoadBookAShowController")
public class LoadBookAShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		LoadBookAShowService loadBookAShowService = new LoadBookAShowService();
		try {
			ArrayList<SeatCategory> category_list= loadBookAShowService.getAllcategoryService();
				RequestDispatcher rd =request.getRequestDispatcher("seatsBooking.jsp");
				request.setAttribute("records", category_list);				
				rd.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
