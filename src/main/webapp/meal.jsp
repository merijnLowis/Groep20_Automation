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
    <jsp:param name="activePage" value="mealdetails"/>
</jsp:include>

<div class="container">
    <main>
        <h1>Patient Details</h1>
            <table class="table table-striped">
                <thead class="thead-light">
                    <tr>
                        <th scope="row">name</th>
                        <td><c:out value='${meal.name}'/></td>
                    </tr>
                    <tr>
                        <th scope="row">category</th>
                        <td><c:out value='${meal.category}'/></td>
                    </tr>
                    <tr>
                        <th scope="row">price</th>
                        <td><c:out value='${meal.price}'/></td>
                    </tr>
                </thead>
            </table>
        <table class="table table-striped">
            <thead class="thead-light">
            <tr>
                <th scope="row">vegetarian</th>
                <td><c:out value='${meal.vegetarian}'/></td>
            </tr>
            <tr>
                <th scope="row">lactose</th>
                <td><c:out value='${meal.lactose}'/></td>
            </tr>
            <tr>
                <th scope="row">nuts</th>
                <td><c:out value='${meal.nuts}'/></td>
            </tr>
            </thead>
        </table>
    </main>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>