<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver Data Registration Successful</title>
</head>
<body>
	Driver Registration is successful
	<br> Following are the details:
	<br>
	<table>
		<tr>
			<td>Driver Name</td>
			<td>${driver.dName}</td>
		</tr>
		<tr>
			<td>Driver : </td>
			<td>${driver.dSurname}</td>
		</tr>
		<tr>
			<td>Driver SurName : </td>
			<td>${driver.driverId}</td>
		</tr>
		<tr>
			<td>Driver Email ID :</td>
			<td>${driver.dEmail}</td>
		</tr>
		<tr>
			<td>Driver Vehicle Type : </td>
			<td>${driver.dVehicleType}</td>
		</tr>
		<tr>
			<td>Base Fare Price : </td>
			<td>${driver.baseFarePrice}</td>
		</tr>
		<tr>
			<td>Base Fare Distance : </td>
			<td>${driver.bfDistance}</td>
		</tr>
		
	</table>
</body>
</html>