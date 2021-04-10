<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello Page </title>
<style type="text/css">
	body{
		margin:0px;
		padding:0px;
	}
	*{
		font-family:monospace;
	}
	.contenu{
		margin:100px auto;
		display:flex;
		justify-content:center;
		align-items:center;
		height:320px;
		width:400px;
		border:solid 2px blue;
	}
	.btn{
		height:40px;
		width:240px;
		border:none;
		border-raduis:10px;
		font-size:13pt;
		background-color:blue;
		outline:none;
		color:white;
		margin-top:20px;
		cursor:pointer;
	}
	.title{
		font-weight:bold;
		color:#993366;
		font-size:14pt;
	}
	#id1{
		margin-top:20px;
		text-decoration:none;
		height:40px;
		width:240px;
		background-color:blue;
		display:flex;
		justify-content:center;
		align-items:center;
		font-size:13pt;
	}
	a{
		text-decoration:none;
		color:white;
	}
</style>
</head>
<body>
<div class="contenu">
	<div>
		<c:if test="${!empty sessionScope.Name}">
			<h3 class="title">Bonjour Monsieur : ${sessionScope.Name }</h3>
		</c:if>
		<form action="catalogue" method="POST">
			<input type="submit" value="consulter le catalogue" class="btn"/><br/>
		</form>
		<!--<input type="submit" value="Suivre vos commandes" class="btn" /><br/> -->
		<div id="id1"><a href="showDemandes.jsp">suivre vos commandes</a></div>
		<input type="submit" value="Visualiser votre panier" class="btn"/><br/>
	</div>
</div>
</body>
</html>