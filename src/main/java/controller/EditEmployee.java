package controller;

import db.listener.DBManager;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.employee.dao.impl.EmployeeDaoImpl;
import za.co.employee.model.Employee;
import za.co.employee.service.impl.EmployeeServiceImpl;

@WebServlet(name = "EditEmployee", urlPatterns = {"/EditEmployee"})
public class EditEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DBManager dbm = (DBManager) request.getServletContext().getAttribute("dbman");
        Connection con = dbm.getConnection();
        EmployeeServiceImpl emp = new EmployeeServiceImpl(new EmployeeDaoImpl(con));

        String name = request.getParameter("empNo");

        Employee empl = emp.getEmployees(name);

        if (empl != null) {
            request.setAttribute("data", empl);
            request.getRequestDispatcher("editEmployeeForm.jsp").forward(request, response);
        } else {
            // Handle the case where employee is not found, e.g., redirect to an error page
            response.sendRedirect("errorPage.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
