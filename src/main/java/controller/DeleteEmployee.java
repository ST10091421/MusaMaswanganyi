package controller;

import db.listener.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.employee.dao.impl.EmployeeDaoImpl;
import za.co.employee.model.Employee;
import za.co.employee.service.impl.EmployeeServiceImpl;

@WebServlet(name = "DeleteEmployee", urlPatterns = {"/DeleteEmployee"})
public class DeleteEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DBManager dbm = (DBManager) request.getServletContext().getAttribute("dbman");
        Connection con = dbm.getConnection();
        EmployeeServiceImpl emp = new EmployeeServiceImpl(new EmployeeDaoImpl(con));
        boolean retVal = false;
        String name = request.getParameter("empNo");
        retVal = emp.deleteEmployee(name);
        List<Employee> employeeList = null;
        employeeList = emp.getAllEmployees();

        if (retVal != false && employeeList != null) {
            request.setAttribute("employeesList", employeeList);
            request.getRequestDispatcher("manageEmployees.jsp").forward(request, response);
        } else {
            request.setAttribute("employeesList", employeeList);
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
