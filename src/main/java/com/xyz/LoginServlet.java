package com.xyz;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    private Logindao logindao;

    public void init() {
        logindao = new Logindao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);

        try {
            if (logindao.validate(login)!=null) {
            	Login l=logindao.validate(login);
            	System.out.println(l);
            	System.out.println(l.getRole());
            	if(l.getRole().equals("employee"))
            	{
        				RequestDispatcher dispatcher = request.getRequestDispatcher("Emp.jsp");
        				request.setAttribute("emp", l);
        				dispatcher.include(request, response);
            	}
            	else {
            		response.sendRedirect("Admin.jsp");
            	}
            	
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
            } 
     
             else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        
    } catch (ClassNotFoundException e) {
            e.printStackTrace();
    } 

        }
}