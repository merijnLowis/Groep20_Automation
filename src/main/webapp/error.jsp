<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="nl">

<jsp:include page="head-default.jsp">
    <jsp:param name="title" value="Sum Ting Wong"/>
</jsp:include>

<body>

<jsp:include page="navbar.jsp"/>

<div class="container">
    <main>
        <p> ${error}</p>
    </main>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>