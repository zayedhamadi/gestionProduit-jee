<%@page import="modele.produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
   <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        .container-fluid {
            margin: 0 auto;
            max-width: 800px;
        }

        .table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .table th,
        .table td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }

        .table th {
            background-color: #f8f9fa;
        }

        .btn-danger {
            background-color: #dc3545;
            color: #fff;
            text-align: left;
            padding: 10px;
            font-weight: bold;
        }

        .message {
            color: red;
            margin-top: 10px;
        }
    </style>
<html>
<head>
<meta charset="ISO-8859-1">

<%
List<produit> R = (List<produit>) request.getAttribute("resultat");
%>
<title>Insert title here</title>
</head>
<body>
    <div class="container-fluid">
        <table class="table">
            <thead class="btn btn-danger">
                <tr style="color:blue">
                    <th>Reference of the product</th>
                    <th>Name of the product</th>
                    <th>Price</th>
                    <th>Fournisseur</th>
                </tr>
            </thead>
            <tbody>
                <% for (produit produit : R) { %>
                    <tr>
                        <td><%=produit.getIdp()%></td>
                        <td><%=produit.getNomP()%></td>
                        <td><%=produit.getPrix() %>   <em>DT</em></td>
                        <td><%=produit.getFournisseur()%></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        
        <p class="message">
            <% int count = R.size(); %>
            <% if (count == 0) { %>
                No products found for your search.
            <% } else if (count == 1) { %>
                Found 1 product for your search.
            <% } else { %>
                Found <%= count %> products for your search.
            <% } %>
        </p>
    </div>

</body>
</html>
