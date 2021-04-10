<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Idontifier-vous</title>
<style type="text/css">
		body{
			margin:0px;
			padding:0px;
		}
		*{
			font-family:monospace;
		}
		form{
			height:300px;
			width:300px;
			margin:100px auto;
		}
		.input{
			height:30px;
			width:200px;
			border-raduis:5px;
			outline:none;
			border-color:blue;
			margin-top:10px;
			border-top:none;
			border-right:none;
			border-left:none;
		}
		input[type="submit"]{
			border:none;
			background-color:blue;
			color:white;
			font-weight:bold;
		}
		.alert{
			color:red;
			font-size:10pt;
			font-weight:bold;
		}
		.err{
			font-size :13pt;
			margin:10px auto;
			color:red;
		}
</style>
</head>
<body>
	<form action="Identifier" method="POST">
			<h3 style="color:blue;">Identifier vous :</h3>
			<input type="text" name="email" placeholder="votre nom " class="input"/><br/>
			<input type="password" name="passwd" placeholder="votre mot de passe" class="input"/><br/>
			<input type="submit" value="connexion" class="input"/>
			<c:if test="${!empty message}">
					<p class="err">${message}</p>
			</c:if>
	</form>
</body>
</html>