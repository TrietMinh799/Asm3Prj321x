<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %> <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
  </head>

  <body>
    <c:import url="header.jsp"></c:import>
    <div>
      <p
        style="
          font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial,
            sans-serif;
        "
      >
        ${product.name}
      </p>
      <hr />
      <div>
        <form action="add" method="get" >
          <img
            alt="${product.description}"
            width="350"
            height="350"
            src="${product.src}"
          />
          <input name="id" value="${product.id}" type="hidden">
          <c:set var="type" value="${product.type}"></c:set>
          <input class="card-title text-secondary" type="hidden" value="${fn:toUpperCase(type)}" />
          <input type="hidden" value="${product.name}" class="card-text text-success">
          <p class="card-text text-danger">${product.price}</p>
          <input type="submit" name="action" value="Add"/>
        </form>
      </div>
    </div>
  </body>
</html>
