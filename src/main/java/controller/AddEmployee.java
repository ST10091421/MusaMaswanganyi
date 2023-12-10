/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import db.listener.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.employee.dao.impl.EmployeeDaoImpl;
import za.co.employee.model.Employee;
import za.co.employee.service.impl.EmployeeServiceImpl;

@WebServlet(name = "addEmployee", urlPatterns = {"/addEmployee"})
public class AddEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBManager dbm = (DBManager) request.getServletContext().getAttribute("dbman");
        Connection con = dbm.getConnection();
        EmployeeServiceImpl emp = new EmployeeServiceImpl(new EmployeeDaoImpl(con));
        List<Employee> employeeList = null;

        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("firstName");
            String surname = request.getParameter("surname");
            String dob = request.getParameter("DOB");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String empNo = request.getParameter("empNo");
            String role = request.getParameter("role");
            String repLineMan = request.getParameter("reportingLineManager");
            String salary = request.getParameter("salary");
            boolean retVal = emp.addEmployee(new Employee(name, surname, LocalDate.parse(dob), email, password, empNo, Double.parseDouble(salary), role, repLineMan, true));
            employeeList = emp.getAllEmployees();

            if (retVal != false && employeeList != null) {

                out.print("New Employee added");
                request.setAttribute("employeesList", employeeList);
                RequestDispatcher rd = request.getRequestDispatcher("manageEmployees.jsp");
                rd.forward(request, response);

            } else {
                out.print("failed to add Employee");
                request.setAttribute("employeesList", employeeList);
                RequestDispatcher rd = request.getRequestDispatcher("manageEmployees.jsp");
                rd.forward(request, response);
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
