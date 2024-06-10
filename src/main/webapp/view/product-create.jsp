<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2024
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Add Product</h1>
    <form class="form-group" action="${pageContext.request.contextPath}/product/create" method="post">
        <div class="form-group">
            <label>Product Name:</label>
            <input type="text" class="form-control" id="nameProduct" name="nameProduct" required>
        </div>

        <div class="form-group">
            <label>Price:</label>
            <input type="number" class="form-control" id="price" name="price" required>
        </div>

        <div class="form-group">
            <label>Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" required>
        </div>

        <div class="form-group">
            <label>Color:</label>
            <select class="form-control" id="color" name="color">
                <option value="Đỏ">Đỏ</option>
                <option value="Xanh">Xanh</option>
                <option value="Đen">Đen</option>
                <option value="Trắng">Trắng</option>
                <option value="Vàng">Vàng</option>
            </select>
        </div>

        <div class="form-group">
            <label>Description:</label>
            <input type="text" class="form-control" id="description" name="description" required>
        </div>

        <div class="form-group">
            <label>Category Name:</label>
            <select class="form-control" id="nameCategory" name="nameCategory">
                <c:forEach items="${categories}" var="categories">
                    <option value="${categories.idCategory}">${categories.nameCategory}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Add Product</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
        integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
        crossorigin="anonymous"></script>
</body>
</html>
