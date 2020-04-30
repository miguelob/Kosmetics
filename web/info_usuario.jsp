<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 19/04/2020
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="head.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Crear tu review · Kosmetics </title>
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
                        <span class="rounded-circle icono imgUserInfo m-auto">MT</span>
                    </div>
                </div>
                <div class="col-8 px-0 mt-5 mx-auto d-flex justify-content-right">

                    <div class="col-12 px-0">
                        <div class="row">
                            <div class="col-8">
                                <span class="display-4 nameUserInfo"><strong>Milo Tatch</strong></span>
                            </div>
                            <div class="col-4">
                                <form action="editar_perfil_usuario.jsp" method="post">
                                    <button type="button" class="btn btn-outline-dark">Editar perfil</button>
                                </form>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 pt-2">
                                <span class="font-weight-bold py-2">Piel mixta</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 pt-2">
                                <span class="font-weight-bold py-2">25 años</span>
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
                    <a class="nav-item nav-link active" id="nav-fav-tab" data-toggle="tab" href="#nav-fav" role="tab" aria-controls="nav-fav" aria-selected="true">Productos favoritos</a>
                    <a class="nav-item nav-link" id="nav-buy-tab" data-toggle="tab" href="#nav-buy" role="tab" aria-controls="nav-buy" aria-selected="false">Últimas compras</a>
                    <a class="nav-item nav-link" id="nav-reviews-tab" data-toggle="tab" href="#nav-reviews" role="tab" aria-controls="nav-reviews" aria-selected="false">Reviews</a>
                </div>
            </nav>
            <div class="tab-content" id="nav-tabContent">
                <!--Productos fav-->
                <div class="tab-pane fade show active" id="nav-fav" role="tabpanel" aria-labelledby="nav-fav-tab">

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
                <!--Productos comprados-->
                <div class="tab-pane fade" id="nav-buy" role="tabpanel" aria-labelledby="nav-buy-tab">
                    <!--Contenedor de un producto. Iterar para todos los productos-->
                    <c:forEach var = "i" begin = "1" end = "3">

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
                <!--Review-->
                <div class="tab-pane fade" id="nav-reviews" role="tabpanel" aria-labelledby="nav-reviews-tab">
                    <!--Contenedor review-->
                    <c:forEach var = "i" begin = "1" end = "4">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-2 pb-2">
                                        <a href="info_usuario.jsp"><img src="media/prueba_cuadrada.jpg" class="img img-rounded img-fluid d-none d-md-block"></a>
                                        <!--<span class="rounded-circle icono m-auto">MT</span>-->
                                        <span class="text-secondary pl-1 text-center"><a href="info_usuario.jsp">Milo Tatch</a></span>
                                        <span class="text-secondary pl-1 text-center">12/04/2020</span>
                                    </div>
                                    <div class="col-md-10">
                                        <p>
                                            <span class="float-left h5" ><strong>Gran relación claidad-precio!!</strong></span>
                                            <span class="float-right fa fa-star fa-lg "></span>
                                            <span class="float-right fa fa-star fa-lg checked"></span>
                                            <span class="float-right fa fa-star fa-lg checked"></span>
                                            <span class="float-right fa fa-star fa-lg checked"></span>
                                            <span class="float-right fa fa-star fa-lg checked"></span>
                                            <!-- <span class="fa fa-star fa-2x checked"></span>
                                             <span class="fa fa-star fa-2x checked"></span>
                                             <span class="fa fa-star fa-2x  checked"></span>
                                             <span class="fa fa-star fa-2x "></span>
                                             <span class="fa fa-star fa-2x "></span>
    -->
                                        </p>
                                        <div class="clearfix"></div>
                                        <p>Lorem Ipsum is simply dummy text of the pr make  but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
                                        <p>
                                                <span class="float-left h5" ><strong>5<span style="color: red">
                                                    ♥</span></strong></span>
                                            <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>
                                        </p>
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
