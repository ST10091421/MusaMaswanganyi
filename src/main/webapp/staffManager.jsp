<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EMPLOYEES MANAGER</title>
        <!-- Bootstrap CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
        <style>
            body {
                background-color: #f4f4f4;
            }

            .navbar {
                background-color: #4CAF50; 
            }

            .navbar-brand {
                color: black; 
            }

            .navbar-toggler-icon {
                background-color: white;
            }

            .navbar-nav .nav-link {
                color: white;
            }

            h3 {
                margin-top: 20px;
            }

            .card {
                background-color: #818589;
                margin-top: 20px;
            }

            .card-title {
                color: white;
            }

            .btn-light {
                background-color: #fff;
                color: #000;
            }
        </style>

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="index.jsp">EPI-USE</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container mt-4">
            <h3 class="text-center">STAFF MANAGEMENT TOOL</h3>
            <hr>

            <div class="row justify-content-center">
                <div class="col-lg-4 col-md-6 mt-3">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Manage Employees</h5>
                            <p class="card-text">Add/Edit/Delete/Explore</p>
                            <a href="http://localhost:8080/epi_use_africa_musa/ShowEmpList" class="btn btn-light">VIEW</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS and Popper.js -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
