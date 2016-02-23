package com.E_MovieTicketsBooking.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.E_MovieTicketsBooking.connection.DatabaseConnection;
import com.E_MovieTicketsBooking.model.SeatCategory;
import com.E_MovieTicketsBooking.model.SeatStatus;


public class LoadBookAShowRepository
{
	public ArrayList<SeatStatus> getAllAvailableSeats(SeatCategory selectedCategory) throws ClassNotFoundException, SQLException
	{
		System.out.println("LoadBookAShowRepository");
		Connection connection=DatabaseConnection.newConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from  seat_status where seat_category='"+selectedCategory.getSeat_category()+"' and seat_status='0'");
		ArrayList<SeatStatus> availableSeats = new ArrayList<SeatStatus>();
		while(resultSet.next())
		{
			SeatStatus seatNumber=new SeatStatus();
			seatNumber.setSeat_number(resultSet.getString(1));
			           availableSeats.add(seatNumber);
		}
		return availableSeats;
	
	}
	
	
	/*public static void main(String []args) {
		
		LoadBookAShowRepository loadBookAShowRepository=new LoadBookAShowRepository();
		  SeatCategory selectedCategory=new SeatCategory();
		               selectedCategory.setSeat_category("platinum");
		                        try {
									loadBookAShowRepository.getAllAvailableSeats(selectedCategory);
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	}
	*/





public ArrayList<SeatCategory> getAllCategory() throws ClassNotFoundException, SQLException
	{
		
		Connection connection=DatabaseConnection.newConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from  seat_category");
		ArrayList<SeatCategory>category_list = new ArrayList<SeatCategory>();
		while(resultSet.next())
		{
			SeatCategory catergory2 = new SeatCategory();
			catergory2.setSeat_category(resultSet.getString(1));
			catergory2.setSeat_amount(resultSet.getString(2));
			String seatCategory =resultSet.getString(1);
				
				String seatAmount = catergory2.getSeat_amount();
				Statement statement1=connection.createStatement();
				String sql = "select * from seat_status where seat_category='"+seatCategory+"'and seat_status='"+0+"'";
				ResultSet rs1 = statement1.executeQuery(sql);
				Set<SeatStatus>status_list = new HashSet<SeatStatus>();
				while(rs1.next())
				{
					SeatStatus seatStatuspojo = new SeatStatus();
					seatStatuspojo.setSeat_number(rs1.getString(1));
					status_list.add(seatStatuspojo);

				}
				catergory2.setFkey_status(status_list);
				
				category_list.add(catergory2);				
				
			}
			
		
		return category_list;
		
		
		
		
		
		
	
	}

}
