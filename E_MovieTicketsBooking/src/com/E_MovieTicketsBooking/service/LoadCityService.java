package com.E_MovieTicketsBooking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.E_MovieTicketsBooking.model.City;
import com.E_MovieTicketsBooking.repository.LoadCityRepository;



public class LoadCityService {

	public ArrayList<City> fetchAllCity() throws ClassNotFoundException, SQLException {
		LoadCityRepository loadCityRepository=new LoadCityRepository();
		ArrayList<City>	cities=loadCityRepository.fetchAllCity();
		if(cities !=null)
		{
			return cities;
		}
		return null;
	}

}
