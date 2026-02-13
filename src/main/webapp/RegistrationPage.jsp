<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    /* Universal styles for input components */
    input {
        font-family: Arial, sans-serif;
        font-size: 14px;
        background-color: #f0f8ff;
        width: 100%;
    }
    /* Table specific color */
    table {
        background-color: #e6e6e6;
        border-collapse: collapse;
        padding: 20px;
        border-radius: 8px;
    }
    td { padding: 10px; }
</style>
</head>
<body>
    <div align="center">
        <img src="logo.png" alt="Logo" width="100"> <h1>Student Register Page</h1>
            <form action="RegisterServlet" method="post">
                <table style="width: 50%">
                <tr><td>First Name</td><td><input type="text" name="firstName" required /></td></tr>
                <tr><td>Last Name</td><td><input type="text" name="lastName" required /></td></tr>
                
                <tr><td>Username</td><td><input type="text" name="username" maxlength="10" required /></td></tr>
                
                <tr><td>Password</td><td><input type="password" name="password" pattern="[a-zA-Z0-9$_]{1,10}" title="Max 10 chars, digits, $ or _ only" required /></td></tr>
                
                <tr><td>Mobile</td><td><input type="text" name="mobileNumber" pattern="[0-9]{10}" title="Must be exactly 10 digits" required /></td></tr>
                
                <tr><td>Email</td><td><input type="email" name="email" required /></td></tr>
                <tr><td>Date</td><td><input type="date" name="date" required /></td></tr>
                <tr><td>StudentId</td><td><input type="text" name="studentId" pattern="[0-9]{9}" required /></td></tr>
                <tr><td>PostalCode</td><td><input type="text" name="postalCode" pattern="[A-Z][0-9][A-Z]-[0-9][A-Z][0-9]" /></td></tr>
            </table>
            <br>
            <input type="submit" value="Submit" style="width: 100px; background-color: #4CAF50; color: white;"/>
        </form>
    </div>
</body>
</html>