<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MovieTicketsBookAShow</title>

<style type="text/css">

.demo{width:700px; margin:40px auto 0 auto; min-height:450px;}
.front{width: 300px;margin: 5px 32px 45px 32px;background-color: #f0f0f0;	color: #666;text-align: center;padding: 3px;border-radius: 5px;}

.booking-details {float: right;position: relative;width:200px;height: 600px;margin-right: 0px; line-height: 50px;}
.booking-details h3 {margin: 5px 5px 0 0;font-size: 16px;}
.booking-details td{ font-size:26px; color:#999}
.booking-details P span{color:#666}

div.seatCharts-container {border-right: 1px dotted #adadad;width: 400px;padding: 20px;float: left;}

</style>

 


</head>
<body>

<body>

<form action="BookAShowController" method="post">

		<div class="demo" >
		   <div class="seatCharts-container">
				<img src="images/movieimage.jpg" alt="cute couple"></img>		
		</div>
	
		<div class="booking-details" >
		<table>
				<tr>	
					<td colspan="2">Seats Categories</td>
					<td>
					<select name="seats category">
					  <option value="silver" >Silver</option>
					  <option value="gold">Gold</option>
					  <option value="platinum">Platinum</option>
					</select>
			       </td>
			     </tr>
			       
			   	<tr>
			   		<td colspan="2">Available Seats</td>
					<td>
					<select name="seats">
					  <option value="1" >1</option>
					  <option value="2">2</option>
					  <option value="3">3</option>
					</select>
			  		</td>			
				</tr>
				<tr>
                 <td colspan="2">selected seats:</td>
                 
                 <td><label id="selected"> <input type="text" disabled="disabled" style="width: 80px;"></label></td>				
				</tr>
				
				<tr>
                 <td colspan="2">Totel Ammount:</td>            
                 <td><label id="selected"> <input type="text" style="width: 80px;"> </label></td>				
				</tr>
				
				<tr>
        	<td>City:-</td>
        	<td><input type="text" value="" disabled="disabled"></td>
        	<td>Cinema:-</td>
        	<td><input type="text" value="" disabled="disabled"></td>
        </tr>
      
        <tr>
        	<td>Movie:-</td>
        	<td><input type="text" value="" disabled="disabled"></td>
        	<td>Show:-</td>
        	<td><input type="text" value="" disabled="disabled"></td>
        </tr>
        <tr></tr>
        <tr><td colspan="2"></td>
        <td ><input type="submit" value="Buy"></td></tr>
        
        </table>								
 	</div>
			
			
			
										
  	</div>
  
  
  
        
  
</table>
</form>

</body>
</html>