<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
		
	<form action="upload" method="post" enctype="multipart/form-data">


		name<input type="text" name="name"> </br>
		Select File to thumbnail :<input type="file" name="thumbnail"> </br>
		 Select File to video :<input type="file" name="video"> </br>



		<button type="submit" class="btn btn-primary">Submit</button>
		
		</br>
		<button type="button">
			<a href="addmin">add Admin</a>
		</button>
		
			
		<button type="button">
			<a href="videoD">video data</a>
		</button>
	</form>






</body>
</html>