package com.E_MovieTicketsBooking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.E_MovieTicketsBooking.model.Cinema;
import com.E_MovieTicketsBooking.repository.LoadCinemaRepository;




public class LoadCinemaService {

	public ArrayList<Cinema> fetchAllCinemas(String str){
		
		LoadCinemaRepository loadCinemaRepository=new LoadCinemaRepository();
		ArrayList<Cinema> cinemas=null;
		try {
			cinemas = loadCinemaRepository.fetchAllCinemas(str);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cinemas !=null)
		{
			return cinemas;
		}
		
		return null;
	}

}
