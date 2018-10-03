<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Entry Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
 integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="/RealEstate">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/RealEstate/aboutus">About Us</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/RealEstate/contactus">Contact Us</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="/RealEstate/cart">My Cart</a>
      </li>
    </ul>
  </div>
</nav>
<form:form modelAttribute="order" method="post" action="/RealEstate/submititem">    
<table style="border: 1px solid black; width: 100%;">
<tr><th>Item Name</th><th>Item Price</th><th>Quantity</th></tr>
<c:forEach items="${order.itemList}" var="item" varStatus="loop">
<tr>
<td><form:input path="itemList[${loop.index}].itemName" readonly="true"/></td>
<td><form:input path="itemList[${loop.index}].price" readonly="true"/></td>
<td><form:input path="itemList[${loop.index}].quantity" /></td>
</tr>
</c:forEach>  
<tr>
<td colspan="2"><input type="submit" value="Purchase"></td>  
</tr>    
</table>
</form:form>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>