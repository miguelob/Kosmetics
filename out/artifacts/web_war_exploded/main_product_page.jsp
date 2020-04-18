
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <%@include file="head.jsp"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Página principal · Kosmetics </title>
</head>
<body>
    <%@include file="cabecera.jsp"%>
    <div class="row">
            <div class="col-xl-3 col-md-4 p-0 border-right justify-content-center d-none d-lg-block">
            <div class="col-9 m-auto">

                <h4 class="text-left pt-5 pb-1 px-3">Filtros</h4>
                <label for="customRange1">Precio</label>
                <input type="range" class="custom-range" id="customRange1">

                <h4 class="text-left pt-5 pb-1 px-3">Características</h4>
                <div class="custom-control custom-checkbox">

                    <div class="row">
                        <input type="checkbox" class="custom-control-input" id="caracteristicas1">
                        <label class="custom-control-label" for="caracteristicas1">leer de la BD</label>
                    </div>

                    <div class="row">
                        <input type="checkbox" class="custom-control-input" id="caracteristicas2">
                        <label class="custom-control-label" for="caracteristicas2">leer de la BD</label>
                    </div>

                </div>

                <h4 class="text-left pt-5 pb-1 px-3">Marca</h4>
                <div class="custom-control custom-checkbox">
                    <div class="row">
                        <input type="checkbox" class="custom-control-input" id="marca1">
                        <label class="custom-control-label" for="marca1">leer de la BD</label>
                    </div>

                    <div class="row">
                        <input type="checkbox" class="custom-control-input" id="marca2">
                        <label class="custom-control-label" for="marca2">leer de la BD</label>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-12 col-md-8 col-xl-9 pr-4 pl-2 py-1">
            <!--Contenedor de un producto. Iterar para todos los productos-->
            <c:forEach var = "i" begin = "1" end = "5">

            <div class="card mb-3">
                <div class="row no-gutters">
                    <div class="col-md-4">
                        <!--<img src="..." class="card-img" alt="...">-->
                        <span class=" productoImg  card-img m-auto">P</span>
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <div class="card-title">
                                    <div class="col-8 m-auto text-center">
                                        <h3>Hello Happy Foundation</h3>
                                    </div>

                                    <!--Contenedor estrellas-->
                                    <div class="col-4 m-auto">
                                        <div class="container">
                                            <div class="row">

                                                <span class="fa fa-star fa-2x checked"></span>
                                                <span class="fa fa-star fa-2x checked"></span>
                                                <span class="fa fa-star fa-2x  checked"></span>
                                                <span class="fa fa-star fa-2x "></span>
                                                <span class="fa fa-star fa-2x "></span>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                            <!--Segunda fila. Contiene categoria y marca-->
                            <div class="row">

                                <div class="col-3 m-auto py-2">
                                    <span class="h5 text-muted">BASE</span>
                                </div>

                                <div class="col-3 m-auto py-2">
                                    <span class="h5 text-muted">BENEFIT</span>
                                </div>

                            </div>

                            <!--Tercera fila. Contiene features-->
                            <div class="row ">
                                <!--Hacer con un foreEach-->
                                <div class="jumbotron mx-auto my-3 py-1 px-3 text-center">
                                    <p class="lead my-0">Acabado natural</p>
                                </div>
                                <div class="jumbotron mx-auto my-3 p-1 px-3 text-center">
                                    <p class="lead my-0">Larga duración</p>
                                </div>
                                <div class="jumbotron mx-auto my-3 p-1 px-3 text-center">
                                    <p class="lead my-0">Acabado mate</p>
                                </div>

                            </div>

                            <!--Cuarta fila. Precio-->
                            <div class="row">
                                <span class="h7">33,95 €</span>

                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <!--mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm-->
            <!--<div class="row border-bottom product_container">
                <dic class="col-md-3 col-xl-5"><span class=" productoImg m-auto">P</span></dic>

                <div class="col-md-9 col-xl-7">
                    <div class="row">
                        <div class="col-8 m-auto text-center">
                            <h3>Hello Happy Foundation</h3>
                        </div>
            -->
                        <!--Contenedor estrellas-->
             <%--           <div class="col-4 m-auto">
                            <div class="container">
                                <div class="row">

                                    <span class="fa fa-star fa-2x checked"></span>
                                    <span class="fa fa-star fa-2x checked"></span>
                                    <span class="fa fa-star fa-2x  checked"></span>
                                    <span class="fa fa-star fa-2x "></span>
                                    <span class="fa fa-star fa-2x "></span>
                                </div>
                            </div>
                        </div>
                   </div>
                    <!--Segunda fila. Contiene categoria y marca-->
                    <div class="row">

                        <div class="col-3 m-auto py-2">
                            <span class="h5 text-muted">BASE</span>
                        </div>

                        <div class="col-3 m-auto py-2">
                            <span class="h5 text-muted">BENEFIT</span>
                        </div>

                    </div>

                    <!--Tercera fila. Contiene features-->
                    <div class="row ">
                        <!--Hacer con un foreEach-->
                        <div class="jumbotron mx-auto my-3 py-1 px-3 text-center">
                            <p class="lead my-0">Acabado natural</p>
                        </div>
                        <div class="jumbotron mx-auto my-3 p-1 px-3 text-center">
                            <p class="lead my-0">Larga duración</p>
                        </div>
                        <div class="jumbotron mx-auto my-3 p-1 px-3 text-center">
                            <p class="lead my-0">Acabado mate</p>
                        </div>

                    </div>

                    <!--Cuarta fila. Precio-->
                    <div class="row">
                        <span class="h7">33,95 €</span>

                    </div>
        </div>
                    --%>

            </c:forEach>

        </div>
    </div>
    <%@include file="jsSources.jsp"%>
</body>
</html>
