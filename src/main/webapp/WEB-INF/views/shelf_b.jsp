<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Półka</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>	
	<jsp:include page="../views/fragments/header.jsp" />
	
	<div class="container">
		
		<h2>${info }</h2>
		
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Tytuł</th><th>Autor</th><th>Wydawnictwo</th><th>Właściciel</th><th>Pożyczono</th>
				</tr>
				
				<c:forEach items="${books}" var="borrowedBook">
				<tr>
					<td><a href="<spring:url value="/book/${borrowedBook.book.bookId}"/>">${borrowedBook.book.title }</a></td>
					<td>${borrowedBook.book.author.firstName } ${borrowedBook.book.author.surname}</td>
					<td>${borrowedBook.book.publisher }</td>
					<td>${borrowedBook.owner }</td>
					<td>${borrowedBook.borrower }</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>

</body>
</html>