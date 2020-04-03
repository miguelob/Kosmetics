<%--
  Created by IntelliJ IDEA.
  User: oleob
  Date: 3/22/2020
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@include file="head.jsp"%>
    <title>Kosmetics</title>
</head>
<body id = "body">
    <%@include file="cabecera.jsp"%>
    <div class = "container">
        <div class = "row">
            <div class="col-sm">

            </div>
            <div class="col-sm">
                <div class="mt-5 d-flex justify-content-center">
                    <div class="mr-lg-3 ml-xl-auto mt-lg-5 pr-xl-5">
                        <p class="h1" id="Letrero"><strong>Kosmetics.</strong></p>
                        <small class="h4 text-nowrap" id="Letrero_2" >Diseñado por consumidores para consumidores</small>
                        <input class="form-control mr-sm-2" type="search" placeholder="Search high-quality products" aria-label="Search">
                    </div>
                </div>
            </div>
            <div class="col-sm">

            </div>
        </div>
    </div>

    <%@include file="jsSources.jsp"%>
</body>
</html>
