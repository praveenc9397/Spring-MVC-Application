<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PS Bank Account Holder Details</title>
</head>
<body>

	

	<div class="Container">
		<%@ include file="header.jsp" %>
		
		<div class="row">
			<div class="col-12">
				<a href="<c:url value='/new'/>" class="btn btn-lg btn-primary">Add New Account</a>
			</div>
		
		</div>
		
	<div class="row">
	<div class="col-12">
	
	<table class="table table-bordered table-hover">
		<thead class="bg-success">
			<tr>
				<th><spring:message code="lbl.accountNo" /></th>
				<th><spring:message code="lbl.accountHolderName" /></th>
				<th><spring:message code="lbl.balance" /></th>
				<!-- No need of any haeding for update link so use &nbsp to provide blank space -->
				<th> &nbsp; </th>
				<th> &nbsp; </th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="account" items="${accounts}">
				<!-- Creating URL To updating data -->
				<c:url var="updateLink" value="/edit">
					<c:param name="accountNo" value="${account.accountNo}"/>
				</c:url>
				
				<!-- URL For deleting Records -->
				<c:url var="deleteLink" value="/delete">
					<c:param name="accountNo" value="${account.accountNo}"/>
				</c:url>
				
				
				
				<tr>
					<td>${account.accountNo} </td>
					<td>${account.accountHolderName} </td>
					<td>${account.balance} </td>
					<!-- Whenever user click's on Edit link user navigate to /edit URL: For this you should have entry in controller class--> 
					<td><a href="${updateLink}" class="btn btn-warning">Edit</a></td>
					<td><a href="${deleteLink}" class="btn btn-danger" onClick="if(!(confirm('Are you sure to delete'))) return false">Delete</a></td>
				</tr>
			</c:forEach>
		
		</tbody>
	</table>
	</div>
	</div>
	
	<%@ include file="footer.jsp" %>
	</div>
</body>
</html>
