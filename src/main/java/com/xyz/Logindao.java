package com.xyz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xyz.Login;

public class Logindao {
	
//"jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6692840", "sql6692840", "WrvIzCQdWW"
    public Login validate(Login login) throws ClassNotFoundException {
        Login l=new Login();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empms", "root", "root");
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from users where username = ? and password = ? ")) {
            preparedStatement.setString(1, login.getUsername());
            preparedStatement.setString(2, login.getPassword());
       
            //System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
        	l.setUsername(rs.getString("username"));
        	l.setPassword(rs.getString("password"));
        	l.setRole(rs.getString("role"));
        	l.setDesignation(rs.getString("designation"));
        	l.setCity(rs.getString("city"));
        	l.setCountry(rs.getString("country"));
            return l;
            }
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return l;
    }
    public int add(Login login) throws SQLException,ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empms", "root", "root");
                PreparedStatement preparedStatement =connection.prepareStatement("insert into users(username,password,role,designation,city,country) values(?,?,?,?,?,?)")){
		preparedStatement.setString(1,login.getUsername());
		preparedStatement.setString(2, login.getPassword());
		preparedStatement.setString(3, login.getRole());
		preparedStatement.setString(4, login.getDesignation());
		preparedStatement.setString(5, login.getCity());
		preparedStatement.setString(6, login.getCountry());
    	
		int result =preparedStatement.executeUpdate();
		preparedStatement.close();
		return result;
    	}
	}
    
    
   

    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    public boolean delete(String username) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empms", "root", "root");
                PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE username = ?")) {
            preparedStatement.setString(1, username);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
    public boolean update(Login login) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empms", "root", "root");
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET password=?, role=?, designation=?, city=?, country=? WHERE username=?")) {
            preparedStatement.setString(1, login.getPassword());
            preparedStatement.setString(2, login.getRole());
            preparedStatement.setString(3, login.getDesignation());
            preparedStatement.setString(4, login.getCity());
            preparedStatement.setString(5, login.getCountry());
            preparedStatement.setString(6, login.getUsername());
            
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        }
    }
    
    
    public ArrayList<Login> getAllEmployees() throws SQLException, ClassNotFoundException {
        ArrayList<Login> employees = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empms", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users")) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Login employee = new Login();
                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setRole(rs.getString("role"));
                employee.setDesignation(rs.getString("designation"));
                employee.setCity(rs.getString("city"));
                employee.setCountry(rs.getString("country"));
                employees.add(employee);
            }
        }
        return employees;
    }
    
    
    public void register(Login login) throws ClassNotFoundException, SQLException {
        String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (username, password, role, designation, city, country) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empms", "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, login.getUsername());
            preparedStatement.setString(2, login.getPassword());
            preparedStatement.setString(3, login.getRole());
            preparedStatement.setString(4, login.getDesignation());
            preparedStatement.setString(5, login.getCity());
            preparedStatement.setString(6, login.getCountry());
            preparedStatement.setString(7, login.getPhoneNumber()); 
            

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException1(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    
    
    
    public ArrayList<Login> getAllEmployees() {
        ArrayList<Login> employees = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empms", "root", "root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                Login employee = new Login();
                employee.setUsername(rs.getString("username"));
                employee.setPassword(rs.getString("password"));
                employee.setRole(rs.getString("role"));
                employee.setDesignation(rs.getString("designation"));
                employee.setCity(rs.getString("city"));
                employee.setCountry(rs.getString("country"));
                employee.setPhoneNumber(rs.getString("phone_number")); // Set phone number
                employees.add(employee);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Method to add a new employee
    public boolean addEmployee(Login employee) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, this.username, this.password);
            String query = "INSERT INTO users (username, password, role, designation, city, country, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, employee.getUsername());
            pstmt.setString(2, employee.getPassword());
            pstmt.setString(3, employee.getRole());
            pstmt.setString(4, employee.getDesignation());
            pstmt.setString(5, employee.getCity());
            pstmt.setString(6, employee.getCountry());
            pstmt.setString(7, employee.getPhoneNumber()); // Add phone number
            int rowsInserted = pstmt.executeUpdate();
            con.close();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
    
    



}
