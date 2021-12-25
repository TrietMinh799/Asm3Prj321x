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
</head>
<body>

<c:import url="header.jsp"></c:import>
<div>
	<p style="">${product.name}</p>
	<hr />
	<div>
		<img alt="${product.description}" width="350" height="350" src="${product.src}" />
		<c:set var="type" value="${product.type}"></c:set>
		<h4 class="card-title text-secondary">${fn:toUpperCase(type)}</h4>
		<p class="card-text text-success">${product.name}</p>
		<p class="card-text text-danger">${product.price}</p>
	</div>
</div>

</body>
</html>