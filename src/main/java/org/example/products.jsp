<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Products</title>
</head>
<body>
    <h1>List of Products</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>
                    <a href="editProduct?id=${product.id}">Edit</a>
                    <a href="deleteProduct?id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2>Add New Product</h2>
    <form action="addProduct" method="post">
        Name: <input type="text" name="name"><br>
        Price: <input type="text" name="price"><br>
        <input type="submit" value="Add Product">
    </form>

    <h2>Edit Product</h2>
    <c:forEach var="product" items="${products}">
        <form action="editProduct" method="post">
            <input type="hidden" name="id" value="${product.id}">
            Name: <input type="text" name="name" value="${product.name}"><br>
            Price: <input type="text" name="price" value="${product.price}"><br>
            <input type="submit" value="Edit Product">
        </form>
    </c:forEach>

    <h2>Delete Product</h2>
    <c:forEach var="product" items="${products}">
        <form action="deleteProduct" method="post">
            <input type="hidden" name="id" value="${product.id}">
            <input type="submit" value="Delete Product">
        </form>
    </c:forEach>
</body>
</html>
