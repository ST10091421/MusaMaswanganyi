<%-- 
    Document   : manageEmployees
    Created on : Dec 8, 2023, 10:37:34 PM
    Author     : User73
--%>

<%@page import="za.co.employee.model.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MANAGE EMPLOYEES</title>
        <style>
            /* Style for navigation bar */
            .navbar {
                background-color: #4CAF50; /* Green color */
            }

            /* Style for table borders */
            table {
                border-collapse: collapse;
                width: 100%;
                margin-top: 20px;
            }

            th, td {
                border: 1px solid #4CAF50; /* Green border */
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #4CAF50; /* Green background for header */
                color: white;
            }

            .custom-btn {
                background-color: #4CAF50; /* Green color */
                color: white;
                border: 1px solid #4CAF50; /* Green border */
                padding: 10px 20px;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                border-radius: 4px; /* Rounded corners */
            }
            /* Style for the modal */
            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0, 0, 0, 0.5);
            }

            .modal-content {
                background-color: #fefefe;
                margin: 10% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
                max-width: 400px;
                border-radius: 8px;
            }

            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: black;
                text-decoration: none;
                cursor: pointer;
            }
            /* Add this CSS to your existing styles or include it in the head of your HTML document */
            .form-container {
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #4CAF50; /* Green border */
                border-radius: 8px;
            }

            .form-label {
                display: block;
                margin-bottom: 8px;
                color: #4CAF50; /* Green color */
            }

            .form-input {
                width: 100%;
                padding: 8px;
                margin-bottom: 16px;
                box-sizing: border-box;
                border: 1px solid #4CAF50; /* Green border */
                border-radius: 4px;
            }

            .form-select {
                width: 100%;
                padding: 8px;
                margin-bottom: 16px;
                box-sizing: border-box;
                border: 1px solid #4CAF50; /* Green border */
                border-radius: 4px;
            }

            .form-submit {
                background-color: #4CAF50; /* Green color */
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            .form-submit:hover {
                background-color: #45a049; /* Darker green color on hover */
            }

        </style>
    </head>

    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="index.jsp" style="font-size: 24px; color: black;">EPI-USE</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>

        <div class="row">
            <div class="container">
                <h3 class="text-center">Employees management panel</h3>
                <hr><!-- comment -->


                <div id="addEmployeeModal" class="modal">
                    <div class="modal-content">
                        <span class="close" onclick="closeModal()">&times;</span>
                        <!-- Apply the custom styles to your form -->
                        <form action="addEmployee" method="POST" class="form-container">
                            <label for="name" class="form-label">Name:</label>
                            <input type="text" name="firstName" class="form-input" required>

                            <label for="surname" class="form-label">Surname:</label>
                            <input type="text" name="surname" class="form-input" required>

                            <label for="dob" class="form-label">Date of Birth:</label>
                            <input type="date" name="DOB" class="form-input" required>

                            <label for="email" class="form-label">Email:</label>
                            <input type="email" name="email" class="form-input" required>

                            <label for="empNo" class="form-label">Password:</label>
                            <input type="text" name="password" class="form-input" required>

                            <label for="empNo" class="form-label">Employee No:</label>
                            <input type="text" name="empNo" class="form-input" required>

                            <label for="salary" class="form-label">Salary:</label>
                            <input type="text" name="salary" class="form-input" required>

                            <label for="role" class="form-label">Role:</label>
                            <input type="text" name="role" class="form-input" required>

                            <label for="reportsTo" class="form-label">Reports to:</label>
                            <select name="reportingLineManager" class="form-select">
                                <option value="CEO">CEO</option>
                                <option value="Team Manager">Team Manager</option>
                                <option value="Project Manager">Project Manager</option>
                            </select>



                            <input type="submit" class="form-submit" value="Submit">
                        </form>

                    </div>
                </div>

                <div class="container justify-content-left">
                    <div class="row justify-content-left">
                        <div class="col-lg-4 col-md-6 mt-3">
                            <a href="#" class="custom-btn" onclick="openModal()">Add New Employee</a>
                        </div>
                    </div>
                </div>
                <!-- Exit button -->
                <div class="container justify-content-right">
                    <div class="row justify-content-right">
                        <div class="col-lg-4 col-md-6 mt-3">
                            <a href="staffManager.jsp" class="custom-btn">Exit</a>
                        </div>
                    </div>
                </div>

                <form action="showEmpList" method="GET">
                    <div>
                        <label for="filterInput">Filter by Name:</label>
                        <input type="text" id="filterInput" onkeyup="filterTable()">
                    </div>
                    <table class="table table-bordered">
                        <thead>
                            <tr>

                                <th>Name</th>
                                <th>Surname</th>
                                <th>Date of Birth</th>
                                <th>Email</th>
                                <th>Employee No</th>
                                <th>Role</th>
                                <th>Reports to.</th>
                                <th>Salary</th>
                                <th>Action</th>
                                <th>Action</th>

                            </tr>
                        </thead>


                        <%
                            List<Employee> myEmpList = (List<Employee>) request.getAttribute("employeesList");
                            for (Employee list : myEmpList) {%>

                        <tr>

                            <td><%= list.getFirstName()%></td>
                            <td><%= list.getSurname()%></td>
                            <td><%= list.getDOB()%></td>
                            <td><%= list.getEmail()%></td>
                            <td><%= list.getEmpNo()%></td>
                            <td><%= list.getRole()%></td>
                            <td><%= list.getRepLineManager()%></td>
                            <td><%= list.getSalary() + "0"%></td>

                            <td><a href="EditEmployee?empNo=<%=list.getEmpNo()%>" class="custom-btn">Edit</a></td>
                            <td><a href="DeleteEmployee?empNo=<%=list.getEmpNo()%>" class="custom-btn">Delete</a></td>
                        </tr>
                        <% }%>
                    </table>
                </form>
            </div>

        </div>
        <script>
            function openModal() {
                var modal = document.getElementById("addEmployeeModal");
                modal.style.display = "block";
            }

            function closeModal() {
                var modal = document.getElementById("addEmployeeModal");
                modal.style.display = "none";
            }

            // Close the modal if the user clicks outside the form
            window.onclick = function (event) {
                var modal = document.getElementById("addEmployeeModal");
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        </script>
    </body>
</html>
<script>

    function filterTable() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("filterInput");
        filter = input.value.toUpperCase();
        table = document.querySelector("table");
        tr = table.getElementsByTagName("tr");
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0]; // Change the index to the desired column
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>