package com.E_MovieTicketsBooking.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.E_MovieTicketsBooking.connection.DatabaseConnection;
import com.E_MovieTicketsBooking.model.Cinema;
import com.E_MovieTicketsBooking.model.City;
import com.E_MovieTicketsBooking.model.Movie;
import com.E_MovieTicketsBooking.model.Show;

public class LoadCinemaMoviesRepository 
{
	public ArrayList<Movie> getAllCinemaMovies(Cinema cinema) throws SQLException, ClassNotFoundException
	{
		/*
				ArrayList<String> extraDetails=fetchExtra(cinema); 
				ArrayList<Object> OverAll=new ArrayList<Object>();
				                 OverAll.add(extraDetails);
				                 */
				Connection connection = DatabaseConnection.newConnection();
	        	String sql = "select movie_id,movie_name from movie_details where cinema_id=(select cinema_id from cinema_details where cinema_name='"+cinema.getCinemaName()+"')";
	        	Statement stmt = connection.createStatement();
				ResultSet rs2 = stmt.executeQuery(sql);
				ArrayList<Movie> m_list = new ArrayList<Movie>();
				while(rs2.next())
				{				
					Movie movie=new Movie();
					movie.setMovieId(rs2.getString(1));
					String movieId=rs2.getString(1);
					movie.setMovieName(rs2.getString(2));
					System.out.println("...............................................................");
						String sql3 = "select * from show_details where movie_id='"+movieId+"'";
						PreparedStatement ps3 = connection.prepareStatement(sql3);
						ResultSet rs3 = ps3.executeQuery();
						Set<Show> movieShows = new HashSet<Show>();
						while(rs3.next())
						{		
							Show show=new Show();
							show.setShowId(rs3.getString(1));
							show.setShowTime(rs3.getString(2));
							movieShows.add(show);
							/*System.out.println(showpojo.getShowTime());*/
						}
						movie.setMovieShows(movieShows);
					System.out.println("...............................................................");
					m_list.add(movie);					
				}
					/*for (Movie movie1 : m_list) 
					{
						System.out.print("movie:-");
						System.out.println(movie1.getMovieId()+":"+movie1.getMovieName());
						Set<Show> movieShows=movie1.getFkey_show();
						for (Show show : movieShows) {
							System.out.print("show:-");
							System.out.println(show.getShowTime());
						}
					}*/
				/*OverAll.add(m_list);
					return OverAll;*/
		     return m_list;		
			}

	private ArrayList<String> fetchExtra(Cinema cinema) throws SQLException, ClassNotFoundException {
		String cityId=null;
		String cinemaName=null;
		String cityName=null;
		Connection connection = DatabaseConnection.newConnection();
		Statement newStatement1=connection.createStatement();
		Statement newStatement2=connection.createStatement();
		ResultSet rs1=newStatement1.executeQuery("select * from cinema_details where cinema_id='"+cinema.getCinemaId()+"'");
		while(rs1.next())
		{
			cityId=rs1.getString(5);
			cinemaName=rs1.getString(2);
		}
		 ResultSet rs2=newStatement2.executeQuery("select city_name from city where city_id='"+cityId+"'");
		          while(rs2.next())
		        	  cityName=rs2.getString("city_name");
		        ArrayList<String> extraDetails=new ArrayList<String>();
		                    extraDetails.add(cityName);
		                    extraDetails.add(cinemaName);
		return extraDetails;
	}
			
}

