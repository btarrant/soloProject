<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="UTF-8">

<title>Edit Movie</title>
</head>
<body>
	<div class="container">
		<h1>${ movie.title }</h1>

		<form:form action="/movies/${ movie.id }/update" method="POST"
			modelAttribute="editMovie">
			<input type="hidden" name="_method" value="put" />
			
			<div class="row">
				<form:label path="title" class="form-label">Title:</form:label>
				<form:input path="title" class="form-control"
					value="${ movie.title }" type="text" />
				<form:errors path="title" class="text-danger" />
			</div>
			<div class="row">
				<form:label path="studio" class="form-label">Studio:</form:label>
				<form:input path="studio" class="form-control"
					value="${ movie.studio }" type="text" />
				<form:errors path="studio" class="text-danger" />
			</div>
			<div class="row">
				<form:label path="description" class="form-label">Description:</form:label>
				<form:input id="desc" path="description" class="form-control"
					value="${ movie.description }" type="text" />
				<form:errors path="description" class="text-danger" />
			</div>
			<a href="/home">Cancel</a>
			<input class="btn btn-primary" type="submit" value="Submit" />
		</form:form>

		<form action="/movies/${ movie.id }/destroy" method="POST">
			<input type="hidden" name="_method" value="delete"> <input
				type="submit" value="Delete">
		</form>
	</div>
</body>
</html>