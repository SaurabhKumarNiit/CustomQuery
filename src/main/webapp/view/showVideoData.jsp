<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>

	<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
}

table {
	border-collapse: collapse;
	width: 60%;
	margin: 20px auto;
	background-color: #ffffff;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px 15px;
	text-align: left;
}

th {
	background-color: #333;
	color: white;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<table border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>AfterEffects</th>
			<th>AnimationType</th>
			<th>Budget</th>
			<th>Duration</th>
		
			<th>Email</th>
			<th>Frequency</th>
			<th>Genre</th>
			<th>VideoType</th>
			<th>Phone</th>
			<th>Platform</th>
			

		</tr>


	<c:forEach items="${obj}" var="candidate" varStatus="loop">
<tr>
				
			<td>${ candidate.getId()}</td>
			<td>${ 	candidate.getName()}</td>
			<td>${ 	candidate.getAfterEffects()}</td>
			<td>${ 	candidate.getAnimationType()}</td>
			<td>${ 	candidate.getBudget()}</td>
			<td>${ 	candidate.getDuration()}</td>
			<td>${ 	candidate.getEmail()}</td>
			<td>${ 	candidate.getFrequency()}</td>
			<td>${ 	candidate.getGenre()}</td>
			<td>${ 	candidate.getVideoType()}</td>
			<td>${ 	candidate.getPhone()}</td>
			<td>${ 	candidate.getPlatform()}</td>
		
			
		
		
			
			
			
			
			
			
			
			
			

			</tr>
	</c:forEach>


</body>
</html>