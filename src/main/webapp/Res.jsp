
<%@page import="java.util.List"%>
<%@page import="modele.produit"%>
<%@page import="dao.GestionProduit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>
	.table {
		margin-bottom: 0;
		background-color: white;
	}

	.table thead th {
		vertical-align: middle;
	}

	.table tbody td {
		vertical-align: middle;
	}

	.btn {
		padding: 0.375rem 0.75rem;
	}
</style>

	
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous" />

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<%
List<produit> R = (List<produit>) request.getAttribute("res");
%>
<title>Consult Products</title>
</head>
<body style="background-color: #f5f5f5;">

	<div class="container-fluid" style="margin-top: 50px;">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href=""><b>Menu </b></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<!--  	<li class="nav-item flow-d">
							<form action="MyServlet" method="get">
								<button type="submit" class=" btn btn-danger rounded-pill">Logout</button>
							</form>
						</li> -->
						&nbsp;&nbsp;
						<li class="nav-item">
							<form action="">
								<a href="AjoutProduit.html"
									class="btn btn-outline-warning  rounded-pill" style="width: 115px;">
									Add Product</a>
							</form>
						</li>
						<li class="nav-item">
							<form action="chercher.dao" role="search" method="post"
								class="container-fluid d-flex" style="width: 115px">
								<input type="text" placeholder="Search by Product Name"
									class="form-control mr-sm-2 " style="width: 300px;"
									name="rechercher" />&nbsp;
								<button type="submit"
									class="btn btn-outline-success my-2 my-sm-0 rounded-pill">Searching</button>
							</form>
						</li>

					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<form action="MyServlet" method="get">
								<button type="submit"
									class="btn btn-outline-danger rounded-pill active">
									<i class="fa fa-sign-out" aria-hidden="true"></i> Logout
								</button>
							</form>
						</li>
					</ul>

				</div>
			</div>
		</nav>

		<hr>
		<!-- <a href="Rechercher.jsp">Rechercher</a> -->
		<div style="background-color: #dcdcdc;"
    class="shadow p-3 mb-5  rounded text-center">
    <h4>
        <b> Product List</b>
        <hr style="color: black; border-top: 1px solid black;">
    </h4>
</div>

		<hr>
<table class="table table-bordered table-hover">
<thead class="bg-light">
	<tr>
		<th>Reference of the product</th>
		<th>Name of the product</th>
		<th>Price</th>
		<th>Fournisseur</th>
		<th>Delete</th>
		<th>Modify</th>
	</tr>
</thead>
<tbody>
	<%
	for (produit produit : (List<produit>) request.getAttribute("res")) {
	%>
	<tr>
		<td><%=produit.getIdp()%></td>
		<td><%=produit.getNomP()%></td>
		<td><%=produit.getPrix()%> DT</td>
		<td><%=produit.getFournisseur()%></td>
		<td>
			<form method="post" action="supprimer.dao" onsubmit="return confirm('Are you sure you want to delete this product?');">
				<input type="hidden" name="id" value="<%=produit.getIdp()%>">
				<button type="submit" class="btn btn-danger">
					<i class="fas fa-trash"></i>
				</button>
			</form>
		</td>
		<td>
			<a class="btn btn-primary" href="Modifier.jsp?id=<%=produit.getIdp()%>&nom=<%=produit.getNomP()%>&prix=<%=produit.getPrix()%>&fournisseur=<%=produit.getFournisseur()%>">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil" viewBox="0 0 16 16">
					<path d="M13.498.795l.149-.149a1.207 1.207 0 0 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zM12.854 2.646a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/>
				</svg>
			</a>
		</td>
	</tr>
	<%
	}
	%>
</tbody>

		</table>
	</div>
<br><br>
    <center>  <a href="welcome.jsp" style="color:red;font-size:x-small"class="back-link" >
      
     <i class="fas fa-arrow-left"></i>  back 
    </a></center>
</body>

</html>