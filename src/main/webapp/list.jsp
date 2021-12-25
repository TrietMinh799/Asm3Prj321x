<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
</head>

<body>
	<c:import url="header.jsp"></c:import>
	<div class="container mt-2 mb-2">
		<c:import url="search.jsp"></c:import>
		<div class="row">
			<c:forEach items="${ list }" var="item">
				<div class="card-deck col-md-4">
					<a
						href="${pageContext.servletContext.contextPath}/info?id=${item.id}"
						class="card mt-2 nav-link"> <img src="${item.src}"
						class="card-img-top mt-2" alt="${item.description}">
						<div class="card-body">
							<c:set var="type" value="${item.type}"></c:set>
							<h4 class="card-title text-secondary">${fn:toUpperCase(type)}</h4>
							<p class="card-text text-success">${item.name}</p>
							<p class="card-text text-danger">${item.price}</p>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
</body>

</html>