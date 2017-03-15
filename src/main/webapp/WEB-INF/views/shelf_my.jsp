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
		
		<h2>Moje książki</h2>
		<spring:url value="/shelf/update" var="updateShelf"/>
				<form:form action="${updateShelf }" modelAttribute="book" >
		<table class="table table-hover">
			<tbody>
				<tr>
					<th>Tytuł</th><th>Autor</th><th>Wydawnictwo</th><th>Opis</th>
				</tr>
				
				<c:forEach items="${books}" var="book">
				<tr>
					<td><form:checkbox path="bookId" value="${book.bookId }"/>
					<td><a href="<spring:url value="/book/${book.bookId}/borrow"/>">${book.title }</a></td>
					<td>${book.author.firstName } ${book.author.surname}</td>
					<td>${book.publisher }</td>
					<td>${book.description }</td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
	<button type="submit" class="btn btn-default">Usuń z półki</button>
	</form:form>
	</div>

</body>
</html>