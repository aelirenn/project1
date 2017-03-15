<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="navbar navbar-inverse navbar-static-top">
<script src="<c:url value="/resources/js/global.js"/>"></script>
				<div class="navbar-header">
				<a href="<spring:url value="/"/>" class="navbar-brand">Książkolektyw</a>
			</div>
	
	<ul class="nav navbar-nav">
		<li class="dropdown">
			<a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button"
				aria-expanded="false">Książki <span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
			<li><a href="<spring:url value="/book/add"/>">Dodaj</a></li>
			<li><a href="<spring:url value="/book/find"/>">Znajdź</a></li>
		</ul>
		</li>
		<li><a href="<spring:url value="/users/shelfs"/>">Użytkownicy</a></li>		
		
		<sec:authorize access="authenticated" var="authenticated" />
		
		
		<c:choose>
			<c:when test="${authenticated }" >
			<li class="dropdown">
			<a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button"
				aria-expanded="false">Moje półki <span class="caret"></span></a>
		<ul class="dropdown-menu" role="menu">
			<li><a href="<spring:url value="/shelf/my"/>">Moje książki</a></li>
			<li><a href="<spring:url value="/shelf/toread"/>">Chcę przeczytać</a></li>
			<li><a href="<spring:url value="/shelf/tobuy"/>">Chcę kupić</a></li>
			<li><a href="<spring:url value="/shelf/borrowed"/>">Pożyczone</a></li>
		</ul>
		</li>
			<li>
				<p class="navbar-text">
			<sec:authentication property="name"  />
			<a id="logout" href="#"> Wyloguj się</a>
			</p>
			<form id="logout-form" action="<c:url value="/logout"/>" method="post">
			<sec:csrfInput /></form>
			</li>
			</c:when>
			<c:otherwise>
					<li><a href="<spring:url value="/login"/>">Logowanie</a></li>	
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
