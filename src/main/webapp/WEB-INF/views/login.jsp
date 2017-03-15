<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KsiążKolektyw</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest Jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"
	type="text/javascript"></script>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="../views/fragments/header.jsp" />
	<div class="container">
		<div class="row">
			<h1>Zaloguj się</h1>
		</div>
		<c:url value="/login" var="loginVar"/>
		<form id="appointment-form" action="${loginVar}" method="POST">
			<div class="form-group">
				<label for="make">Login</label>
				<input name="custom_username" class="form-control" />
			</div>
			<div class="form-group">
				<label for="model">Hasło</label>
				<input type="password" name="custom_password" class="form-control" />
			</div>
			<sec:csrfInput/>
			<c:if test="${param.error !=null }">
				<p>Błędny login lub hasło</p>
				</c:if>
			<button type="submit" id="btn-save" class="btn btn-primary">Login</button>
		</form>
	</div>
</body>
</html>