<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogue des Articles disponibles</title>
<style type="text/css">
body{
	margin:0px;
	padding:0px;
}
.image{
	height:100px;
	width:100px;
	border-radius:100px;
}
table {
margin-top:20px;
border: medium solid #6495ed;
border-collapse: collapse;
width: 50%;
margin-left:40px;
}
th {
font-family: monospace;
border: thin solid #6495ed;
width: 30%;
padding: 5px;
background-color: #D0E3FA;
background-image: url(images/sky.jpg);
}
td {
font-family: sans-serif;
border: thin solid #6495ed;
width: 50%;
padding: 5px;
text-align: center;
background-color: #ffffff;
}
caption {
font-family: sans-serif;
}
.add{
	margin-left:100px;
}
*{
	font-size:12pt;
	font-family:monospace;
}
.option{
	outline : none;
	height:40px;
	width:100px;
	border-color:blue;
}
.header{
	margin-left:100px;
	margin-top:30px;
}
.input{
           height:40px;
			width:120px;
			border-raduis:5px;
			outline:none;
			margin-top:10px;
			border:none;
			background-color:blue;
			color:white;
			font-weight:bold;
}
.btn{
	color:blue;
	outline:none;
	border:none;
	background-color:white;
	text-decoration:underline;
}
.dmd{
	height:40px;
	width:120px;
	color:white;
	outline:none;
	background-color:blue;
	border:none;
}
.cont{
	display:flex;
	align-items:center;
}
#option2{
margin-left:100px;
width:130px;
}
.input1{
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
</style>
</head>
<body>
<fmt:setLocale value="${param.typeM }" scope="session"/>
<c:set var="devise" value="${param.typeM }" />
<div class="cont">
	<form action="catalogue" method="POST" class="header">
		<select class="option" name="option" name="categorie">
			<c:forEach items="${modele.categories}" var="c">
				<option>${c}</option>
			</c:forEach>
		</select>
		<input type="submit" value="chercher"  class="input" />
	</form>
	<form>
			<select class="option" name="typeM" id="option2" onChange="submit()">
				<option value="dr" ${devise == 'dr' ? 'selected' : ''}>DIRHAM(MAROC)</option>
				<option value="dl" ${devise == 'dl' ? 'selected' : '' }>DOLLAR(USA)</option>
			</select>
	</form>
</div>
<table>
   <tr>
       <th>id</th>
       <th>titre</th>
       <th>auteur</th>
       <th>Photo</th>
       <th>Prix</th>
       <th>lien</th>
   </tr>
 <c:forEach items="${modele.articles}" var="p"> 
	    <tr>
	    	<td>
	    		<form action="Details" method="POST">
  					<input type="submit" value="${p.id}" class="btn" name="toDeta" />
  				</form>
	    	</td>
	    	<td>${p.titre }</td>
	    	<td>${p.auteur }</td>
	    	<td><img src="images/${p.photo }" class="image"/></td>
	    	<td>${devise == 'dl' ? (p.prix/10) : p.prix }</td>
	    	<td>
	    		<input type="button" value="DEMANDER" class="dmd" name="demande" onClick="fun()"/>
	    	</td>
	    </tr>
  </c:forEach> 
 </table>
</body>
</html>