<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to PK Bank</title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
		
		<div class="row">	
			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
				<div class="jumbotron">
				<h1 class="display-4">Welcome to PK Bank</h1>
				<p class="lead">
					Happiness = A Good Bank Account, A Good Cook and a Good Digestion -PK
				</p>
				
				<a href="user/new" class="btn btn-lg btn-success">Register Here</a>
				<p><br />Existing User: <a href="/user/login">Login Here</a>
				
				</div>
			</div>
		</div>
		
		<!-- Content Change Based On Device size -->
		<div class="row">
			<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
				<div class="card" style="height: 200px">
				
					<div class="card-header">Online Banking</div>
					<img src="<spring:url value='/resource/images/onlineBanking.png' s/>"
						class="card-img-top" alt="Online"/>	
					
					<div class="card-body">
						<p class="card-text">200+ Transactions via Netbanking</p>
					</div>			
				</div>
			</div>
			
			<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
				<div class="card" style="height: 200px">
					<div class="card-header">Phone Banking</div>
					<img src="<spring:url value='/resource/images/phoneBanking.png'/>"
						class="card-img-top" alt="Phone"/>	
					
					<div class="card-body">
						<p class="card-text">75+ Transactions on your Smartphone</p>
					</div>	
				</div>
			</div>
			
			
			<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
				<div class="card" style="height: 200px">
					<div class="card-header">Social Media</div>
				<img src="<spring:url value='/resource/images/SocialMedia.png'/>"
						class="card-img-top" alt="Social Media"/>	
					
					<div class="card-body">
						<p class="card-text">Social Media - Chatting, Sharing + Banking</p>
					</div>	
				</div>
			</div>
			
			
			<div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
				<div class="card" style="height: 200px">
					<div class="card-header">Watch</div>
					<img src="<spring:url value='/resource/images/Watch.jpg'/>"
						class="card-img-top" alt="Watch"/>	
					
					<div class="card-bodsy">
						<p class="card-text">Banking At the flick of a wrist now</p>
					</div>	
				</div>
			</div>
			
			
			
			
		</div>
	<%@ include file="footer.jsp" %>
	</div>

</body>
</html>
