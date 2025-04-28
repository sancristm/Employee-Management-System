/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.employee;

/**
 *
 * @author Chris Mamboleo
 */
//



import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named("employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private final EmployeeDAO dao = new EmployeeDAO();
    private List<Employee> employees;
    private Employee employee = new Employee();

    /** Load all employees for display
     * @return  */
    public List<Employee> getEmployees() {
        employees = dao.getAllEmployees();
        return employees;
    }

    /** Getter/setter for the form-bound Employee
     * @return  */
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /** Navigate to blank add form
     * @return  */
    public String newEmployee() {
        employee = new Employee();
        return "addEmployee.xhtml?faces-redirect=true";
    }

    /** Save new or updated employee, then go back to list
     * @return  */
    public String save() {
        if (employee.getId() == 0) {
            dao.addEmployee(employee);
        } else {
            dao.updateEmployee(employee);
        }
        employee = new Employee();
        return "index.xhtml?faces-redirect=true";
    }

    /** Load selected employee into form for editing
     * @param emp
     * @return  */
    public String edit(Employee emp) {
        this.employee = emp;
        return "addEmployee.xhtml?faces-redirect=true";
    }

    /** Delete and stay on list page
     * @param emp */
    public void delete(Employee emp) {
        dao.deleteEmployee(emp.getId());
        // refresh list for next getter call
        employees = dao.getAllEmployees();
    }
}
