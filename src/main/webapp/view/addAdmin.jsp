<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/addAdmin" method="post">

		<input type="text" name="name"> <input type="text"
			name="email"> <input type="text" name="phoneNo"> <input
			type="password" name="password">

		<button type="submit">Register</button>

		<button type="button">
			<a href="Login">Login</a>
		</button>
	</form>

</body>
</html>