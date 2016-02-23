package com.E_MovieTicketsBooking.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.E_MovieTicketsBooking.model.SeatCategory;
import com.E_MovieTicketsBooking.model.SeatStatus;
import com.E_MovieTicketsBooking.repository.LoadBookAShowRepository;

public class LoadBookAShowService
{
	
	public ArrayList<SeatStatus>getAllAvailableSeats(SeatCategory selectedCategory) throws ClassNotFoundException, SQLException
	{
		System.out.println("LoadBookAShowService");
	LoadBookAShowRepository loadBookAShowRepository = new LoadBookAShowRepository();
	ArrayList<SeatStatus> availableSeats = loadBookAShowRepository.getAllAvailableSeats(selectedCategory);
	if(availableSeats!=null)
	{
		return availableSeats;
	}
	else
		return null;
	}
  /* public static void main(String[] args) {
	   LoadBookAShowService ll=new LoadBookAShowService();
	   SeatCategory selectedCategory=new SeatCategory();
	                selectedCategory.setSeat_category("gold");
	   try {
		ArrayList<SeatStatus> ss=ll.getAllAvailableSeats(selectedCategory);
		for(SeatStatus s:ss)
			System.out.println(s.getSeat_number());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/



public ArrayList<SeatCategory>getAllcategoryService() throws ClassNotFoundException, SQLException
	{
	LoadBookAShowRepository loadBookAShowRepository = new LoadBookAShowRepository();
	ArrayList<SeatCategory> catergory_list = loadBookAShowRepository.getAllCategory();
	if(catergory_list!=null)
	{
		return catergory_list;
	}
	else
		return null;
}
}