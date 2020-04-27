<%--
  Created by IntelliJ IDEA.
  User: oleob
  Date: 3/22/2020
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>

    <jsp:include page="head.jsp"/>
    <title>Kosmetics</title>
</head>
<body id = "body">
    <c:if test="${not empty sessionScope.user}">
        <jsp:forward page="main_product_page.jsp"></jsp:forward>
    </c:if>
    <jsp:include page="cabecera.jsp"/>
    <div class = "container">
        <div class = "row">
            <div class="col-sm">

            </div>
            <div class="col-sm">
                <div class="mt-5 d-flex justify-content-center">
                    <div class="mr-lg-3 ml-xl-auto mt-lg-5 pr-xl-5">
                        <p class="h1" id="Letrero"><strong>Kosmetics.</strong></p>
                        <small class="h4 text-nowrap " id="Letrero_2" >Diseñado por consumidores para consumidores</small>
                        <input class="form-control mr-sm-2 mt-3" type="search" placeholder="Search high-quality products" aria-label="Search" id="searchBarIndex">
                    </div>
                </div>
            </div>
            <div class="col-sm">

            </div>
        </div>
    </div>
<%--    <script src="js/index.js"></script>--%>
    <jsp:include page="jsSources.jsp"/>
</body>
</html>
