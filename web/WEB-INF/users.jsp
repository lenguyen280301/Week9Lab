<%-- 
    Document   : users
    Created on : Mar 20, 2023, 12:21:53 AM
    Author     : Wicncjjd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <h1>Manage Users</h1>
        ${message} 
        <c:if test="${users.isEmpty()}">No users found.  Please add a user</c:if>
        
        
        <c:if test="${!users.isEmpty()}">
            <table border="1">
            <tr><th>Email</th><th>First Name</th><th>Last Name</th><th>Role</th><th></th><th></th></tr>
            
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.getEmail()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getRole().getRoleName()}</td>
                    <td><a href="users?action=edit&amp;email=${user.getEmail()}">Edit</a></td>
                    <td><a href="users?action=delete&amp;email=${user.getEmail()}">Delete</a></td>
                </tr>
            </c:forEach>
            </table>
    </body>
</html>
