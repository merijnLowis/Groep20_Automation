<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Category Details"/>
</jsp:include>

<body>

<jsp:include page="navbar.jsp">
    <jsp:param name="activePage" value="categorymeals"/>
</jsp:include>

<div class="container">
    <main>
        <h1>Category Details</h1>
        <c:choose>
            <c:when test="${not empty categorymeals}">
                <table class="table table-striped">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="categorymeal" items="${categorymeals}">
                        <tr>
                            <td><c:out value='${categorymeal.name}'/></td>
                            <td> <c:out value="${categorymeal.price} euro"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


            </c:when>
            <c:otherwise>
                <p><em>No meals in this category found</em></p>
            </c:otherwise>
        </c:choose>
    </main>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>