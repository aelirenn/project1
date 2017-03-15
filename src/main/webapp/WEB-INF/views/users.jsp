<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Użytkownicy</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>	
	<jsp:include page="../views/fragments/header.jsp" />
		<div class=container">
			<table class="table table-hover">
			<tbody>
				<tr>
					<th></th><th></th><th></th><th></th><th></th>
				</tr>
				<c:forEach items="${userShelfs}" var="userShelfs">
				<tr>
					<td>${userShelfs.userName } </td>
					<td><a href="<spring:url value="/shelf/${userShelfs.myShelfId}"/>">Ma</a></td>
					<td><a href="<spring:url value="/shelf/${userShelfs.toReadShelfId}"/>">Chce przeczytać</a></td>
					<td><a href="<spring:url value="/shelf/${userShelfs.toBuyShelfId}"/>">Chce kupić</a></td>
					<td><a href="<spring:url value="/shelf/${userShelfs.borrowedShelfId}"/>">Pożycza</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	
</body>
</html>