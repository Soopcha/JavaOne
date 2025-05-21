package com.zoo.servlets;

import com.zoo.model.Employee;
import com.zoo.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EmployeeActionServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        this.employeeService = EmployeeService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if ("delete".equals(action)) {
            employeeService.deleteEmployee(id);
        } else {
            String fullName = request.getParameter("fullName");
            String position = request.getParameter("position");
            double salary = Double.parseDouble(request.getParameter("salary"));
            String phone = request.getParameter("phone");

            Employee employee = new Employee(id, fullName, position, salary, phone);

            if (id == 0) {
                employeeService.createEmployee(employee);
            } else {
                employeeService.updateEmployee(employee);
            }
        }

        response.sendRedirect("employees");
    }
}
