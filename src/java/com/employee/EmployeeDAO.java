/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chris Mamboleo
 */


public class EmployeeDAO {

    // JDBC connection 
    private static final String JDBC_URL =
        "jdbc:mysql://localhost:3306/employeedb?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "mamboleo254?";

    // SQL queries
    private static final String INSERT_EMPLOYEE_SQL =
        "INSERT INTO employees (first_name, last_name, email, department, salary) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_EMPLOYEE_BY_ID =
        "SELECT id, first_name, last_name, email, department, salary FROM employees WHERE id = ?";
    private static final String SELECT_ALL_EMPLOYEES =
        "SELECT id, first_name, last_name, email, department, salary FROM employees";
    private static final String UPDATE_EMPLOYEE_SQL =
        "UPDATE employees SET first_name = ?, last_name = ?, email = ?, department = ?, salary = ? WHERE id = ?";
    private static final String DELETE_EMPLOYEE_SQL =
        "DELETE FROM employees WHERE id = ?";

    //  load the JDBC driver once
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.err.println("Could not register MySQL JDBC Driver");
        }
    }

    /** Helper to get a database connection */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
    }
     //performing Crud operations functions
    /** CREATE
     * @param emp */
    public void addEmployee(Employee emp) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_EMPLOYEE_SQL)) {

            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getDepartment());
            ps.setDouble(5, emp.getSalary());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** READ (by ID) */
    public Employee getEmployeeById(int id) {
        Employee emp = null;
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    emp = new Employee();
                    emp.setId(rs.getInt("id"));
                    emp.setFirstName(rs.getString("first_name"));
                    emp.setLastName(rs.getString("last_name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setDepartment(rs.getString("department"));
                    emp.setSalary(rs.getDouble("salary"));
                }
            }
        } catch (SQLException e) {
        }
        return emp;
    }

    /** READ (all)
     * @return  */
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_EMPLOYEES);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getDouble("salary"));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /** UPDATE */
    public void updateEmployee(Employee emp) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_EMPLOYEE_SQL)) {

            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getEmail());
            ps.setString(4, emp.getDepartment());
            ps.setDouble(5, emp.getSalary());
            ps.setInt(6, emp.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    /** DELETE
     * @param id */
    public void deleteEmployee(int id) {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_EMPLOYEE_SQL)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}

