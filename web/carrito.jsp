
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <jsp:include page="head.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Carrito · Kosmetics </title>
</head>
<body id = "paginaProductos">
<jsp:include page="cabecera.jsp"/>
<div class="row justify-content-center">

    <!--Filtros pantalla pequeña-->
    <div class="col-12 p-0 justify-content-center text-center d-block d-lg-none">
        <div class="col-11 mx-auto mt-5">
            <h1 class="text-center py-3 mt-5 "><strong>Finaliza tu pedido!!</strong></h1>
            <h5>Número de productos: 3</h5>
            <h5>Coste: 40,16 €</h5>
            <form action="finalizar_compra.jsp" method = "POST">
                <button type="submit" class="btn btn-dark mt-5">Tramitar</button>
            </form>
        </div>
    </div>

    <!--Productos-->
    <div class="col-lg-1"></div>
    <div class="col-11 col-lg-8 pr-4 pl-2 py-1">
        <!--Contenedor de un producto. Iterar para todos los productos-->
        <c:forEach var = "product" items="${sessionScope.products}">
            <c:if test="${sessionScope.user.admin}">
                <button class="btn btn-ttc my-2 mx-2 my-sm-0" type="submit" onclick="getDatos('./EliminarProducto?id=${product.id}','paginaProductos');">Eliminar producto</button>
            </c:if>
                <div class="card mb-3">
                    <div class="row no-gutters">

                            <div class="col-sm-4">
                                <a class = "text-decoration-none cajas" href="LoadAllProduct?id=${product.id}">

                                <img src="ReadImg?id=${product.id}" class="card-img">
                                <!--<span class=" productoImg  card-img m-auto">P</span>-->
                                </a>

                            </div>

                            <div class="col-sm-8">
                            <div class="card-body">

                                <a class = "text-decoration-none cajas" href="LoadAllProduct?id=${product.id}">
                                    <div class="card-title">
                                    <div class="row">
                                        <div class="col-12 col-xl-8 m-auto text-center">
                                            <h3><c:out value="${product.name}"/></h3>
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
                                </a>

                                <!--Segunda fila. Contiene categoria y marca-->
                                <div class="row">
                                    <div class="col-3 m-auto py-2 text-nowrap">
                                        <span class="h5 text-muted"><c:out value ="${product.category}"/></span>
                                    </div>

                                    <div class="col-3 m-auto py-2 text-nowrap">
                                        <span class="h5 text-muted"><c:out value ="${product.brand}"/></span>
                                    </div>

                                </div>

                                <!--Tercera fila. Contiene features-->
                                <div class="row ">
                                    <ul class="list-inline">
                                        <!--Hacer con un foreEach-->
                                        <c:forEach var = "feature" items="${product.features}">
                                            <li class="list-inline-item jumbotron mx-1 my-3 py-1 px-3 text-center"><c:out value ="${feature}"/></li>
                                        </c:forEach>
                                    </ul>
                                </div>

                                <!--Cuarta fila. Precio-->
                                <div class="row">
                                    <span class="h6 px-2">Precio: <fmt:formatNumber pattern="#,##0.00 €" value="${product.ogPrice}"/></span>
                                    <span class="h6 px-2">Oferta:</span>
                                <c:choose>
                                    <c:when test = "${product.freeDeliver}">
                                        <span class="h6 px-2" style="color:red">Envío gratuíto</span>
                                    </c:when>
                                    <c:when test = "${product.offer != 0}">
                                        <fmt:formatNumber pattern="#%" value="${product.offer}"/>
                                        <span class="h6 px-2">Nuevo Precio: <fmt:formatNumber pattern="#,##0.00 €" value="${product.newPrice}"/></span>
                                    </c:when>
                                    <c:otherwise>
                                        No hay Oferta.
                                    </c:otherwise>
                                </c:choose>
                                </div>
                                <!--Quinta fila. Contiene selector de cantidad y boton de eliminar-->
                                <div class="row my-4">
                                    <ul class="list-inline">
                                        <li class="list-inline-item text-center">Cantidad:</li>

                                        <li class="list-inline-item text-center">
                                           <select id="inputState" class="form-control">
                                                <option selected>1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                          </select>
                                       </li>
                                        <li class="list-inline-item text-center">
                                             <button type="submit" class="btn btn-outline-dark mx-5 ">Eliminar del carrito</button>
                                        </li>

                                    </ul>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>

    <!--Filtros pantalla grande-->
    <div class="col-lg-3 p-0 border-right justify-content-center d-none d-lg-block">
        <div class="col-11 mx-auto mt-5">
            <h1 class="text-center py-3 mt-5 "><strong>Finaliza tu pedido!!</strong></h1>
            <h5>Número de productos: 3</h5>
            <h5>Coste: 40,16 €</h5>
            <form action="finalizar_compra.jsp" method = "POST">
                <button type="submit" class="btn btn-dark mt-5">Tramitar</button>
            </form>

        </div>
    </div>
</div>
<script src="js/MainProductPage.js"></script>
<jsp:include page="jsSources.jsp"/>
</body>
</html>
