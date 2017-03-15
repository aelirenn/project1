<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>KsiążKolektyw</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>

</head>
<body>
	
	<jsp:include page="../views/fragments/header.jsp"></jsp:include>
	<h3>Dodaj książkę</h3>
	<div class="container">
		<div class="row">
			<spring:url value="/book/add/preview" var="reviewBook"/>
			<form:form action="${reviewBook }" method="post" class="col-md-8 col-md-offset-2" modelAttribute="book">
				<div class="form-group">
					<label for="book-title">Tytuł</label>
					<form:input path="title" cssClass="form-control" id="book-title"/>
				</div>
				<label for="author">Autor</label>
				<div class="form-group">
					<label for="book-author-firstname">Imię</label>
					<form:input path="author.firstName" cssClass="form-control" id="book-author-firstname" />
				</div>
				<div class="form-group">
					<label for="book-author-surname">Nazwisko</label>
					<form:input path="author.surname" cssClass="form-control" id="book-author-surname" />
				</div>
				<div class="form-group">
					<label for="book-publisher">Wydawnictwo</label>
					<form:input path="publisher" cssClass="form-control" id="book-publisher" />
				</div>
				
				
				<div class="form-group">
					<label for="book-description">Krótki opis</label>
					<textarea class="form-control" rows="3" name="description"></textarea>
				</div>
				
			
				<button type="submit" class="btn btn-default">Dodaj</button>
			
			</form:form>
		
		</div>
		
	</div>

</body>
</html>