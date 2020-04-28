
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <jsp:include page="head.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Página principal · Kosmetics </title>
</head>
<body id = "paginaProductos">
    <jsp:include page="cabecera.jsp"/>
    <div class="row">
        <!--Filtros-->
            <div class="col-lg-3 p-0 border-right justify-content-center d-none d-lg-block">
                <div class="col-9 m-auto">

                    <h4 class="text-left pt-5 pb-1 px-3">Filtros</h4>
                    <label for="customRange1">Precio: </label><label style="color : red" id ="precioFiltro"> </label><label style="color: red">€</label>
                    <input type="range" class="custom-range" id="customRange1" min="0" max="100" value = "50">

                    <h4 class="text-left pt-5 pb-1 px-3">Características</h4>
                    <div class="custom-control custom-checkbox">
                        <c:forEach var = "feature" items="${sessionScope.features}">
                            <div class="row">
                                <c:choose>
                                    <c:when test = "${not empty cookie.get(feature.value.replace(' ','-'))}">
                                        <input type="checkbox" class="custom-control-input" onclick="getDatos('./Filtros?feature=${feature.value.replace(' ','-')}','paginaProductos');" name = "features" id = "caracteristicas${feature.key}" value="${feature.key}">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" class="custom-control-input" onclick="getDatos('./Filtros?feature=${feature.value.replace(' ','-')}','paginaProductos');" name = "features" id = "caracteristicas${feature.key}" value="${feature.key}" checked>
                                    </c:otherwise>
                                </c:choose>
                                <label class="custom-control-label" for="caracteristicas${feature.key}">${feature.value}</label>
                            </div>
                        </c:forEach>

                    </div>

                    <h4 class="text-left pt-5 pb-1 px-3">Marca</h4>
                    <div class="custom-control custom-checkbox">
                        <c:forEach var = "brand" items="${sessionScope.brands}">
                            <div class="row">
                                <c:choose>
                                    <c:when test = "${not empty cookie.get(brand.value.replace(' ','-'))}">
                                        <input type="checkbox" class="custom-control-input" onclick="getDatos('./Filtros?Marca=${brand.value.replace(' ','-')}','paginaProductos');" name = "marcas" id="marca${brand.key}" value="${brand.key}">
                                    </c:when>
                                    <c:otherwise>
                                        <input type="checkbox" class="custom-control-input" onclick="getDatos('./Filtros?Marca=${brand.value.replace(' ','-')}','paginaProductos');" name = "marcas" id="marca${brand.key}" value="${brand.key}" checked>
                                    </c:otherwise>
                                </c:choose>
                                <label class="custom-control-label" for="marca${brand.key}">${brand.value}</label>
                            </div>
                        </c:forEach>

                    </div>
                </div>
            </div>
        <!--Productos-->
        <div class="col-12 col-lg-9 pr-4 pl-2 py-1">
            <!--Contenedor de un producto. Iterar para todos los productos-->
            <c:forEach var = "product" items="${sessionScope.products}">
                <c:if test="${sessionScope.user.admin}">
                    <button class="btn btn-ttc my-2 mx-2 my-sm-0" type="submit" onclick="getDatos('./EliminarProducto?id=${product.id}','paginaProductos');">Eliminar producto</button>
                </c:if>
                <a class = "text-decoration-none cajas" href="LoadAllProduct?id=${product.id}">
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
                                                    <c:forEach var = "i" begin = "1" end = "${product.score}">
                                                        <span class="fa fa-star fa-2x checked"></span>
                                                    </c:forEach>
                                                    <c:forEach var = "i" begin = "1" end = "${product.resto}">
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
                                        <ul class="list-inline">
                                            <!--Hacer con un foreEach-->
                                            <c:forEach var = "feature" items="${product.features}">
                                                <li class="list-inline-item jumbotron mx-1 my-3 py-1 px-3 text-center">${feature}</li>
                                            </c:forEach>
                                        </ul>
                                    </div>

                                    <!--Cuarta fila. Precio-->
                                    <div class="row">
                                        <span class="h6 px-2">Precio: <fmt:formatNumber pattern="#,##0.00 €" value="${product.ogPrice}"/></span>
                                        <span class="h6 px-2" style="color:red">Oferta:
                                <c:choose>
                                    <c:when test = "${product.freeDeliver}">
                                        Envío gratuíto
                                    </c:when>
                                    <c:when test = "${product.offer != 0}">
                                        <fmt:formatNumber pattern="#%" value="${product.offer}"/>
                                        <span class="h6 px-2">Nuevo Precio: <fmt:formatNumber pattern="#,##0.00 €" value="${product.newPrice}"/></span>
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
                </a>
            </c:forEach>
        </div>
    </div>
    <script src="js/MainProductPage.js"></script>
    <jsp:include page="jsSources.jsp"/>
</body>
</html>
