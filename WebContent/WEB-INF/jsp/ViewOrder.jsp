<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  
<table style="border: 1px solid black; width: 100%;">
<tr><th>Item Name</th><th>Item Price</th><th>Quantity</th></tr>
<c:forEach items="${order.itemList}" var="item">
    <tr>
    <td><c:out value="${itemList.itemName}"></c:out></td>
    <td><c:out value="${item.price}"></c:out></td>
    <td><c:out value="${item.quantity}"></c:out></td>
    </tr>
</c:forEach>
</table>
</body>
</html>
