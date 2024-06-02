<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.xyz.Login" %>
<%@ page import="com.xyz.Logindao" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            flex-direction: column;
        }
        .header-container {
            width: 80%;
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }
        h2 {
            margin: 0;
            color: #333;
        }
        #search {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 300px;
        }
        table {
            width: 80%;
            border-collapse: collapse;
            background-color: #fff;
            border: 2px solid #000;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border: 2px solid #000;
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
        }
        input[type="submit"], button[type="submit"] {
            padding: 8px 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover, button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
    <script>
        function searchTable() {
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("search");
            filter = input.value.toUpperCase();
            table = document.getElementById("employeeTable");
            tr = table.getElementsByTagName("tr");

            for (i = 1; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td")[0];
                if (td) {
                    txtValue = td.textContent || td.innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";
                    } else {
                        tr[i].style.display = "none";
                    }
                }       
            }
        }
    </script>
</head>
<body>
    <div class="header-container">
        <h2>Employee Table</h2>
        <input type="text" id="search" onkeyup="searchTable()" placeholder="Search for usernames..">
    </div>
    <table id="employeeTable">
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Designation</th>
            <th>City</th>
            <th>Country</th>
            <th>Action</th>
        </tr>
        <% 
            Logindao logindao = new Logindao();
            ArrayList<Login> employees = logindao.getAllEmployees();
            for(Login employee : employees) {
        %>
        <tr>
            <td><%= employee.getUsername() %></td>
            <td><%= employee.getPassword() %></td>
            <td><%= employee.getRole() %></td>
            <td><%= employee.getDesignation() %></td>
            <td><%= employee.getCity() %></td>
            <td><%= employee.getCountry() %></td>
            <td class="button-container">
                <form action="UpdateEmployeeForm.jsp" method="get" style="display:inline;">
                    <input type="hidden" name="username" value="<%= employee.getUsername() %>">
                    <button type="submit">Update</button>
                </form>
                <form action="DeleteEmployeeServlet" method="get" style="display:inline;">
                    <input type="hidden" name="username" value="<%= employee.getUsername() %>">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
