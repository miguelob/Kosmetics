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
        <a href="index.jsp" id = "vueltaMenu" class = "d-flex">
            <img src="media/LogoBueno.svg" height="42" width="42" class="navbar-brand mr-0 align-bottom" href="#"><span class="h4 mt-1 pt-2 d-none d-lg-block my-0 mr-5">osmetics.</span></img>
        </a>
        <form class="form-inline my-2 my-lg-0" method = "POST" action="Filtros">
            <input class="form-control mr-sm-2" type="search" placeholder="Busca algún producto" aria-label="Search" id="searchBar">
            <button class="btn btn-outline-info d-none d-lg-block my-2 my-sm-0" type="submit" name = "indexBusqueda" >Search</button>
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

                        <form action="registro_usuario.jsp" method="post">
                            <button class="btn btn-info my-2 mx-2 my-sm-0" type="submit" >Registrarse</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${sessionScope.user.admin}">
                            <form method="POST" action="LoadInvoices">
                                <button class="btn btn-ttc my-2 mx-2 my-sm-0" type="submit" >Ver ventas</button>
                            </form>
                            <form method="POST" action="CargarDatosMarcas">
                                <button class="btn btn-ttc my-2 mx-2 my-sm-0" type="submit" >Añadir producto</button>
                            </form>
                        </c:if>
                        <form action="carrito.jsp" method="POST">
                            <button class="btn btn-info my-2 mx-2 my-sm-0" type="submit" >Carrito</button>
                        </form>
                        <form action="LoadAllUser" method="POST">
                            <button class="btn btn-info my-2 mx-2 my-sm-0" type="submit" >Perfil</button>
                        </form>
                        <form action="Logout" method="post">
                            <button class="btn btn-info my-2 mx-2 my-sm-0" type="submit" >Log out</button>
                        </form>
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
                    <a class="nav-link" href="./Filtros?tipo=bases">BASES</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="./Filtros?tipo=máscaras-de-pestañas">MÁSCARAS DE PESTAÑAS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="./Filtros?tipo=pintalabios">PINTALABIOS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="./Filtros?tipo=sombras-de-ojos">SOMBRAS DE OJOS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="./Filtros?top=top-ventas">TOP VENTAS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="./Filtros?tipo=contouring">CONTOURING</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="./Filtros?tipo=colorete">COLORETE</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="./Filtros?tipo=cejas">CEJAS</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="./Filtros?tipo=cejas">CORRECTORES</a>
                </li>
                <li class="nav-item mx-2 d-none d-xl-block">
                    <a class="nav-link" href="./Filtros?tipo=eyeliner">EYELINERS</a>
                </li>

            </ul>
        </div>
    </nav>
    <script src="js/index.js"></script>
   <jsp:include page="jsSources.jsp"/>
</body>
</html>
