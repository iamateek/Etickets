package com.E_MovieTicketsBooking.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.E_MovieTicketsBooking.connection.DatabaseConnection;
import com.E_MovieTicketsBooking.model.City;



public class LoadCityRepository {

	public ArrayList<City> fetchAllCity() throws ClassNotFoundException, SQLException {

		Connection connection=DatabaseConnection.newConnection();
		Statement statement=connection.createStatement();
		ResultSet newResultSet=statement.executeQuery("select * from city");
		
		ArrayList<City> cities=new ArrayList<City>();
		while (newResultSet.next()) {
			
			City city=new City();
			city.setCityId(newResultSet.getString(1));
			city.setCityName(newResultSet.getString(2));
			
			cities.add(city);
		}
		
		return cities;
	}

}
