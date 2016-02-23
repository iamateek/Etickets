package com.E_MovieTicketsBooking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.E_MovieTicketsBooking.model.City;
import com.E_MovieTicketsBooking.service.LoadCityService;




/**
 * Servlet implementation class LoadCityController
 */
@WebServlet("/LoadCityController")
public class LoadCityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		LoadCityService loadCityService=new LoadCityService();
		try {
			ArrayList<City>	cities=loadCityService.fetchAllCity();
			                request.setAttribute("cities", cities);
			RequestDispatcher newRequestDispatcher=request.getRequestDispatcher("MovieTicketsHome.jsp");
			                  newRequestDispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
