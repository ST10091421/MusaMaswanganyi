package controller;

import db.listener.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.employee.dao.impl.EmployeeDaoImpl;
import za.co.employee.model.Employee;
import za.co.employee.service.impl.EmployeeServiceImpl;

@WebServlet(name = "UpdateEmployee", urlPatterns = {"/UpdateEmployee"})
public class UpdateEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DBManager dbm = (DBManager) request.getServletContext().getAttribute("dbman");
        Connection con = dbm.getConnection();
        EmployeeServiceImpl emp = new EmployeeServiceImpl(new EmployeeDaoImpl(con));

        boolean retVal = false;

        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("firstName");
            String surname = request.getParameter("surname");
            String dob = request.getParameter("DOB");
            String email = request.getParameter("email");
            String empNo = request.getParameter("empNo");
            String role = request.getParameter("role");
            String repLineMan = request.getParameter("reportingLineManager");
            String salary = request.getParameter("salary");

            retVal = emp.editEmployee(new Employee(name, surname, LocalDate.parse(dob), email, empNo, Double.parseDouble(salary), role, repLineMan), name);

            if (retVal != false) {
                out.print("Employee updated");
                response.sendRedirect("http://localhost:8080/epi_use_africa_musa/ShowEmpList");

            } else {
                out.print("failed to update employee");
                // RequestDispatcher rd = request.getRequestDispatcher("updateCategoryForm.jsp");
                // rd.forward(request, response);
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Add this method to handle GET requests if necessary
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
