<%-- 
    Document   : editEmployeeForm
    Created on : Dec 9, 2023, 5:52:27 PM
    Author     : User73
--%>

<%@page import="za.co.employee.model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    Employee data = (Employee) request.getAttribute("data");

%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Form</title>
        <style>
            form {
                border: 1px solid green;
                padding: 10px;
                width: 300px; /* Adjust the width as needed */
                margin: auto;
            }

            label {
                display: block;
                margin-bottom: 5px;
                color: green;
            }

            input {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                box-sizing: border-box;
                border: 1px solid green;
                border-radius: 4px;
            }

            input.custom-btn {
                background-color: green;
                color: white;
                cursor: pointer;
            }
        </style>
    </head>
    <body>

        <form action="UpdateEmployee" method="POST">
            <caption>Edit An Employee</caption>

            <label for="firstName">Name: </label>
            <input type="text" name="firstName" value="<%= data.getFirstName()%>" required>

            <label for="surname">Surname:</label>
            <input type="text" name="surname" value="<%= data.getSurname()%>" required>

            <label for="DOB">Date of Birth:</label>
            <input type="text" name="DOB" value="<%= data.getDOB()%>" required>

            <label for="email">Email:</label>
            <input type="text" name="email" value="<%= data.getEmail()%>" required>

            <label for="empNo">Employee No:</label>
            <input type="text" name="empNo" value="<%= data.getEmpNo()%>" required>

            <label for="salary">Salary:</label>
            <input type="text" name="salary" value="<%= data.getSalary()%>" required>

            <label for="role">Role:</label>
            <input type="text" name="role" value="<%= data.getRole()%>" required><!-- comment -->

            <label for="reportingLineManager">Reports To:</label>
            <input type="text" name="reportingLineManager" value="<%= data.getRepLineManager()%>" required>

            <input type="submit" class="custom-btn" value="Update">
        </form>

        <!-- Add your scripts and other body elements as needed -->
    </body>
</html>
