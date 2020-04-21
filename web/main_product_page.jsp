
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
                        <c:forEach var = "feature" items="${sessionScope.features}">
                            <div class="row">
                                <input type="checkbox" class="custom-control-input" id="caracteristicas1" value="${feature.key}">
                                <label class="custom-control-label" for="caracteristicas1">${feature.value}</label>
                            </div>
                        </c:forEach>

                    </div>

                    <h4 class="text-left pt-5 pb-1 px-3">Marca</h4>
                    <div class="custom-control custom-checkbox">
                        <c:forEach var = "brand" items="${sessionScope.brands}">
                            <div class="row">
                                <input type="checkbox" class="custom-control-input" id="marca1" value="${brand.key}">
                                <label class="custom-control-label" for="marca1">${brand.value}</label>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        <!--Productos-->
        <div class="col-12 col-lg-9 pr-4 pl-2 py-1">
            <!--Contenedor de un producto. Iterar para todos los productos-->
            <c:forEach var = "product" items="${sessionScope.products}">

            <div class="card mb-3">
                <div class="row no-gutters">
                    <div class="col-sm-4">
                       <img src="ReadImg?id=${product.id}" class="card-img">
                        <!--<span class=" productoImg  card-img m-auto">P</span>-->
                   </div>
                   <div class="col-sm-8">
                       <div class="card-body">
                           <div class="card-title">
                               <div class="row">
                                   <div class="col-12 col-xl-8 m-auto text-center">
                                       <h3>${product.name}</h3>
                                   </div>

                                   <!--Contenedor estrellas-->
                                    <div class="col-12 col-xl-4 m-auto offset-4">
                                        <div class="row justify-content-center">
                                                <c:forEach var = "i" begin = "0" end = "${product.score}">
                                                    <span class="fa fa-star fa-2x checked"></span>
                                                </c:forEach>
                                                <c:forEach var = "i" begin = "0" end = "5-${product.score}">
                                                    <span class="fa fa-star fa-2x "></span>
                                                </c:forEach>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--Segunda fila. Contiene categoria y marca-->
                            <div class="row">
                                <div class="col-3 m-auto py-2 text-nowrap">
                                    <span class="h5 text-muted">${product.category}</span>
                                </div>

                                <div class="col-3 m-auto py-2 text-nowrap">
                                    <span class="h5 text-muted">${product.brand}</span>
                                </div>

                            </div>

                            <!--Tercera fila. Contiene features-->
                            <div class="row ">
                                <!--Hacer con un foreEach-->
                                <c:forEach var = "feature" items="${product.features}">
                                    <div class="jumbotron mx-auto my-3 py-1 px-3 text-center">
                                        <p class="my-0">${feature}</p>
                                    </div>
                                </c:forEach>

                            </div>

                            <!--Cuarta fila. Precio-->
                            <div class="row">
                                <span class="h6 px-2">Precio: <fmt:formatNumber pattern="#,##0.00 €" value="${product.ogPrice}"/></span>
                                <span class="h6 px-2">Oferta:
                                    <c:choose>
                                        <c:when test = "${product.freeDeliver}">
                                            Envío gratuíto
                                        </c:when>
                                        <c:when test = "${product.offer != 0}">
                                            <fmt:formatNumber pattern="##00%" value="${product.offer}"/>
                                            <span class="h6 px-2">Nuevo Precio: ${product.newPrice}</span>
                                        </c:when>
                                        <c:otherwise>
                                            No hay Oferta.
                                        </c:otherwise>
                                    </c:choose>

                                </span>

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
