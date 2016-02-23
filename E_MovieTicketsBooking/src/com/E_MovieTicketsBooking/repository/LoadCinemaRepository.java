package com.E_MovieTicketsBooking.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.E_MovieTicketsBooking.connection.DatabaseConnection;
import com.E_MovieTicketsBooking.model.Cinema;




public class LoadCinemaRepository {

	public ArrayList<Cinema> fetchAllCinemas(String str) throws ClassNotFoundException, SQLException {
		
		
		
		Connection connection=DatabaseConnection.newConnection();
		Statement statement=connection.createStatement();
		ResultSet newResultSet=statement.executeQuery("SELECT * FROM cinema_details WHERE city_id=(SELECT city_id FROM city WHERE city_name='indore')");
		
		ArrayList<Cinema> cinemas=new ArrayList<Cinema>();
		while (newResultSet.next()) {
			
			Cinema cinema=new Cinema();
			cinema.setCinemaId(newResultSet.getString(1));
			cinema.setCinemaName(newResultSet.getString(2));
			
			cinemas.add(cinema);
		}
		
		return cinemas;
		
	}

}
