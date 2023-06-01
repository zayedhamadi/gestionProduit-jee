<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modele.utilisateur" %>
<%@ page import="dao.UTIL" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List of Users</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        
        h1 {
            color: orange;
            font-size: 28px;
            margin-bottom: 20px;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        
        th {
            background-color: #f5f5f5;
            font-weight: bold;
            text-transform: uppercase;
        }
        
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        
        .back-link {
            color: red;
            font-size: 16px;
            text-decoration: none;
        }
        
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="text-center">
            <h1>List of Users</h1>
            <hr style="color: purple;font-size: 20px">
        </div>
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead class="thead-light">
                    <tr>
                        <th>User</th>
                        <th>Password</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    UTIL utilDao = new UTIL();
                    List<utilisateur> listUtil = utilDao.FindAllUtil();
                    int count = 0;
                    for (utilisateur u : listUtil) {
                        count++;
                    %>
                    <tr>
                        <td><%= u.getUser() %></td>
                        <td><%= u.getPw() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
        <div class="text-center">
            <p>Total users: <%= count %></p>
            <a href="welcome.jsp" class="back-link">
                <i class="fas fa-arrow-left"></i> Back
            </a>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
