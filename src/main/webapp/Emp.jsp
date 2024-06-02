<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.xyz.*"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Details</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
       .button-container {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
        }
        input[type="submit"], button[type="submit"] {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover, button[type="submit"]:hover {
            background-color: #45a049;
        } 
    </style>
</head>
<body>

<%
    Login login = (Login) request.getAttribute("emp");
%>

<table border="1">
    <tr>
        <th>Username</th><th>Password</th><th>Role</th><th>Desination</th><th>City</th><th>Country</th>
    </tr>
    <tr>
        <td><%=login.getUsername() %></td>
        <td><%=login.getPassword() %></td>
        <td><%=login.getRole()  %></td>
        <td><%=login.getDesignation()%></td>
        <td><%=login.getCity()%></td>
        <td><%=login.getCountry() %></td>
    </tr>
</table>

</body>
</html>
