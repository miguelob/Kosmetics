
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <jsp:include page="head.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Carrito · Kosmetics </title>
</head>
<body id = "carritoBody">
<jsp:include page="cabeceraSinAjax.jsp"/>
<div class="row justify-content-center">

    <!--Filtros pantalla pequeña-->
    <div class="col-12 p-0 justify-content-center text-center d-block d-lg-none">
        <div class="col-11 mx-auto mt-5">
            <h1 class="text-center py-3 mt-5 "><strong>Finaliza tu pedido!!</strong></h1>
            <h5>Número de productos: <c:out value="${sessionScope.carrito.elementos}"/></h5>
            <h5>Coste: <fmt:formatNumber pattern="#,##0.00 €" value="${sessionScope.carrito.total}"/></h5>
            <c:if test="${not empty sessionScope.carrito.carrito}">
                <form action="finalizar_compra.jsp" method = "POST">
                    <button type="submit" class="btn btn-dark mt-5">Tramitar</button>
                </form>
                <button type="submit" class="btn btn-dark mt-5" onclick="getDatos('./CarritoManager?empty=1','carritoBody');">Vaciar carrito</button>
            </c:if>
        </div>
    </div>

    <!--Productos-->
    <div class="col-lg-1"></div>
    <div class="col-11 col-lg-8 pr-4 pl-2 py-1">
        <!--Contenedor de un producto. Iterar para todos los productos-->
        <c:if test="${not empty sessionScope.carrito.carrito}">
            <c:forEach var ="carrito" items="${sessionScope.carrito.carrito}">
                <a class = "text-decoration-none cajas" href="LoadAllProduct?id=${carrito.key.id}">
                    <div class="card mb-3">
                        <div class="row no-gutters">

                            <div class="col-sm-4">
                                <a class = "text-decoration-none cajas" href="LoadAllProduct?id=${carrito.key.id}">

                                    <img src="ReadImg?id=${carrito.key.id}" class="card-img">
                                    <!--<span class=" productoImg  card-img m-auto">P</span>-->
                                </a>

                            </div>

                            <div class="col-sm-8">
                                <div class="card-body">

                                    <a class = "text-decoration-none cajas" href="LoadAllProduct?id=${carrito.key.id}">
                                        <div class="card-title">
                                            <div class="row">
                                                <div class="col-12 col-xl-8 m-auto text-center">
                                                    <h3><c:out value="${carrito.key.name}"/></h3>
                                                </div>

                                                <!--Contenedor estrellas-->
                                                <div class="col-12 col-xl-4 m-auto offset-4">
                                                    <div class="row justify-content-center">
                                                        <c:forEach var = "i" begin = "1" end = "${carrito.key.score}">
                                                            <span class="fa fa-star fa-2x checked"></span>
                                                        </c:forEach>
                                                        <c:forEach var = "i" begin = "1" end = "${carrito.key.resto}">
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
                                            <span class="h5 text-muted"><c:out value ="${carrito.key.category}"/></span>
                                        </div>

                                        <div class="col-3 m-auto py-2 text-nowrap">
                                            <span class="h5 text-muted"><c:out value ="${carrito.key.brand}"/></span>
                                        </div>

                                    </div>

                                    <!--Tercera fila. Contiene features-->
                                    <div class="row ">
                                        <ul class="list-inline">
                                            <!--Hacer con un foreEach-->
                                            <c:forEach var = "feature" items="${carrito.key.features}">
                                                <li class="list-inline-item jumbotron mx-1 my-3 py-1 px-3 text-center"><c:out value ="${feature}"/></li>
                                            </c:forEach>
                                        </ul>
                                    </div>

                                    <!--Cuarta fila. Precio-->
                                    <div class="row">
                                        <span class="h6 px-2">Precio: <fmt:formatNumber pattern="#,##0.00 €" value="${carrito.key.ogPrice}"/></span>
                                        <span class="h6 px-2">Oferta:</span>
                                        <c:choose>
                                            <c:when test = "${carrito.key.freeDeliver}">
                                                <span class="h6 px-2" style="color:red">Envío gratuíto</span>
                                            </c:when>
                                            <c:when test = "${carrito.key.offer != 0}">
                                                <fmt:formatNumber pattern="#%" value="${carrito.key.offer}"/>
                                                <span class="h6 px-2">Nuevo Precio: <fmt:formatNumber pattern="#,##0.00 €" value="${carrito.key.newPrice}"/></span>
                                            </c:when>
                                            <c:otherwise>
                                                No hay Oferta.
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <!--Quinta fila. Contiene selector de cantidad y boton de eliminar-->
                                    <div class="row my-4">
                                        <ul class="list-inline">
                                            <li class="list-inline-item text-center">
                                                <label>Cantidad: <c:out value ="${carrito.value}"/></label>
                                            </li>
                                            <li class="list-inline-item text-center">
                                                <a class="btn btn-dark" href="javascript:getDatos('./CarritoManager?suma=1&id=${carrito.key.id}','carritoBody');">+</a>
                                                <a class="btn btn-dark" href="javascript:getDatos('./CarritoManager?resta=1&id=${carrito.key.id}','carritoBody');">-</a>
                                            </li>
                                            <li class="list-inline-item text-center">
                                                <button type="submit" class="btn btn-outline-dark mx-5 " onclick="getDatos('./CarritoManager?eliminar=1&id=${sessionScope.allProduct.id}','carritoBody');">Eliminar del carrito</button>
                                            </li>

                                        </ul>

                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </c:if>
        <c:if test="${empty sessionScope.carrito.carrito}">
            <label style="color: red; text-align: center">No hay ningún producto en el carrito.</label>
        </c:if>
    </div>

    <!--Filtros pantalla grande-->
    <div class="col-lg-3 p-0 border-right justify-content-center d-none d-lg-block">
        <div class="col-11 mx-auto mt-5">
            <h1 class="text-center py-3 mt-5 "><strong>Finaliza tu pedido!!</strong></h1>
            <h5>Número de productos: <c:out value="${sessionScope.carrito.elementos}"/></h5>
            <h5>Coste: <fmt:formatNumber pattern="#,##0.00 €" value="${sessionScope.carrito.total}"/></h5>
            <c:if test="${not empty sessionScope.carrito.carrito}">
                <form action="finalizar_compra.jsp" method = "POST">
                    <button type="submit" class="btn btn-dark mt-5">Tramitar</button>
                </form>
                <button type="submit" class="btn btn-dark mt-5" onclick="getDatos('./CarritoManager?empty=1','carritoBody');">Vaciar carrito</button>
            </c:if>
        </div>
    </div>
</div>
<script src="js/petAsinc.js"></script>
<jsp:include page="jsSources.jsp"/>
</body>
</html>
