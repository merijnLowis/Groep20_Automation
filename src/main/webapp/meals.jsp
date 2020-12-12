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
                        <th scope="col">name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="meal" items="${meals}">
                        <tr>
                            <td><a href="Controller?command=MealDetails&name=${meal.name}"><c:out value='${meal.name}'/></a></td>
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