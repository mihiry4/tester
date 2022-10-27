<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <h1>
            CampusCash
        </h1>
    </head>
    <body>
        <form method="POST" action="Login.perform">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"><br><br>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password"><br><br>
            <input type="submit" value="Submit">
          </form>
          <a href="register.html">Sign up</a>
    </body>
</html>