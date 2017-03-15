<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>KsiążKolektyw</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
	<script src="<spring:url value="/resources/js/info.js"/>"></script>
</head>
<body>
	<jsp:include page ="../views/fragments/header.jsp" />
	<div class="container-fluid text-center"> 
	
	<div class="col-sm-6 text-left">
	<spring:url value="/book/addtoshelf" var="chooseShelf"/>
	<form:form action="${chooseShelf }" method="post" class="col-md-8 col-md-offset-2" modelAttribute="bookOnShelf" >
	
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
		<sec:authorize access="authenticated" var="authenticated" />
		<c:choose>
		<c:when test="${authenticated }" >
			
				<div class="form-group">
					<label for="shelfId">Dodaj na półkę</label>
					<form:select path="shelfId" cssClass="selectpicker" items="${shelfs}" />

				
				</div>
				<button type="submit" class="btn btn-default">Dodaj</button>
				</c:when>
				</c:choose>
		</div>
		
		</form:form>
		
	
	</div>
	<div id="info" class="col-sm-6 text-left">${info }</div>
</div>
</body>
</html>