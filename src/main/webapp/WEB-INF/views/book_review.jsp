<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Książka - zatwierdź</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="../views/fragments/header.jsp" />
	 <div class="container">
	 	<div class="row">
	 		<h2>Jest ok?</h2>
	 		<div class="form-group">
	 			<label for=book-title>Tytuł</label> <span>${book.title}</span>
	 		</div>
	 			 		<div class="form-group">
	 			<label for=book-author>Autor</label> <span>${book.author.firstName} ${book.author.surname }</span>
	 		</div>
	 			 		<div class="form-group">
	 			<label for=book-publisher>Wydawnictwo</label> <span>${book.publisher}</span>
	 		</div>
	 			 		<div class="form-group">
	 			<label for=book-description>Opis</label> <span>${book.description}</span>
	 		</div>
	 		
	 		<a href="<spring:url value="/book/add"/>" class="btn btn-default">Zmień</a>
	 		
	 		<a href="<spring:url value="/book/save"/>" class="btn btn-default" >Zapisz</a>
	 		
	 	</div>
	 </div>
	 
	 
</body>
</html>