<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 18/04/2020
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@include file="head.jsp"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Información del producto · Kosmetics </title>
</head>
<body>

    <%@include file="cabecera.jsp"%>

    <div class = "container">
        <div class = "row d-flex justify-content-center">
            <div class="col-lg-11 pt-5 ">
                <div class="row d-flex justify-content-center">
                    <!--Imagen del producto pantallas grandes-->
                    <div class="img-fluid col-lg-6 p-7 pt-0 d-none d-lg-block">
                        <div class="row">
                            <!--<img src = ".\media\inicio_sesion_fondo.jpg" class="rounded-circle img-fluid p-4">-->
                            <img src="media/prueba_cuadrada.jpg" class="img-fluid px-4 pt-0">

                        </div>

                    </div>
                    <!--Info principal producto-->
                    <div class="col-12 col-lg-6 col-md-9 px-0 d-flex justify-content-center text-center">
                        <div class="col-lg-9 px-0">
                            <!--Nombre del producto-->
                            <div class="row text-center">
                                <h2>Hello Happy Foundation</h2>
                            </div>

                            <!--Descripcipción -->
                            <div class="row text-justify">
                                    <span class="text-muted py-3 m-auto">Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de texto.
                                    </span>
                            </div>

                            <!--Imagen del producto pantallas pequeñas-->
                            <div class="row d-flex justify-content-center">
                                <div class="img-fluid col-10  d-lg-none">

                                    <!--<img src = ".\media\inicio_sesion_fondo.jpg" class="rounded-circle img-fluid p-4">-->
                                    <img src="media/prueba_cuadrada.jpg" class="img-fluid  ">

                                </div>
                            </div>

                            <!--precio y oferta-->
                            <div class="row py-2 d-flex justify-content-center">
                                <div class="col-12 m-auto py-2 d-flex justify-content-center text-nowrap">
                                    <span class="h5 px-4 text-muted m-auto">Precio: 33,95€      </span>
                                    <span class="h5 px-4 text-muted m-auto">Oferta: -20% </span>
                                </div>
                            </div>

                            <!--Colores disponibles y MARCA-->
                            <div class="row py-4 justify-content-center">

                                <div class="col-3 m-auto py-2 text-nowrap text-center">
                                    <!--añadirrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr IMAGEN MARCA-->
                                    <span class="h5 font-weight-bold">BENEFIT</span>
                                </div>


                                <!-- colores disponibles -->
                                <div class="form-group col-6 m-auto">
                                    <span class="h6">colores disponibles: </span>
                                    <select class="custom-select">
                                        <option selected="">  </option>
                                        <option value="1" style="background: #fdeec7">      </option>
                                        <option value="2" style="background: #fee1b9">      </option>
                                        <option value="3" style="background: #fcbd84">      </option>
                                        <option value="4" style="background: #a87256; color:white">      </option>
                                        <option value="5" style="background: #633c1d; color:white">      </option>
                                    </select>
                                    <!--<label for="tono_producto">colores disponibles</label>
                                    <select id="tono_producto" class="custom-select" >
                                        <option selected>  </option>
                                        <option value="1" style="background: #fdeec7">      </option>
                                        <option value="2" style="background: #fee1b9">      </option>
                                        <option value="3" style="background: #fcbd84">      </option>
                                        <option value="4" style="background: #a87256; color:white">      </option>
                                        <option value="5" style="background: #633c1d; color:white">      </option>
                                    </select>-->
                                </div>

                            </div>

                            <div class="row justify-content-center">
                                  <button type="submit" class="col-8 btn btn-dark">Comprar</button>
                            </div>
                            <!--Estrellas -->
                            <!--
                            <div class="row justify-content-center">
                                <div class="col-6 py-3 m-auto">
                                    <div class="row justify-content-center">

                                        <span class="fa fa-star fa-2x checked"></span>
                                        <span class="fa fa-star fa-2x checked"></span>
                                        <span class="fa fa-star fa-2x  checked"></span>
                                        <span class="fa fa-star fa-2x "></span>
                                        <span class="fa fa-star fa-2x "></span>

                                    </div>
                                </div>
                                <div class="col-3 py-3 m-auto">
                                    <form class="form-group my-0 mx-auto">
                                        <button type="submit" class="btn btn-dark btn-block ">Opinar</button>
                                    </form>
                                </div>
                            </div>
                            -->





                        </div>
                    </div>
                </div>


            </div>
            <div class="col-lg-11 pt-5 ">
                <div class="row">
                    <div class="col-12 pb-5 ">
                        <!--Opinión-->
                        <div class="row">
                            <!--Valoración clientes-->
                            <div class="col-12 col-lg-5 pl-0 m-auto">

                                <div class="row justify-content-center">
                                    <div class="col-5 py-3 m-auto">
                                        <div class="row justify-content-center">

                                            <span class="fa fa-star fa-2x checked"></span>
                                            <span class="fa fa-star fa-2x checked"></span>
                                            <span class="fa fa-star fa-2x  checked"></span>
                                            <span class="fa fa-star fa-2x "></span>
                                            <span class="fa fa-star fa-2x "></span>

                                        </div>
                                    </div>
                                    <div class="col-4 col-xl-3 py-3 m-auto">
                                        <form class="form-group my-0 mx-auto">
                                            <button type="submit" class="btn btn-outline-dark btn-block ">Opinar</button>
                                        </form>
                                    </div>
                                    <div class="col-1">

                                    </div>
                                </div>
                                <div class="row justify-content-center">
                                    <div class="col-4 ml-auto text-center font-weight-bold">

                                        <span class="display-3 d-xl-block">4,3</span>
                                        <br>
                                        <span class="h7">73 reviews</span>
                                    </div>
                                    <div class="col-6 mr-auto">
                                    <c:forEach var = "i" begin = "1" end = "5">
                                        <div class="row justify-content-center">
                                            <div class="col-1 px-0 m-auto text-center">
                                                <span class="h7">${i}</span>
                                            </div>
                                            <div class="col-11 px-0 m-auto">
                                                <div class="progress" style="height: 18px;">
                                                    <div class="progress-bar" role="progressbar" style= "width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>

                                    </div>
                                    <div class="col-xl-1 ">

                                    </div>
                                </div>
                            </div>

                            <!--Features-->
                            <div class="col-8 col-lg-5 pl-0 pt-4 pt-lg-0  m-auto align-self-center">
                                <div class="row px-4 pt-2">
                                    <span class="h3 text-muted">Fiabilidad características</span>
                                </div>
                                    <c:forEach var = "i" begin = "1" end = "4">

                                    <div class="row justify-content-center">
                                        <div class="col-4 px-0 m-auto text-center">
                                            <span class="h6">Acabado natural</span>
                                        </div>
                                        <div class="col-7 pl-0 py-1 m-auto">
                                            <div class="progress" style="height: 19px;">
                                                <div class="progress-bar" role="progressbar" style="width: 15%" aria-valuenow="15" aria-valuemin="0" aria-valuemax="100"></div>
                                                <div class="progress-bar bg-success" role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                        <div class="col-xl-1"></div>
                                    </div>

                                    </c:forEach>

                            </div>
                        </div>

                    </div>
                </div>
            </div>

        <!--Reviews-->
        <div class="row">
            <div class="col-12">
                <nav>
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Reviews</a>
                        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Información del producto</a>
                    </div>
                </nav>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active mr-xl" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">

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
            <!--OTRAS VENTANAS-->
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de texto.
                        Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de texto.
                        Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de texto.
                        Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de texto.
                        Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de texto.

                    </div>

                </div>
            </div>
        </div>

    </div>
    <%@include file="jsSources.jsp"%>
</body>
</html>
