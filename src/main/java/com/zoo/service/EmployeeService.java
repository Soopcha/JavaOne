package com.zoo.service;

import com.zoo.dao.EmployeeDAO;
import com.zoo.model.Employee;
import java.util.List;

public class EmployeeService {
    private static EmployeeService instance;
    private final EmployeeDAO employeeDAO;

    private EmployeeService() {
        this.employeeDAO = EmployeeDAO.getInstance();
    }

    public static synchronized EmployeeService getInstance() {
        if (instance == null) {
            instance = new EmployeeService();
        }
        return instance;
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public void createEmployee(Employee employee) {
        employeeDAO.insertEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
