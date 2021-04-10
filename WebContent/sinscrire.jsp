<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%
    	String message = (String) request.getAttribute("message");
     %>
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
			width:400px;
			margin:100px auto;
		}
		.input{
			height:30px;
			width:300px;
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
		.maclass{
			font-size :13pt;
			margin:10px auto;
			color:red;
		}
		.err{
			font-weight:bold;
		    font-size:12pt;
			color:red;
		}
		.errCont{
			margin-left:center;
		}
</style>
</head>
<body>
	<%if(message!= null){ %>
		<div class="errCont">
			<p class="err"><%out.println(message); %></p>
		</div>
	<%} %>
	<form action="Inscrire" method="POST">
			<h3 style="color:blue;">S'inscrire :</h3>
			<input type="text" name="nom" placeholder="votre nom " class="input"/><br/>
			<input type="text" name="prenom" placeholder="votre prenom " class="input"/><br/>
			<input type="text" name="adresse" placeholder="votre adresse " class="input"/><br/>
			<input type="text" name="codePost" placeholder="votre Code Postal " class="input"/><br/>
			<input type="text" name="ville" placeholder="votre ville " class="input"/><br/>
			<input type="text" name="tel" placeholder="votre tel" class="input"/><br/>
			<input type="text" name="email" placeholder="votre email " class="input"/><br/>
			<input type="text" name="passwd" placeholder="votre mot de passe" class="input"/><br/>
			<input type="submit" value="save" class="input"/>
	</form>
	<li style="color:red; margin-left:100px;"> le mot de passe oblegatoire</li>
	<li style="color:red;margin-left:100px;"> Email erroné</li>
</body>
</html>