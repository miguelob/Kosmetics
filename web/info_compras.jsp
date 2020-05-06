
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <jsp:include page="head.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Carrito · Kosmetics </title>
</head>
<body id = "bodyInvoices">
<c:if test="${empty sessionScope.user}">
    <jsp:forward page="./inicio_sesion_usuario.jsp"></jsp:forward>
</c:if>
<c:if test="${!sessionScope.user.admin}">
    <jsp:forward page="./inicio_sesion_usuario.jsp"></jsp:forward>
</c:if>
<jsp:include page="cabeceraSinAjax.jsp"/>
<div class="row justify-content-center">

    <!--Filtros pantalla pequeña-->
    <div class="col-12 p-0 justify-content-center text-center d-block d-lg-none">
        <div class="col-11 mx-auto mt-5">
            <h1 class="text-center py-3 mt-5 "><strong>Computo global</strong></h1>
            <h5>Número de productos vendidos: <c:out value="${requestScope.numVentas}"/></h5>
            <h5>Valor neto: <fmt:formatNumber pattern="#,##0.00 €" value="${requestScope.total}"/></h5>
            <button type="submit" class="btn btn-dark mt-5" onclick="getDatos('./LoadInvoices','bodyInvoices');">Actualizar</button>
        </div>
    </div>

    <!--Productos-->
    <div class="col-lg-1"></div>
    <div class="col-11 col-lg-8 pr-4 pl-2 py-1">
        <!--Contenedor de un producto. Iterar para todos los productos-->
        <c:if test="${not empty requestScope.invoices}">
            <c:forEach var ="invoice" items="${requestScope.invoices}">
                <a class = "text-decoration-none cajas" href="LoadAllProduct?id=${invoice.product.id}">
                    <div class="card mb-3">
                        <div class="row no-gutters">

                            <div class="col-sm-4">
                                <a class = "text-decoration-none cajas" href="LoadAllProduct?id=${invoice.product.id}">

                                    <img src="ReadImg?id=${invoice.product.id}" class="card-img">
                                    <!--<span class=" productoImg  card-img m-auto">P</span>-->
                                </a>

                            </div>

                            <div class="col-sm-8">
                                <div class="card-body">

                                    <a class = "text-decoration-none cajas" href="LoadAllProduct?id=${invoice.product.id}">
                                        <div class="card-title">
                                            <div class="row">
                                                <div class="col-12 col-xl-8 m-auto text-center">
                                                    <h3><c:out value="${invoice.product.name}"/></h3>
                                                </div>

                                                <!--Contenedor estrellas-->
                                                <div class="col-12 col-xl-4 m-auto offset-4">
                                                    <div class="row justify-content-center">
                                                        <c:forEach var = "i" begin = "1" end = "${invoice.product.score}">
                                                            <span class="fa fa-star fa-2x checked"></span>
                                                        </c:forEach>
                                                        <c:forEach var = "i" begin = "1" end = "${invoice.product.resto}">
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
                                            <span class="h5 text-muted"><c:out value ="${invoice.product.category}"/></span>
                                        </div>

                                        <div class="col-3 m-auto py-2 text-nowrap">
                                            <span class="h5 text-muted"><c:out value ="${invoice.product.brand}"/></span>
                                        </div>

                                    </div>

                                    <!--Tercera fila. Contiene features-->
                                    <div class="row ">
                                        <ul class="list-inline">
                                            <!--Hacer con un foreEach-->
                                            <c:forEach var = "feature" items="${invoice.product.features}">
                                                <li class="list-inline-item jumbotron mx-1 my-3 py-1 px-3 text-center"><c:out value ="${feature}"/></li>
                                            </c:forEach>
                                        </ul>
                                    </div>

                                    <!--Cuarta fila. Precio-->
                                    <div class="row">
                                        <span class="h6 px-2">Precio: <fmt:formatNumber pattern="#,##0.00 €" value="${invoice.product.ogPrice}"/></span>
                                        <span class="h6 px-2">Oferta:</span>
                                        <c:choose>
                                            <c:when test = "${invoice.product.freeDeliver}">
                                                <span class="h6 px-2" style="color:red">Envío gratuíto</span>
                                            </c:when>
                                            <c:when test = "${invoice.product.offer != 0}">
                                                <span class="h6 px-2" style="color:red"><fmt:formatNumber pattern="#%" value="${invoice.product.offer}"/></span>
                                                <span class="h6 px-2" style="color:red">Nuevo Precio: <fmt:formatNumber pattern="#,##0.00 €" value="${invoice.product.newPrice}"/></span>
                                                <span class="h6 px-2" style="color:red">Envío 4 €</span>
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
                                                <label>Usuario: <a href="LoadAllUser?name=${invoice.user.name.replace(' ','-')}" > <c:out value ="${invoice.user.name}"/> </a></label>
                                            </li>

                                            <li class="list-inline-item text-center">
                                                <label>Fecha de compra:  <c:out value ="${invoice.date2string()}"/></label>
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
        <c:if test="${empty requestScope.invoices}">
            <label style="color: red; text-align: center">No hay ningún producto en el carrito.</label>
        </c:if>
    </div>

    <!--Filtros pantalla grande-->
    <div class="col-lg-3 p-0 border-right justify-content-center d-none d-lg-block">
        <div class="col-11 mx-auto mt-5">
            <h1 class="text-center py-3 mt-5 "><strong>Computo global</strong></h1>
            <h5>Número de productos vendidos: <c:out value="${requestScope.numVentas}"/></h5>
            <h5>Valor neto: <fmt:formatNumber pattern="#,##0.00 €" value="${requestScope.total}"/></h5>
            <button type="submit" class="btn btn-dark mt-5" onclick="getDatos('./LoadInvoices','bodyInvoices');">Actualizar</button>
        </div>
    </div>
</div>
<script src="./js/petAsinc.js"></script>
<jsp:include page="jsSources.jsp"/>
</body>
</html>
