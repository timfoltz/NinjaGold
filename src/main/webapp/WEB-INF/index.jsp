<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/goldStyle.css">
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
</head>
<body>
	<h1>Your Gold: <c:out value="${myGold}"></c:out> </h1>
	<div class="wrapper">
	
		<div>
		<h3>Farm</h3>
		<p>(earns 10-20 gold)</p>
			<form action="/findGold" 
				method="post">
				<input 
					type="submit" 
					name="farm" 
					value="Find Gold">
					<input type="hidden" name="place" value="farm">
				</form>
		</div>
		
		<div>
		<h3>Cave</h3>
		<p>(earns 5-10 gold)</p>
			<form action="/findGold" 
			method="post">
			<input type="submit" name="cave" value="Find Gold">
			<input type="hidden" name="place" value="cave"> 
			</form>
		</div>
		
		<div>
		<h3>House</h3>
		<p>(earns 2-5 gold)</p>	
			<form action="/findGold" 
			method="post">
			<input type="hidden" name="place" value="house">
			<input type="submit" name="house" value="Find Gold"> </form>
		</div>
		
		<div>
		<h3>Casino!</h3>
		<p>(earns or looses 0-50 gold)</p>	
			<form action="/findGold" method="post">
			<input type="hidden" name="place" value="casino">
			<input type="submit" name="casino" value="Find Gold"> </form>
		</div>
		
	</div>
	<br>
	<br>
	<br>

	<textarea rows="10" cols="50" not><c:out value="${activities}"></c:out></textarea>
	<br>
	<br>
	<a href="/reset">reset</a>
</body>
</html>