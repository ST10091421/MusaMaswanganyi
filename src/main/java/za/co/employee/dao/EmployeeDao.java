package za.co.employee.dao;

import java.util.List;
import za.co.employee.model.Employee;

public interface EmployeeDao {
   boolean addEmployee(Employee employee); 
   boolean editEmployee(Employee employee, String name);
   boolean deleteEmployee(String empNo);
   Employee getEmployees(String name);
   List<Employee> getAllEmployees();
}
