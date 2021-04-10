<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<style type="text/css">
		body{
		margin:0px;
		padding:0px;
		}
		*{
		font-family:monospace;
		}
		.all{
		    height:200px;
		    width:500px;
			margin:10px auto;
		}
		.btn{
			display:flex;
			justify-content:space-around;
			align-itmes:center;
		}
		a{
			text-decoration:none;
			border:solid 1px blue;
			height:30px;
			width:200px;
			display:flex;
			justify-content:center;
			align-itmes:center;
			background-color:blue;
			color:white;
			font-weight:bold;
			margin-top:20px;
		}
		.title{
			font-weight:bold;
			color:#993366;
			font-size:14pt;
		}
		.choice{
			outline : none;
			height:40px;
			width:100px;
			border-color:blue;
		}
</style>
</head>
<body>
	<fmt:setLocale value="${param.lang}" scope="session"/>
	<c:set var="lang_choise" value="${param.lang}"/>
	<fmt:setBundle basename="langue.fichier" />
	<form class="all">
		<select name="lang" onChange="submit()" class="choice">
			<option value="fr"  ${lang_choise == 'fr' ? 'selected':'' }>Français</option>
			<option value="en"  ${lang_choise == 'en' ? 'selected':'' }>Anglais</option>
		</select>
	</form>
   <div class="all">
		<h3 class="title"><fmt:message key="msg1"/></h3>
		<div classs="btn">
				<a href="Identifier.jsp"><fmt:message key="msg2"/></a>
				<a href="sinscrire.jsp"><fmt:message key="msg3"/></a>
		</div>
	</div>
</body>
</html>