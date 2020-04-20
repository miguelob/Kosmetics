<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 20/04/2020
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@include file="head.jsp"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Crear tu review · Kosmetics </title>
</head>
<body>
<%@include file="cabecera.jsp"%>
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
        <div class="col-12 col-lg-6 col-md-9 px-0 text-center">
            <div class="col-12 px-0">

                <!--Nombre del producto-->
                <div class="row ">
                    <div class="col-12 text-left">
                        <h2>Hello Happy Foundation</h2>
                    </div>
                </div>

                <!--Estrellas -->
                <div class="row justify-content-center">
                    <div class="col-11 py-3 ">
                        <div class="row">
                            <span class="fa fa-star fa-2x checked"></span>
                            <span class="fa fa-star fa-2x checked"></span>
                            <span class="fa fa-star fa-2x  checked"></span>
                            <span class="fa fa-star fa-2x "></span>
                            <span class="fa fa-star fa-2x "></span>
                        </div>
                    </div>
                </div>

                <form class="justify-content-center">
                    <!--Texto -->
                    <div class="form-group">
                        <textarea class="form-control" placeholder="Ponle un título a tu review" rows="1"></textarea>
                    </div>

                    <div class="form-group">
                        <textarea class="form-control" placeholder="Cuentanos tu experiencia!" rows="4"></textarea>
                    </div>

                    <div class="form-group ">
                    <!--Preguntas-->
                    <c:forEach var = "i" begin = "1" end = "5">
                        <div class="row">
                            <div class="col-12">
                                <div class="row py-1 d-flex justify-content-center">
                                    <div class="col-7">
                                        <div class="form-check m-auto pr-4 ">
                                            <span class="font-italic">¿Tiene un acabado natural?</span>
                                        </div>
                                    </div>
                                    <div class="col-5">
                                        <div class="form-check form-check-inline ">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                            <label class="form-check-label text-muted" for="inlineRadio1">Si</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                            <label class="form-check-label text-muted" for="inlineRadio2">No</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option2">
                                            <label class="form-check-label text-muted" for="inlineRadio2">Sin opinión</label>
                                        </div>
                                    </div>
                                        <%--<div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
                                            <label class="form-check-label text-muted" for="inlineRadio1">Si</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
                                            <label class="form-check-label text-muted" for="inlineRadio2">No</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option2">
                                            <label class="form-check-label text-muted" for="inlineRadio2">Sin opinión</label>
                                        </div>--%>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </div>

                    <div class="row justify-content-center">
                        <button type="submit" class="col-8 btn btn-outline-dark">Enviar opinión</button>
                    </div>

                </form>


            </div>
        </div>
    </div>
</div>

<jsp:include page="jsSources.jsp"/>
</body>
</html>
