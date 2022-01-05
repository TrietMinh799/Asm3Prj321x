<%@page import="model.Product"%> <%@page import="model.Cart"%> <%@ page
language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Insert title here</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
  </head>
  <body>
    <c:import url="header.jsp"></c:import>
    <div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Products in cart: ${cart.getItems().size()}</th>
            <th scope="col">Price</th>
            <th scope="col">Quanity</th>
            <th scope="col">Amount</th>
          </tr>
        </thead>
        <tbody>
          <c:if test="${cart.getItems().size()} == 0">
            <tr>
              <td>No products in carts</td>
            </tr>
          </c:if>

          <c:forEach var="items" items="${cart.getItems()}">
            <tr>
              <th scope="row">
                <p>${items.getName()}</p>
                <br />
                <p>${items.getId()}</p>
              </th>
              <td>$ ${items.getPrice()}</td>
              <td></td>
            </tr>
          </c:forEach>
          <tr>
            <th scope="row">Total ${cart.getAmount()}</th>
          </tr>
        </tbody>
      </table>
    </div>
    <div>
      <form action="pay" method="post">
        <label for="name"
          >Username
          <input id="name" name="name" type="text" />
        </label>

        <label for="address"
          >Address
          <input id="address" type="text" name="address" />
        </label>

        <label for="discount"
          >Discount
          <input id="discount" name="discount" type="text" />
        </label>

        <button type="submit">Add To cart</button>
      </form>
    </div>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
