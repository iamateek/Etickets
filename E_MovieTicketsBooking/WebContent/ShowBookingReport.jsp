<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.sql.*" %>
<%@ page import="com.E_MovieTicketsBooking.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<!-- -----------------------------------header------------------------------------------------------- -->
	<%@ include file="Header.jsp" %>
<!-- -----------------------------------header------------------------------------------------------- -->


<%
   BookingTicketsDetails bookingDetail=(BookingTicketsDetails)request.getAttribute("bookingDetail");
%>

<table>
   <tr>
   <td>show time:-</td>
   <td><%=bookingDetail.getShow_id() %></td>
   <td>show date:-</td>
   <td><%=bookingDetail.getBooking_date() %></td>
   </tr>
   <tr>
   <td>movie name:-</td>
   <td><%=bookingDetail.getMovie_id() %></td>
   <td>cinema name:-</td>
   <td><%=bookingDetail.getCinema_id() %></td>
   </tr>
   <tr>
   <td>city name:-</td>
   <td><%=bookingDetail.getCity_id() %></td>
   <td>seat category:-</td>
   <td><%=bookingDetail.getSeat_category() %></td>
   </tr>
   <tr>
   <td>seat reserved:-</td>
   <td><%=bookingDetail.getBooking_seats() %></td>
   <td>total ammount:-</td>
   <td><%=bookingDetail.getBooking_amount() %></td>
   <td></td>
   <td></td>
   </tr>
   
</table>

<!-- ------------------footer---------------------------------------------------------------- -->	
<%@ include file="Footer.jsp" %>
<!-- ------------------footer---------------------------------------------------------------- -->
</body>
</html>