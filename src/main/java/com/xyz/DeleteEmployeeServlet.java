package com.xyz;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xyz.Logindao;


public class DeleteEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Logindao logindao;

    public void init() {
        logindao = new Logindao();
    }  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        try {
            boolean result = logindao.delete(username);
            if(result) {
                response.sendRedirect("Show.jsp?res=deleted");
            } else {
                response.sendRedirect("Show.jsp?res=delete_failed");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("Show.jsp?res=delete_failed");
        }
    }
}
