<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <!-- Instead of HTML to use spring framework Tags for views -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<!--  To use Spring Messagging Tags -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<!-- Using Spring Tittle Tag -->
<title><spring:message code="lbl.title" />   </title>
</head>
<body>
	<h2>PS : Bank Account Details </h2>
	
	 <!-- Reading Field values from properties files instead of hard coding -->
	 <p><spring:message code="lbl.accountNo" /> : ${account.accountNo} </p>
	<p><spring:message code="lbl.accountHolderName" />: ${account.accountHolderName} </p>
	<p><spring:message code="lbl.balance" /> : ${account.balance}
	<p><spring:message code="lbl.accountType" /> : ${account.accountType}
	<p><spring:message code="lbl.dateOfBirth" /> : ${account.dateOfBirth}
	<p><spring:message code="lbl.psCode" /> : ${account.psCode}
	 

	
</body>
</html>


    
