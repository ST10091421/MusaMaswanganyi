
package controller;

import db.listener.DBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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


@WebServlet(name = "ShowEmpList", urlPatterns = {"/ShowEmpList"})
public class EmployeesList  extends HttpServlet {
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DBManager dbm = (DBManager) request.getServletContext().getAttribute("dbman");
        Connection con = dbm.getConnection();
        EmployeeServiceImpl emp = new EmployeeServiceImpl(new EmployeeDaoImpl(con));
        List<Employee> employeeList = null;
        
       
        try (PrintWriter out = response.getWriter()) {
            employeeList = emp.getAllEmployees();
            
            if (employeeList != null) {
                request.setAttribute("employeesList", employeeList);
                RequestDispatcher rd = request.getRequestDispatcher("manageEmployees.jsp");
                rd.forward(request, response);
            }else{
                out.print("failed to load list");
               
            }
            
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
