<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="update.css" />
<title>Modify Product</title>
<style>
body {
	background-color: #f8f9fa;
	font-family: Arial, sans-serif;
}

.container {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.form-group {
	margin-bottom: 15px;
}

label {
	display: inline-block;
	width: 100px;
	font-weight: bold;
}

input[type="text"] {
	width: 250px;
	padding: 5px;
	border: 1px solid #ccc;
	border-radius: 3px;
	font-size: 14px;
}

button[type="submit"], button[type="reset"] {
	padding: 8px 12px;
	border: none;
	border-radius: 3px;
	font-size: 14px;
	font-weight: bold;
	cursor: pointer;
}

button[type="submit"] {
	background-color: #007bff;
	color: #fff;
}

button[type="reset"] {
	background-color: #dc3545;
	color: #fff;
	margin-left: 10px;
}

.error-message {
	color: red;
	margin-top: 5px;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<div class="container">
	<h3 class="text-center"><center>Modify Product  Form:</center> </h3>
			<hr>
			<br>
		<form method="post" action="modifier.dao"
			onsubmit="return confirmModification();">
			<div class="form-group">
				<label>id:</label> <input readonly name="id"
					value="<%=request.getParameter("id")%>">
			</div>
			<br>
			<div class="form-group">
				<label>Nom:</label> <input type="text" name="np"
					value="<%=request.getParameter("nom")%>">
			</div>
			<br>
			<div class="form-group">
				<label>Prix:</label> <input type="text" name="p"
					value="<%=request.getParameter("prix")%>">
			</div>
			<br>
			<div class="form-group">
				<label>Fournisseur:</label> <input type="text" name="f"
					value="<%=request.getParameter("fournisseur")%>">
			</div>
			<br> <br> <br>
			<div class="form-group">
				<center>
					<button type="submit">Modifier</button>
					<button type="reset">Reset</button>
					<br> <br>
				</center>

			</div>
		</form>
	</div>

	<script>
		function confirmModification() {
			return confirm("Are you sure you want to modify?");
		}
	</script>
</body>
</html>
