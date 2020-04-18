
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
        <!--Filtros-->
            <div class="col-lg-3 p-0 border-right justify-content-center d-none d-lg-block">
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
        <!--Productos-->
        <div class="col-12 col-lg-9 pr-4 pl-2 py-1">
            <!--Contenedor de un producto. Iterar para todos los productos-->
            <c:forEach var = "i" begin = "1" end = "5">

            <div class="card mb-3">
                <div class="row no-gutters">
                    <div class="col-sm-4">
                       <img src="media/prueba_cuadrada.jpg" class="card-img">
                        <!--<span class=" productoImg  card-img m-auto">P</span>-->
                   </div>
                   <div class="col-sm-8">
                       <div class="card-body">
                           <div class="card-title">
                               <div class="row">
                                   <div class="col-12 col-xl-8 m-auto text-center">
                                       <h3>Hello Happy Foundation</h3>
                                   </div>

                                   <!--Contenedor estrellas-->
                                    <div class="col-12 col-xl-4 m-auto offset-4">
                                        <div class="row justify-content-center">

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

                                <div class="col-3 m-auto py-2 text-nowrap">
                                    <span class="h5 text-muted">BASE</span>
                                </div>

                                <div class="col-3 m-auto py-2 text-nowrap">
                                    <span class="h5 text-muted">BENEFIT</span>
                                </div>

                            </div>

                            <!--Tercera fila. Contiene features-->
                            <div class="row ">
                                <!--Hacer con un foreEach-->
                                <c:forEach var = "i" begin = "1" end = "4">
                                    <div class="jumbotron mx-auto my-3 py-1 px-3 text-center">
                                        <p class="my-0">Acabado natural</p>
                                    </div>
                                </c:forEach>

                            </div>

                            <!--Cuarta fila. Precio-->
                            <div class="row">
                                <span class="h6 px-2">Precio: 33,95€ </span>
                                <span class="h6 px-2">Oferta: -20% </span>

                            </div>

                        </div>
                    </div>
                </div>
            </div>

            </c:forEach>

        </div>
    </div>
    <%@include file="jsSources.jsp"%>
</body>
</html>
