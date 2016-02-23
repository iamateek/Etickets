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

import com.E_MovieTicketsBooking.model.Cinema;
import com.E_MovieTicketsBooking.model.City;
import com.E_MovieTicketsBooking.model.Movie;
import com.E_MovieTicketsBooking.service.LoadCinemaMoviesService;
import com.E_MovieTicketsBooking.service.LoadCityService;

/**
 * Servlet implementation class LoadWelcomeController
 */
@WebServlet("/LoadWelcomeController")
public class LoadWelcomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		System.out.println("LoadWelcomeController");
/*		String cinemaId="TH01";
		cinemaId= request.getParameter("mycinema");
		System.out.println(cinemaId);
		if(cinemaId.equals("")||cinemaId==null)
			cinemaId="TH01";
		Cinema cinemaMovies = new Cinema();
			   cinemaMovies.setCinemaId(cinemaId);
			   LoadCinemaMoviesService loadCinemaMoviesService = new LoadCinemaMoviesService();
*/
		LoadCityService loadCityService=new LoadCityService();
		try {
			ArrayList<City>	cities=loadCityService.fetchAllCity();
			                request.setAttribute("cities", cities);
			/*ArrayList<Movie> m_list = loadCinemaMoviesService.getAllCinemaMovies(cinemaMovies);
			 			   request.setAttribute("moviesList", m_list); */              
			RequestDispatcher newRequestDispatcher=request.getRequestDispatcher("MovieTicketsHome.jsp");
			                  newRequestDispatcher.forward(request, response);
		} catch (ClassNotFoundException e)
		{

			e.printStackTrace();
		} catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		
	}
		
	


}
