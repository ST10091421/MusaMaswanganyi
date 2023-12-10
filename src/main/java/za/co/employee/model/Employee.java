package za.co.employee.model;

import java.sql.Date;
import java.time.LocalDate;

public class Employee {

    private String firstName;
    private String surname;
    private LocalDate DOB;
    private String email;
    private String password;
    private String empNo;
    private double salary;
    private String role;
    private String repLineManager;
    private boolean status;

    public Employee() {
    }

    public Employee(String firstName, String surname, LocalDate DOB, String email, String password, String empNo, double salary, String role, String repLineManager, boolean status) {
        this.firstName = firstName;
        this.surname = surname;
        this.DOB = DOB;
        this.email = email;
        this.password = password;
        this.empNo = empNo;
        this.salary = salary;
        this.role = role;
        this.repLineManager = repLineManager;
        this.status = status;
    }
    public Employee(String firstName, String surname, LocalDate DOB, String email, String empNo, double salary, String role, String repLineManager) {
        this.firstName = firstName;
        this.surname = surname;
        this.DOB = DOB;
        this.email = email;
        this.empNo = empNo;
        this.salary = salary;
        this.role = role;
        this.repLineManager = repLineManager;
    }

 

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRepLineManager() {
        return repLineManager;
    }

    public void setRepLineManager(String repLineManager) {
        this.repLineManager = repLineManager;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", surname=" + surname + ", DOB=" + DOB + ", email=" + email + ", password=" + password + ", empNo=" + empNo + ", salary=" + salary + ", role=" + role + ", repLineManager=" + repLineManager + ", status=" + status + '}';
    }

    
   
}
