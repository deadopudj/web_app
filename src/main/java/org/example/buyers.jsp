<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buyers</title>
</head>
<body>
    <h1>List of Buyers</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <c:forEach var="buyer" items="${buyers}">
            <tr>
                <td>${buyer.id}</td>
                <td>${buyer.name}</td>
                <td>${buyer.email}</td>
                <td>
                    <a href="editBuyer?id=${buyer.id}">Edit</a>
                    <a href="deleteBuyer?id=${buyer.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2>Add New Buyer</h2>
    <form action="addBuyer" method="post">
        Name: <input type="text" name="name"><br>
        Email: <input type="email" name="email"><br>
        <input type="submit" value="Add Buyer">
    </form>
    <h2>Edit Buyer</h2>
        <c:forEach var="buyer" items="${buyers}">
            <form action="editBuyer" method="post">
                <input type="hidden" name="id" value="${buyer.id}">
                Name: <input type="text" name="name" value="${buyer.name}"><br>
                Email: <input type="email" name="email" value="${buyer.email}"><br>
                <input type="submit" value="Edit Buyer">
            </form>
        </c:forEach>

        <h2>Delete Buyer</h2>
        <c:forEach var="buyer" items="${buyers}">
            <form action="deleteBuyer" method="post">
                <input type="hidden" name="id" value="${buyer.id}">
                <input type="submit" value="Delete Buyer">
            </form>
        </c:forEach>
</body>
</html>
