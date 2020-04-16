<%--
  Created by IntelliJ IDEA.
  User: oleob
  Date: 3/22/2020
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <jsp:include page="head.jsp"/>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <img src="media/LogoBueno.svg" height="42" width="42" class="navbar-brand mr-0 align-bottom" href="#"><h4 class="d-none d-lg-block my-0 mr-5">osmetics.</h4></img>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-info d-none d-lg-block my-2 my-sm-0" type="submit">Search</button>
        </form>
        <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <c:choose>
                    <c:when test="${empty sessionScope.user}">
                        <li class="nav-item active mx-2">
                            <a class="nav-link" href="inicio_sesion_usuario.jsp">Iniciar sesión<span class="sr-only">(current)</span></a>
                        </li>

                        <form action="registro_usuario.jsp" method="get">
                            <button class="btn btn-info my-2 mx-2 my-sm-0" type="submit" >Registrarse</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${sessionScope.user.admin > 0}">
                            <form method="POST" action="CargarDatosMarcas">
                                <button class="btn btn-ttc my-2 mx-2 my-sm-0" type="submit" >Añadir producto</button>
                            </form>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </nav>
    <nav class="navbar navbar-expand-lg navbar-light bg-light d-none d-lg-block justify-content-center">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-nowrap justify-content-center" id="navbarNavDropdown">
            <ul class="navbar-nav justify-content-center">
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">BASES</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">MÁSCARAS DE PESTAÑAS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">PINTALABIOS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">SOMBRAS DE OJOS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">PESTAÑAS POSTIZAS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">CONTOURING</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">COLORETE</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">CEJAS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">CORRECTORES</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="#">EYELINERS</a>
                </li>

            </ul>
        </div>
    </nav>
   <%@include file="jsSources.jsp"%>
</body>
</html>
