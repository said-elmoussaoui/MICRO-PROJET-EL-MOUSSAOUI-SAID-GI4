<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.body{
		margin:0px;
		padding:0px;
	}
	*{
		font-family:monospace;
		font-size:12pt;
	}
	.image{
		height:100px;
		width:100px;
		border-radius:100px;
	}
	.contenu{
		margin:100px auto;
		display:flex;
		justify-content:center;
		align-items:center;
		height:400px;
		width:500px;
	}
	.title{
		font-weight:bold;
		color:#993366;
		font-size:14pt;
	}
	.inpText{
		height:25px;
		width:150px;
		outline:none;
	}
	.div1{
		display:flex;
		justify-content:space-around;
		align-items:center;
		margin:20px;
	}
	.div2{
		display:flex;
		justify-content:space-between;
		align-items:center;
		margin:20px;
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
	.inpText{
			height:30px;
			width:200px;
			border-raduis:5px;
			outline:none;
			border-color:blue;
			margin-bottom:10px;
			border-top:none;
			border-right:none;
			border-left:none;
	}
	.div22{
		margin-left:60px;
	}
	li{
		font-weight:bold;
		color:#993366;
	}
	.err{
		font-family:monospace;
		font-size:12pt;
		color:red;
		margin-left:50px;
		font-weight:bold;
	}
</style>
</head>
<body>
	<div class="contenu">
		<form action="demandeArticle" method="POST">
			<h2 class="title">Informations sur l'article :</h2>
			<div class="div1">
				<img src="images/${articleDet.photo}" class="image" />
				<input type="text" value="${articleDet.id }" class="inpText"  name="idArt" readonly/>
			</div>
			<div class="div2">
				<div class="div21">
					<li>titre:</li> <input type="text" value="${articleDet.titre }" class="inpText" readonly /><br/>
					<li>prix: </li><input type="text" value="${articleDet.prix }" class="inpText" /><br/>
					<li>stock:</li> <input type="text" value="${articleDet.stock }" class="inpText" name="stock" readonly /><br/>
				</div>
				<div class="div22">
					<li>categorie:</li> <input type="text" value="${articleDet.categorie}" class="inpText" /><br/>
					<li>auteur:</li> <input type="text" value="${articleDet.auteur }" class="inpText" /><br/>
					<li>Votre Email : </li> <input type="text" value="${sessionScope.email}" class="inpText" name="email" readonly/>
				</div>
			</div>
			<div class="div3">
					<input type="text" placeholder="nombre d'article" name="qte" class="inpText" />
					<input type="submit" value="demander" class="input" />
			</div>
			<c:if test="${!empty articleDet.message}">
					<h3 class="err">${articleDet.message }</h3>
		    </c:if>
		</form>
	</div>
</body>
</html>