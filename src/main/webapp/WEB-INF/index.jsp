<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">

<title>Movie Database Dashboard</title>
</head>
<body>
	<div class="container">
		<form:label path="user"><h1>Welcome, ${ user.name }!</h1></form:label>
		
		<a href="/logout">Log Out</a>
		
		<h3>Movies</h3>
		
		<table class ="table table-hover table-striped">
			<thead>
				<tr>
					<th>Movie</th>
					<th>Studio</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items ="${ allMovies }" var = "movie">
					<tr>
						<td><a href="/movies/${ movie.id }">${ movie.title }</a></td>
						<td>${ movie.studio }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a class="homeSubmit" href="/movies/new">Add a movie</a>
	</div>
</body>
</html>