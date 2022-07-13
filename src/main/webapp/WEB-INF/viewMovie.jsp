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

<title>View Movie</title>
</head>
<body>
	<div class="container">
		<h1>${ movie.title }</h1>
			
				<p>Posted by: ${ movie.user.name }</p>
				<p>Studio : ${ movie.studio }</p>
				<p>Description: ${ movie.description }</p>	
		
		<div>
			<a href="/movies/${ movie.id }/edit">Edit</a>
		</div>
	</div>
</body>
</html>