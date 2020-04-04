
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@include file="head.jsp"%>
    <title>Página principal · Kosmetics </title>
</head>
<body>
    <%@include file="cabecera.jsp"%>

    <div class="col-0 col-lg-3 ">

        <h3 class="text-left text-muted pt-5 pb-1 px-3">Precio</h3>
        <form class="range-field">
            <input type="range" min="0" max="100" />
        </form>
    </div>
    <%@include file="jsSources.jsp"%>
</body>
</html>
