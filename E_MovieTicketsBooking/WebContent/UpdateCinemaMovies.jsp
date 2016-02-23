<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.E_MovieTicketsBooking.model.*,com.E_MovieTicketsBooking.service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdateCinemaMovies</title>
</head>
<body>
<%
String cinemaName = request.getParameter("selectedCinema");
String cityName = request.getParameter("city");
/* String cinemaName = request.getParameter("cinema"); */
System.out.println("UpdateCinemaMovies:-getting cinema id:-"+cinemaName+":"+cityName+":"+"-:from request");
Cinema cinemaMovies = new Cinema();
	   cinemaMovies.setCinemaName(cinemaName);
LoadCinemaMoviesService service = new LoadCinemaMoviesService();
	ArrayList<Movie> m_list = service.getAllCinemaMovies(cinemaMovies);
	/* ArrayList<String> extra=(ArrayList<String>)overAll.get(0);
	                 String cityName= extra.get(0);
	                 out.println(cityName);
	                 String cinemaName=extra.get(1);
	                 out.println(cinemaName);
	ArrayList<Movie> m_list=(ArrayList<Movie>)overAll.get(1); */
	
		
%>

             
         		
                 <table >
                  <tr><th>Movie Poster</th><th colspan="4">Movie Timiing</th></tr>
                  <%
                      for(Movie movie:m_list)
                      { 
                    	  String movieName=movie.getMovieName(); 
                         Set<Show> movieShows=movie.getMovieShows();
                      %>
                    	  <tr>
                    	  <td><%=movie.getMovieName() %></td>
                    	  <%
                    	    for(Show show:movieShows)
                    	    {
                    	  %>   <!--  selectedCinema="+cinemaId+"&city="+cityName+"&cinema="+cinemaName -->
                    	  		<h3><td><a href="LoadBookAShowController?city=<%= cityName%>&cinema=<%=cinemaName %>&movie=<%=movieName%>&show=<%=show.getShowTime()%>" ><%=show.getShowTime() %></a></td></h3>
                    	  <%} %>
                    	  </tr>
                      <% }%>

          						</table>
          					</fieldset>
          			</div>

</body>
</html>