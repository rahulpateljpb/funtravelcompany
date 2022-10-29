<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">

<head>

<title>FUN TRAVEL FARE CALCULATION</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div>

		<div id="loginbox" style="margin-top: 50px;"
			class="mainbox col-md-8 col-md-offset-1 col-sm-8 col-sm-offset-2">

			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Calculate Cheapest Fare</div>
				</div>

				<div style="padding-top: 30px" class="panel-body">

					<!-- Login Form -->
					<form action="uploadCsv" method="POST"
						enctype="multipart/form-data" class="form-horizontal">
						<table>
							<tr>
								<td>
									<div style="margin-bottom: 25px" class="input-group">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <input type="text"
											name="driverName" placeholder="Enter Driver Name"
											class="form-control">
									</div>
								</td>
							</tr>
							<tr>
								<td><p align="center">
										<B>UPLOAD THE FILE</B></td>
							</tr>
							<tr>
								<td colspan="2"><b>Please upload CSV file here:</b></td>
								<td><INPUT NAME="file" accept=".csv" TYPE="file"></td>
							</tr>

							<tr>
								<td colspan="2">
									<div style="margin-top: 10px" class="form-group">
										<div class="col-sm-6 controls">
											<button type="submit" class="btn btn-success">
												Calculate Fare</button>
										</div>
									</div>
								</td>
							</tr>
						</table>
					</form>
					<table>
						<tr>Response: </tr>
						<tr>
							<td>Fare</td>
							<td>Total Distance</td>
							<td>Unit</td>
							<td>Cost per Unit</td>
						</tr>
						<tr>
							<td>${data.cheapestFare}</td>
							<td>${data.totalDistance}</td>
							<td>${data.distTravelUnit}</td>
							<td>${data.costPerDistTraveled}</td>
						</tr>
					</table>
					<c:if test="${not empty searchlist}">
						<c:forEach items="${searchlist}" var="lists">
       						${lists}
					</c:forEach>
					</c:if>
					<h></h>
				</div>
			</div>
		</div>
	</div>

</body>
</html>