package com.xyz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String designation = request.getParameter("designation");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String phoneNumber = request.getParameter("phone_number"); // Get phone number

        Login employee = new Login();
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setRole(role);
        employee.setDesignation(designation);
        employee.setCity(city);
        employee.setCountry(country);
        employee.setPhoneNumber(phoneNumber); // Set phone number

        Logindao logindao = new Logindao();
        boolean isAdded = logindao.addEmployee(employee);

        if (isAdded) {
            response.sendRedirect("success.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
