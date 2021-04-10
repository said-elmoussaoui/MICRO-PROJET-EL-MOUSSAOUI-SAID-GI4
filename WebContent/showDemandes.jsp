<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes Demandes</title>
<style type="text/css">
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
</style>
</head>
<body>
	<sql:setDataSource var="db"  url="jdbc:mysql://localhost/db_project"  user="root"/>
     <sql:query dataSource="${db}" var="articles">
            select lignecommandes.NumCommande,titre,QteCde,DateCommande from commandes,lignecommandes,articles where commandes.NumCommande = lignecommandes.NumCommande and lignecommandes.CodeArticle = articles.CodeArticle and CodeClient = ${sessionScope.id }
     </sql:query>
     <table>
     	<tr>
     		<th>Id de commande</th>
     		<th>Titre de l'article</th>
     		<th>Qte</th>
     		<th>Date de la commande</th>
     	</tr>
     	<c:forEach items="${articles.rows}" var="table"> 
     		<tr>
     			<td><c:out value="${table.NumCommande }"/></td>
     			<td><c:out value="${table.titre}"/></td>
     			<td><c:out value="${table.QteCde}"/></td>
     			<td><c:out value="${table.DateCommande }" /></td>
     		</tr>
     	</c:forEach>
     </table>
</body>
</html>