<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%> <!-- Tells us meta info, what language we're using.. etc.. we can add edits later. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="/js/script.js"></script>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<h1>Burger Tracker</h1>
<div class="card">
  <div class="card-body">
    <table class="table">
  <thead>
    <tr>
      <th scope="col">Burger Name</th>
      <th scope="col">Restaurant Name</th>
      <th scope="col">Rating (out of 5)</th>
      <th scope="col">Notes</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="burger" items="${allBurgers}">
    <tr>
      <th scope="row"><c:out value="${burger.burgerName}"></c:out></th>
      <th scope="row"><c:out value="${burger.restaurantName}"></c:out></th>
      <th scope="row"><c:out value="${burger.rating}"></c:out></th>
      <th scope="row"><c:out value="${burger.notes}"></c:out></th>
    </tr>
  </c:forEach>
  </tbody>
</table>
  </div>
</div>

<form:form action="/burgers/new" method="post" modelAttribute="burger">
	<div class="form-group">
    	<form:label path="burgerName">Burger Name</form:label>
    	<form:errors path="burgerName" />
    	<form:input type="text" class="form-control" path="burgerName" />
  	</div>
	<div class="form-group">
    	<form:label path="restaurantName">Restaurant Name</form:label>
    	<form:errors path="restaurantName" />
    	<form:input type="text" class="form-control" path="restaurantName" />
  	</div>
	<div class="form-group">
    	<form:label path="rating">Rating (out of 5)</form:label>
    	<form:errors path="rating" />	
    	<form:input type="number" class="form-control" path="rating"/>
  	</div>
  	<div class="form-group">
	    <form:label path="notes">Notes</form:label>
	    <form:errors path="notes" />
	    <form:textarea class="form-control" path="notes" rows="3"></form:textarea>
  	</div>
  	<input type="submit" value="submit"/>	
</form:form>
	



</body>
</html>