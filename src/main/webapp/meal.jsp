<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Meal Details"/>
</jsp:include>

<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="activePage" value="meal"/>
</jsp:include>

<div class="container">
    <main>
        <h1>Meal Details</h1>
            <table class="table table-striped">
                <thead class="thead-light">
                    <tr>
                        <th scope="row">Name</th>
                        <td><c:out value='${meal.name}'/></td>
                    </tr>
                    <tr>
                        <th scope="row">Category</th>
                        <td><c:out value='${meal.category}'/></td>
                    </tr>
                    <tr>
                        <th scope="row">Price</th>
                        <td><c:out value='${meal.price} euro'/></td>
                    </tr>
                </thead>
            </table>
        <table class="table table-striped">
            <thead class="thead-light">
            <tr>
                <th scope="row">Is vegetarian?</th>
                <td>${meal.vegetarian ? "Yes" : "No"}</td>
            </tr>
            <tr>
                <th scope="row">Contains lactose?</th>
                <td>${meal.containsLactose ? "Yes" : "No"}</td>
            </tr>
            <tr>
                <th scope="row">Contains nuts?</th>
                <td>${meal.containsNuts ? "Yes" : "No"}</td>
            </tr>

            <tr>
                <th scope="row">Contains gluten?</th>
                <td>${meal.gluten ? "Yes" : "No"}</td>
            </tr>
            </thead>
        </table>
    </main>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>