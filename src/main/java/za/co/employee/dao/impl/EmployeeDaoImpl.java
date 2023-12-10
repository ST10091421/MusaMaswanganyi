package za.co.employee.dao.impl;

import za.co.employee.dao.EmployeeDao;
import za.co.employee.model.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private static EmployeeDao employeeDao = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public EmployeeDaoImpl(Connection con) {
        this.con = con;
        //fetchAllEmployeesFromDB();
    }

    //--------------------------------------------------------
    public static EmployeeDaoImpl getInstance(Connection dbCon) {
        if (employeeDao == null) {
            employeeDao = new EmployeeDaoImpl(dbCon);
        }
        return (EmployeeDaoImpl) employeeDao;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees = new ArrayList();
        if (con != null) {
            try {
                ps = con.prepareStatement("SELECT * FROM employee");
                rs = ps.executeQuery();
                while (rs.next()) {
                    allEmployees.add(new Employee(rs.getString("firstname"), rs.getString("surname"), rs.getDate("DOB").toLocalDate(), rs.getString("email"), rs.getString("password"),
                            rs.getString("empNo"), rs.getDouble("salary"), rs.getString("role"), rs.getString("reportingLineManager"), rs.getBoolean("status")));
                }
            } catch (SQLException ex) {
                System.out.println("Error!!: " + ex.getMessage());
            } finally {
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        System.out.println("Could not close: " + ex.getMessage());
                    }
                }
            }
        }
        return allEmployees;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        boolean retVal = false;
        try {
            ps = con.prepareStatement("INSERT INTO employee (firstName, surname, DOB, email, password, empNo, role, reportingLineManager, salary) values(?,?,?,?,?,?,?,?,?)");

            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getDOB().toString());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getPassword());
            ps.setString(6, employee.getEmpNo());
            ps.setString(7, employee.getRole());
            ps.setString(8, employee.getRepLineManager());
            ps.setDouble(9, employee.getSalary());
            if (ps.executeUpdate() > 0) {
                retVal = true;
            }
        } catch (SQLException ex) {
            System.out.println("Add user ERROR: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Close prepared statment ERROR: " + ex.getMessage());
                }
            }
        }
        return retVal;

    }

    @Override
    public boolean editEmployee(Employee employee, String name) {
        boolean retVal = false;
        try {
            ps = con.prepareStatement("UPDATE employee SET firstName=?, surname=?, email=?, DOB=?, empNo=?, salary=?, role=?, reportingLineManager=? WHERE firstName=?");

            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getDOB().toString());
            ps.setString(5, employee.getEmpNo());
            ps.setDouble(6, employee.getSalary());
            ps.setString(7, employee.getRole());
            ps.setString(8, employee.getRepLineManager());
            ps.setString(9, name);

            retVal = ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.out.println("Update user ERROR: " + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    System.out.println("Close prepared statment ERROR: " + ex.getMessage());
                }
            }
        }
        return retVal;
    }

    @Override
    public boolean deleteEmployee(String empNo) {
        boolean retVal = false;
        try {
            ps = con.prepareStatement("DELETE FROM employee WHERE empNo=?");
            ps.setString(1, empNo);

            int rowsAffected = ps.executeUpdate();

            retVal = rowsAffected > 0;
        } catch (SQLException exception) {
            System.out.println("Delete employee Error!!: " + exception.getMessage());
        }
        return retVal;
    }

    @Override
    public Employee getEmployees(String empNo) {
        Employee aEmployee = null;
        try {
            ps = con.prepareStatement("Select firstName, surname, DOB, email,empNo, salary, role, reportingLineManager from employee WHERE empNo=?");
            ps.setString(1, empNo);
            rs = ps.executeQuery();
            if (rs.next()) {
                aEmployee = new Employee(rs.getString("firstname"), rs.getString("surname"), rs.getDate("DOB").toLocalDate(), rs.getString("email"),
                        rs.getString("empNo"), rs.getDouble("Salary"), rs.getString("role"), rs.getString("reportingLineManager"));
            }
        } catch (SQLException ex) {
            System.out.println("Get User ERROR: " + ex.getMessage());
        }
        return aEmployee;

    }

    public static void main(String[] args) {

        //  System.out.println("Connected");
        Connection myCon = null;
        try {
            String theURL = "jdbc:mysql://localhost:3306/epi-use_africa";
            String userID = "root";
            String passwd = "root";
            myCon = DriverManager.getConnection(theURL, userID, passwd);

            System.out.println("Running....");
            EmployeeDao ed = new EmployeeDaoImpl(myCon);
            System.out.println("result: " + ed.addEmployee(new Employee("Nyiko", "Maswanganyi", LocalDate.of(2001, 07, 8), "editeddd@gmail.com","12345", "58679G", 18000, "Developer", "CEO",true)));
            // EmployeeDaoImpl empdao = new EmployeeDaoImpl(myCon);
            // List<Employee> list = new ArrayList();
            // list = empdao.getAllEmployees();
            // for(Employee myEmp : list){
            //   System.out.println(myEmp);
            //  }
            //Employee em = empdao.getEmployees("58679G");
            //  System.out.println(em);
           // System.out.println("result: "+ed.deleteEmployee("58679G"));
        } catch (SQLException e) {
            System.err.println("Connection Failure: " + e.toString());
        } finally {
// let us now close the connection established
            if (myCon != null) {
                try {
                    myCon.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
