package com.E_MovieTicketsBooking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.E_MovieTicketsBooking.model.Cinema;
import com.E_MovieTicketsBooking.model.Movie;
import com.E_MovieTicketsBooking.repository.LoadCinemaMoviesRepository;

public class LoadCinemaMoviesService 
{
	public ArrayList<Movie> getAllCinemaMovies(Cinema cinema) throws SQLException, ClassNotFoundException
	{
		LoadCinemaMoviesRepository loadCinemaMoviesRepository=new LoadCinemaMoviesRepository();
		ArrayList<Movie> m_list=loadCinemaMoviesRepository.getAllCinemaMovies(cinema);
		
		if(m_list !=null)
		{
			return m_list;
		}
		return null;
	}
	
	

}
