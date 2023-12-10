<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>EPI-USE HOME</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            header h1 {
                margin: 0;
                padding-left: 20px;
                font-size: 24px;
            }

            nav {
                display: flex;
                align-items: center;
                justify-content: space-between;
                background-color: #4CAF50;
                padding: 0px;
                margin-top: 0px;
            }

            h1 {
                text-align: center;
                margin-top: 50px;
            }

            .login-button {
                background-color: #000;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }

            .login-button2 {
                background-color: #000;
                color: #fff;
                padding: 20px 40px;
                border: none;
                border-radius: 10px;
                cursor: pointer;
                margin-top: 20px;
                display: block;
                margin-left: auto;
                margin-right: auto;
            }

            .modal {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.5);
                justify-content: center;
                align-items: center;
            }

            .modal-content {
                background-color: #fff;
                padding: 40px;
                border-radius: 10px;
                width: 60%;
                max-width: 600px;
                text-align: center;
                position: relative;
            }

            .close {
                cursor: pointer;
                position: absolute;
                top: 15px;
                right: 15px;
                font-size: 18px;
            }

            .modal form {
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            .modal form label {
                margin-top: 15px;
                font-size: 16px;
            }

            .modal form input {
                width: 100%;
                padding: 10px;
                margin-top: 8px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .modal form button {
                background-color: #4CAF50;
                color: #fff;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-top: 20px;
            }
        </style>
    </head>
    <body>

        <nav>
            <h1>EPI-USE</h1>
            <div>

                <button class="login-button" onclick="openModal('loginModal')">Login</button>
            </div>
        </nav>

        <div class="center-container">
            <h1>STAFF MANAGER TOOL</h1>
            <button class="login-button2" onclick="openModal('loginModal')">Login</button>
        </div>

        <!-- ... Your existing code ... -->

        <div id="loginModal" class="modal">
            <div class="modal-content">
                <span class="close" onclick="closeModal('loginModal')">&times;</span>
                <form id="loginForm" onsubmit="return validateLogin()">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" required>

                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" required>

                    <button type="submit">Login</button>
                </form>
            </div>
        </div>

        <script>
            function openModal(modalId) {
                document.getElementById(modalId).style.display = 'flex';
            }

            function closeModal(modalId) {
                document.getElementById(modalId).style.display = 'none';
            }

            document.getElementById('loginModal').addEventListener('click', function (event) {
                if (event.target === this) {
                    closeModal('loginModal');
                }
            });

            function validateLogin() {
                var username = document.getElementById('username').value;
                var password = document.getElementById('password').value;

                // Check if the provided credentials are valid
                if (username === 'admin' && password === 'admin123') {
                    // Redirect to staffManager.jsp
                    window.location.href = 'staffManager.jsp';
                    return false; // Prevent the form from submitting
                } else {
                    // Show error message
                    alert('Invalid credentials entered. Please try again.');
                    return false; // Prevent the form from submitting
                }
            }
        </script>

    </body>
</html>
