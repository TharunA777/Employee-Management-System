package com.xyz;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xyz.Logindao;
import com.xyz.Login;


public class UpdateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Logindao logindao;

    public void init() {
        logindao = new Logindao();
    }  

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        String designation = request.getParameter("designation");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        
        Login login = new Login(username, password, role, designation, city, country);
        
        try {
            boolean result = logindao.update(login);
            if(result) {
                response.sendRedirect("Show.jsp?res=updated");
            } else {
                response.sendRedirect("Show.jsp?res=update_failed");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("Show.jsp?res=update_failed");
        }
    }
}
