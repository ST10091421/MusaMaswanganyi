package za.co.employee.service.impl;

import java.util.ArrayList;
import java.util.List;
import za.co.employee.dao.EmployeeDao;
import za.co.employee.model.Employee;
import za.co.employee.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao empDao) {
        this.employeeDao = empDao;
    }

    @Override
    public List<Employee> getAllEmployees(){
        List<Employee> list = new ArrayList();
        return list == null ? null : employeeDao.getAllEmployees();
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employee != null ? employeeDao.addEmployee(employee) : false;
    }

    @Override
    public boolean editEmployee(Employee employee,String name) {
        return employee != null ? employeeDao.editEmployee(employee,name) : false;
    }

    @Override
    public boolean deleteEmployee(String empNo) {
        return empNo != null ? employeeDao.deleteEmployee(empNo) : null;
    }

    @Override
    public Employee getEmployees(String name) {
        return name != null ? employeeDao.getEmployees(name) : null;
    }
}
