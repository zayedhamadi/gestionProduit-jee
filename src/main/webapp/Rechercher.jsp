<%@page import="modele.produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<% List<produit> R=(List<produit>) request.getAttribute("resultat"); %>
<title>Insert title here</title>
</head>
<body>
<form action="chercher.dao" method="post">
<label>rechercher</label>
<input type="text" name="rechercher">
<button type="submit">Rechercher</button>
</form>
</body>
</html>