<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 19/04/2020
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <jsp:include page="head.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>User info · Kosmetics </title>
</head>
<body>
<jsp:include page="cabeceraSinAjax.jsp"/>
<div class="container">
    <div class = "row">
        <div class="col-12 py-3 justify-content-center ">
            <div class="row">
                <div class="img-fluid col-9 col-sm-4 p-7 mt-4 mx-auto ">
                    <div class="row">
                        <!--<img src = ".\media\inicio_sesion_fondo.jpg" class="rounded-circle img-fluid p-4">-->
                        <c:if test="${requestScope.user.imagen}">
                            <img src="ReadImg?name=${requestScope.user.name.replace(' ','-')}" class="img img-rounded img-fluid d-none d-md-block rounded-circle">
                        </c:if>
                        <c:if test="${requestScope.user.imagen == false}">
                            <span class="rounded-circle icono imgUserInfo m-auto"><c:out value ="${requestScope.user.iniciales}"/></span>
                        </c:if>
<%--                        <span class="rounded-circle icono imgUserInfo m-auto"><c:out value ="${sessionScope.user.iniciales}"/></span>--%>
                    </div>
                </div>
                <div class="col-8 px-0 mt-5 mx-auto d-flex justify-content-right">

                    <div class="col-12 px-0">
                        <div class="row">
                            <div class="col-8">
                                <span class="display-4 nameUserInfo"><strong><c:out value ="${requestScope.user.name}"/></strong></span>
                            </div>
                            <div class="col-4">
                                <c:if test="${requestScope.user.equals(sessionScope.user)}">
                                    <form action="editar_perfil_usuario.jsp" method = "POST">
                                        <button type="submit" class="btn btn-outline-dark">Editar perfil</button>
                                    </form>
                                </c:if>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 pt-2">
                                <span class="font-weight-bold py-2">Piel <c:out value ="${requestScope.user.skinCondition}"/></span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 pt-2">
                                <span class="font-weight-bold py-2"><c:out value ="${requestScope.user.edad}"/> años</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 pt-2">
                                <span class="rounded-circle icono colorIcon ml-0" style="background: saddlebrown"> </span>

                            </div>
                        </div>

                    </div>

                </div>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-12">
            <nav>
                <div class="nav nav-tabs" id="nav-tab" role="tablist">
                    <a class="nav-item nav-link active" id="nav-buy-tab" data-toggle="tab" href="#nav-buy" role="tab" aria-controls="nav-buy" aria-selected="true">Últimas compras</a>
                    <a class="nav-item nav-link" id="nav-reviews-tab" data-toggle="tab" href="#nav-reviews" role="tab" aria-controls="nav-reviews" aria-selected="false">Reviews</a>
                </div>
            </nav>
            <div class="tab-content" id="nav-tabContent">
                <!--Productos comprados-->
                <div class="tab-pane fade show active" id="nav-buy" role="tabpanel" aria-labelledby="nav-buy-tab">
                    <!--Contenedor de un producto. Iterar para todos los productos-->
                    <c:forEach var = "product" items="${requestScope.compras}">
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
                                            <!--Hacer con un foreEach-->
                                            <c:forEach var = "feature" items="${product.features}">
                                                <div class="jumbotron mx-auto my-3 py-1 px-3 text-center">
                                                    <p class="my-0"><c:out value ="${feature}"/></p>
                                                </div>
                                            </c:forEach>

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
                <!--Review-->
                <div class="tab-pane fade" id="nav-reviews" role="tabpanel" aria-labelledby="nav-reviews-tab">
                    <!--Contenedor review-->
                    <c:forEach var = "review" items="${requestScope.reviews}">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-2 pb-2">
                                        <c:if test="${review.user.imagen}">
                                            <img src="ReadImg?name=${review.user.name.replace(' ','-')}" class="img img-rounded img-fluid d-none d-md-block">
                                        </c:if>
                                        <c:if test="${review.user.imagen == false}">
                                            <img src="./media/profile.jpg" class="img img-rounded img-fluid d-none d-md-block">
                                        </c:if>
                                        <span class="text-secondary pl-1 text-center"><c:out value ="${review.user.name}"/></span>
                                        <span class="text-secondary pl-1 text-center"><c:out value ="${review.date2string()}"/></span>
                                    </div>
                                    <div class="col-md-10">
                                        <p>
                                            <span class="float-left h5" ><strong><c:out value ="${review.commentTitle}"/></strong></span>
                                            <c:forEach var = "i" begin = "1" end = "${review.gerScoreResto()}">
                                                <span class="float-right fa fa-star fa-lg"></span>
                                            </c:forEach>
                                            <c:forEach var = "i" begin = "1" end = "${review.productScore}">
                                                <span class="float-right fa fa-star fa-lg checked"></span>
                                            </c:forEach>
                                        </p>
                                        <div class="clearfix"></div>
                                        <p>${review.comment}</p>
<%--                                        <p>--%>
<%--                                                <span class="float-left h5" ><strong>5<span style="color: red">--%>
<%--                                                    ♥</span></strong></span>--%>
<%--                                            <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>--%>
<%--                                        </p>--%>
                                    </div>
                                </div>
                                    <%--<div class="card card-inner">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-2">
                                                    <img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid">
                                                    <p class="text-secondary text-center">15 Minutes Ago</p>
                                                </div>
                                                <div class="col-md-10">
                                                    <p><a href="https://maniruzzaman-akash.blogspot.com/p/contact.html"><strong>Maniruzzaman Akash</strong></a></p>
                                                    <p>Lorem Ipsum is simply dummy text of the pr make  but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                                                    <p>
                                                        <a class="float-right btn btn-outline-primary ml-2">  <i class="fa fa-reply"></i> Reply</a>
                                                        <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>--%>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>

        </div>
    </div>

</div>

<jsp:include page="jsSources.jsp"/>
</body>
</html>
