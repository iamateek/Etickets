<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.sql.*"%> 
<%@ page import="com.E_MovieTicketsBooking.model.*" %>
<%@ page import="com.E_MovieTicketsBooking.service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
	String str=request.getParameter("selectedCity");
	System.out.println("getting cityid:-"+str+"-:from request");
	LoadCinemaService loadCinemaService=new LoadCinemaService();
	ArrayList<Cinema>	cinemas=loadCinemaService.fetchAllCinemas(str); 
%>



mycinema : 
 <select>
<% for(Cinema cinema:cinemas){ 
 %> 
 <option value="<%=cinema.getCinemaName()%>"><%=cinema.getCinemaName()%></option>
 <label  id="cinemaName" value="<%=cinema.getCinemaName()%>" type="hidden" ></label> 
<% }%>
  
 </select> 


</body>
</html>