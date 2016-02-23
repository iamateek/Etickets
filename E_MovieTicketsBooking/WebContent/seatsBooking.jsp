<%@page import="java.util.*,java.sql.*"%>
<%@page import="com.E_MovieTicketsBooking.model.*"%>
<%@ page import="com.E_MovieTicketsBooking.service.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>seat</title>
<style type="text/css">

.demo{width:700px; margin:40px auto 0 auto; min-height:450px;}
.front{width: 300px;margin: 5px 32px 45px 32px;background-color: #f0f0f0;	color: #666;text-align: center;padding: 3px;border-radius: 5px;}
.booking-details {float: right;position: relative;width:200px;height: 600px;margin-right: 0px; line-height: 50px;}
.booking-details h3 {margin: 5px 5px 0 0;font-size: 16px;}
.booking-details td{ font-size:26px; color:#999}
.booking-details P span{color:#666}

div.seatCharts-container {border-right: 1px dotted #adadad;width: 400px;padding: 20px;float: left;}

</style>

<script> 
 function showAvailableSeats(seatCategory){ 
 var xmlhttp; 

 if (window.XMLHttpRequest) 
 {// code for IE7+, Firefox, Chrome, Opera, Safari 
 xmlhttp=new XMLHttpRequest(); 
 } 
 else 
 {// code for IE6, IE5 
 xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
 } 
 xmlhttp.onreadystatechange=function() 
 { 
 if (xmlhttp.readyState==4 && xmlhttp.status==200) 
 { 
 document.getElementById("availableSeats").innerHTML=xmlhttp.responseText; 
 } 
 } 
 xmlhttp.open("GET","GetAvailableSeats.jsp?seatCategory="+seatCategory,true); 
 xmlhttp.send(); 
 } 
 </script>

</head>
<body>

<%-- <!-- -----------------------------------header------------------------------------------------------- -->
	<%@ include file="Header.jsp" %>
<!-- -----------------------------------header------------------------------------------------------- --> --%>

<%

String cityName=(String)request.getParameter("city");
String cinemaName=(String)request.getParameter("cinema");
String movieName=(String)request.getParameter("movie");
String showTime=(String)request.getParameter("show");
   ArrayList<SeatCategory> records=(ArrayList<SeatCategory>)request.getAttribute("records");
%>
<form action="BookAShowController" method="post">

		<div class="demo" >
		   <div class="seatCharts-container">
				<img src="images/movieimage.jpg" alt="cute couple"></img>		
		   </div>
	
		<div class="booking-details" >
		<table>
		<%
		    for(SeatCategory category:records){
		 %>  	
		    
		    	<tr>
		        <td colspan="2"><label><%=category.getSeat_category() %></label></td>
		        <td><label><%=category.getSeat_amount() %></label></td>
		        </tr>	
		<%
			}
		%>
				<tr>	
					<td colspan="2">Seat Categories</td>
					<td>
					<select id="seatsCategories" name="seatsCategories">
					<option value="nothing" selected="selected">Select-category </option>
					<%
						for(SeatCategory category:records){
					%>
					    <option value="<%=category.getSeat_category()%>"><%=category.getSeat_category()%> </option>
					    <%
						}
					    %>
					</select>
			       </td>
			     </tr>			       
			   	<tr>
			   	
			   	<td>Movie:-</td>
        		<td><input type="text" name="showmovie" value="<%= movieName%>" readonly="readonly"></td>
			   	
			   		<td colspan="1">Seats</td>
					<td>
					<select id="availableSeats" name="availableSeats" multiple="multiple" onblur="findSelections()">
					<%
					   for(SeatCategory category:records){
						   Set<SeatStatus> seats=category.getFkey_status();
						   for(SeatStatus seat:seats){
					%>
					  <option value="<%=seat.getSeat_number()%>"><%=seat.getSeat_number()%></option>
					  
					  <%
						   }					  
					   	}
					  %>
					  
					</select>
			  		</td>			
				</tr>
				<tr>
        	<td>City:-</td>
        	<td><input type="text" name="showcity" value="<%=cityName %>" readonly="readonly" ></td>
        	<td>Cinema:-</td>
        	<td><input type="text" name="showcinema" value="<%=cinemaName %>" readonly="readonly"></td>
        </tr>
      
        <tr>
        	<td> Date:-</td>
        	<td><input type="text" name="showdate" /></td>
        	<td> Time:-</td>
        	<td><input type="text" name="showtime" value="<%=showTime %>" readonly="readonly"></td>
        </tr>
        <tr></tr>
        <tr><td colspan="2"></td>
        <td ><input type="submit" value="Buy"></td></tr>
        
        </table>								
 	</div>
										
  	</div>
  
</form> 

<%-- <!-- ------------------footer---------------------------------------------------------------- -->	
<%@ include file="Footer.jsp" %>
<!-- ------------------footer---------------------------------------------------------------- --> --%>

</body>
</html>