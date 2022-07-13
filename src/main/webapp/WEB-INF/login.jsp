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

<title>Movies Database</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Register</h1>
				<form:form action="/register" method="POST"
					modelAttribute="newUser">

					<form:label path="name">Name:</form:label>
					<form:input class="input" path="name" />
					<form:errors path="name" class="text-danger" />

					<form:label path="email">Email:</form:label>
					<form:input type="email" class="input" path="email" />
					<form:errors path="email" class="text-danger" />

					<form:label path="password">Password:</form:label>
					<form:input type="password" class="input" path="password" />
					<form:errors path="password" class="text-danger" />

					<form:label path="confirm">Confirm Password:</form:label>
					<form:input type="password" class="input" path="confirm" />
					<form:errors path="confirm" class="text-danger" />
				
					<input type="submit" value="Register" />
					
				</form:form>


			</div>
			<div class="col-6">
				<h1>Log In</h1>
				<form:form action="/login" method="POST"
					modelAttribute="newLogin">

					<form:label path="email">Email:</form:label>
					<form:input type="email" class="input" path="email" />
					<form:errors path="email" class="text-danger" />

					<form:label path="password">Password:</form:label>
					<form:input type="password" class="input" path="password" />
					<form:errors path="password" class="text-danger" />
					
					<input type="submit" value="Log In" />
					
				</form:form>

			</div>
		</div>
	</div>

</body>
</html>