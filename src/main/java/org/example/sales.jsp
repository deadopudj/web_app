<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sales</title>
</head>
<body>
    <h1>List of Sales</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Buyer ID</th>
            <th>Product ID</th>
            <th>Quantity</th>
            <th>Action</th>
        </tr>
        <c:forEach var="sale" items="${sales}">
            <tr>
                <td>${sale.id}</td>
                <td>${sale.buyerId}</td>
                <td>${sale.productId}</td>
                <td>${sale.quantity}</td>
                <td>
                    <a href="editSale?id=${sale.id}">Edit</a>
                    <a href="deleteSale?id=${sale.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <h2>Add New Sale</h2>
    <form action="addSale" method="post">
        Buyer ID: <input type="text" name="buyerId"><br>
        Product ID: <input type="text" name="productId"><br>
        Quantity: <input type="text" name="quantity"><br>
        <input type="submit" value="Add Sale">
    </form>
    <h2>Edit Sale</h2>
        <c:forEach var="sale" items="${sales}">
            <form action="editSale" method="post">
                <input type="hidden" name="id" value="${sale.id}">
                Buyer ID: <input type="text" name="buyerId" value="${sale.buyerId}"><br>
                Product ID: <input type="text" name="productId" value="${sale.productId}"><br>
                Quantity: <input type="text" name="quantity" value="${sale.quantity}"><br>
                <input type="submit" value="Edit Sale">
            </form>
        </c:forEach>

        <h2>Delete Sale</h2>
        <c:forEach var="sale" items="${sales}">
            <form action="deleteSale" method="post">
                <input type="hidden" name="id" value="${sale.id}">
                <input type="submit" value="Delete Sale">
            </form>
        </c:forEach>
</body>
</html>
