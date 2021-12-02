<%-- 
    Document   : resetNewPassword
    Created on : 2-Dec-2021, 2:54:08 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Enter a new password</h1>
        
        <form action="reset" method="post">
            <input type="text" name="password"><br>
            <input type="submit" value="Submit">
            <input type="hidden" name="uuid" value="${uuid}">
        </form>
    </body>
</html>
