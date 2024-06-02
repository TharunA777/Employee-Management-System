<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Display</title>
</head>
<body>
    <%
        String res = request.getParameter("res");
        if("deleted".equals(res)) {
    %>
        <h3>Employee deleted successfully</h3>
    <% } else if("delete_failed".equals(res)) { %>
        <h3>Failed to delete employee. Please try again.</h3>
    <% } else if("updated".equals(res)) { %>
        <h3>Employee updated successfully</h3>
    <% } else if("update_failed".equals(res)) { %>
        <h3>Failed to update employee. Please try again.</h3>
    <% } else { %>
        <h3>Employee added successfully</h3>
    <% } %>
</body>
</html>
