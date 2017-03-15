<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
     
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Książki</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>	
	<jsp:include page="../views/fragments/header.jsp" />
	
	<div class="container">
		
		<h2>Lista książek "Chcę przeczytać"</h2>
		<spring:url value="/shelf/update" var="updateShelf"/>
				<form:form action="${updateShelf }" modelAttribute="bookOnShelf" >
		<table class="table table-hover">
			<tbody>
				<tr>
					<th><th>Tytuł</th><th>Autor</th><th>Wydawnictwo</th><th>Opis</th><th>Ma</th>
				</tr>
				<c:forEach items="${books}" var="bookOnShelf">
				<tr>
					<td><form:checkbox path="bookId" value="${bookOnShelf.book.bookId }"/>
					<td><a href="<spring:url value="/book/${bookOnShelf.book.bookId}"/>">${bookOnShelf.book.title }</a></td>
					<td>${bookOnShelf.book.author.firstName } ${bookOnShelf.book.author.surname}</td>
					<td>${bookOnShelf.book.publisher }</td>
					<td>${bookOnShelf.book.description }</td>
					<td>${bookOnShelf.owners }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<button type="submit" class="btn btn-default">Usuń z półki</button>
		</form:form>
	</div>

</body>
</html>