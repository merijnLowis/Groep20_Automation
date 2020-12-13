<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Meal Overview"/>
</jsp:include>

<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="activePage" value="meals"/>
</jsp:include>

<div class="container">
    <main>
        <h1>Registered meals</h1>
        <c:choose>
            <c:when test="${not empty meals}">
                <table class="table table-striped">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Category</th>
                        <th scope="col">Price</th>
                        <th scope="row">Is vegetarian?</th>
                        <th scope="row">Contains lactose?</th>
                        <th scope="row">Contains nuts?</th>
                        <th scope="row">Contains gluten?</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="meal" items="${meals}">
                        <tr>
                            <td><a href="Controller?command=MealDetails&name=${meal.name}"><c:out value='${meal.name}'/></a></td>
                            <td><a href="Controller?command=CategoryDetails&category=${meal.category}"><c:out value="${meal.category}"/></a></td>
                            <td> <c:out value="${meal.price} euro"/></td>
                            <td>${meal.vegetarian ? "Yes" : "No"}</td>
                            <td>${meal.containsLactose ? "Yes" : "No"}</td>
                            <td>${meal.containsNuts ? "Yes" : "No"}</td>
                            <td>${meal.gluten ? "Yes" : "No"}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


            </c:when>
            <c:otherwise>
                <p><em>No meals found</em></p>
            </c:otherwise>
        </c:choose>
    </main>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>