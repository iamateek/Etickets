package com.E_MovieTicketsBooking.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	
	public static Connection newConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.8.64.2:3306/online","adminaKSeXAQ","xXTQ99QIk9K1");
		return connection; /* DriverManager.getConnection("jdbc:mysql://127.8.64.2:3306/online ","adminaKSeXAQ","xXTQ99QIk9K1");*/
	}

}




