<%@ page language="java" contentType="text/html; UTF-8"
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
	<jsp:include page ="../views/fragments/header.jsp" />
	
	<div class="container">
	<spring:url value="/book/borrow" var="borrowBook"/>
	<form:form action="${borrowBook }" method="post" class="col-md-8 col-md-offset-2" modelAttribute="borrowedBook">
		<div class="row">
			<div class="form-group">
				<label for="book_title">Tytuł</label>
				<span>${book.title}</span>
			</div>
			<div class="form-group">
				<label for="book_author">Autor</label>
				<span>${book.author.firstName } ${book.author.surname}</span>
			</div>
				<div class="form-group">
				<label for="book_publisher">Wydawnictwo</label>
				<span>${book.publisher}</span>
			</div>
			<div class="form-group">
				<label for="book_description">Opis</label>
				<span>${book.description }</span>
			</div>
		</div>
		
		<div class="container">
			
				<div class="form-group">
					<label for="userId">Pożycz</label>
					<form:select path="userId" cssClass="selectpicker" items="${users}" />

				
				</div>
				<button type="submit" class="btn btn-default">Pożycz</button>
				
			</div>
			</form:form>
		
		
	</div>


</body>
</html>