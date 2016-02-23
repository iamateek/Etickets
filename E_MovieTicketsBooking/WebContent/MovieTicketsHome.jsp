<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MovieTicketsHome</title>
<script> 
 function showCinemaMovies(cinemaName){
	/* var cityName = document.getElementById("mycity"); */
	var cityName="lelo";
	 for(var i = 1; i < mycity.options.length; i++)
	   {
	      if(mycity.options[i].selected == true)
	      {
	    	  cityName=mycity.options[i].value;
	      }
	   }

	/*var cinemaName = document.getElementById("cinemaName"); */ 
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
 document.getElementById("movies").innerHTML=xmlhttp.responseText; 
 } 
 } 
 xmlhttp.open("GET","UpdateCinemaMovies.jsp?selectedCinema="+cinemaName+"&city="+cityName,true); 
 /* url : "activeChallengeStatus.do?challengeValue=" + challengeValue
 + "&challengeIdValue=" + challengeIdValue, */
 xmlhttp.send(); 
 } 
 </script>

<script> 
 function showCityCinema(cityName){ 
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
 document.getElementById("mycinema").innerHTML=xmlhttp.responseText; 
 } 
 } 
 xmlhttp.open("GET","getcitycinema.jsp?selectedCity="+cityName,true); 
 xmlhttp.send(); 
 } 
 </script> 

</head>
<body>
<%@ page import="java.util.*" %>
<%@ page import="com.E_MovieTicketsBooking.model.*" %>
<!-- -----------------------------------header------------------------------------------------------- -->
	<%@ include file="Header.jsp" %>
<!-- -----------------------------------header------------------------------------------------------- -->	

<% ArrayList<City> cities=(ArrayList<City>)request.getAttribute("cities"); %>

	<center>
	<fieldset style="width:1000px;hight:1000px">
	
		<table>
        	<tr>
<!-- ----------------------------------T1------------------------------------------------------- -->
        		<td>
        			<div id="fieldset">
             			<form  id="findMovie" name="categorySelection" action="LoadWelcomeController" method="get">
          					<fieldset style="width:400px;hight:1000px">
                				<table align="center">
          						<tr>
						          	<td>Select City</td>
						          	<td>
						          	<select id="mycity" name="mycity" onchange="showCityCinema(this.value)">
						          	<option>select city</option> 
						          	<%
						          	 for(City city:cities){ 
						          		 %> 

						          		 <option value="<%=city.getCityName()%>"><%=city.getCityName()%></option>
						          		 <label  id="cityName" value="<%=city.getCityName()%>" type="hidden" ></label> 
						          		 <% 
						          		 } 
						          		 %>
						          	</select>
						          	</td>
          						</tr>
					          	<tr>
						          	<td>Select Cinema:-</td>
						          	<td>
						          	<select id="mycinema" onchange="showCinemaMovies(this.value)">
						          	<option>select cinema</option>
						          	</select>
						          	</td>
						          	
          						</tr>
          						<tr>
          						</tr>
          						</table>
          					</fieldset>
          				</form>
          			</div>
          		</td>
          		<td>
          	
<!-- ----------------display-after-submit----------------------------------------------- -->          			
<div id="display-after-submit" class="display-after-submit_position">
	<div id="fieldset" name="cityMovies">
         		<fieldset style="width:500px;hight:500px" id="fieldset">
                 <table id="movies" name="movies"border="2"  width="100%">
          						</table>
          					</fieldset>
          			</div>
          		</div>	
<!-- ----------------display-after-submit----------------------------------------------- --> 
				</td>
          		</tr>
			</table>
	</fieldset>
	</center>
<!-- ------------------footer---------------------------------------------------------------- -->	
<%@ include file="Footer.jsp" %>
<!-- ------------------footer---------------------------------------------------------------- -->
</body>
</html>