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
        <div class = "row">
            <div class="col-lg-11 pt-5 d-flex justify-content-center">
                    <!--Imagen del producto-->
                    <div class = "img-fluid col-xl-6 p-7 pt-0 d-none d-xl-block">
                        <div class="row">
                            <!--<img src = ".\media\inicio_sesion_fondo.jpg" class="rounded-circle img-fluid p-4">-->
                            <img src="media/prueba_cuadrada.jpg" class="img-fluid px-4 pt-0">

                        </div>

                    </div>
                    <!--Info principal producto-->
                    <div class="col-12 col-xl-6 px-0 d-flex justify-content-center text-center">
                        <div class = "col-lg-9 px-0">
                            <!--Nombre del producto-->
                            <div class="row text-center">
                                <h2>Hello Happy Foundation</h2>
                            </div>

                            <!--Descripcipción -->
                            <div class="row text-justify">
                                    <span class="text-muted py-3 m-auto">Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de texto.
                                    </span>
                            </div>
                            <!--Estrellas -->
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

                            <!-- colores disponibles -->
                            <div class="form-group col-8">
                                <label for="tono_producto">colores disponibles</label>
                                <select id="tono_producto" class="custom-select" >
                                    <option selected>  </option>
                                    <option value="1" style="background: #fdeec7">      </option>
                                    <option value="2" style="background: #fee1b9">      </option>
                                    <option value="3" style="background: #fcbd84">      </option>
                                    <option value="4" style="background: #a87256; color:white">      </option>
                                    <option value="5" style="background: #633c1d; color:white">      </option>
                                </select>
                            </div>



                        </div>

                    </div>
            </div>
        </div>

        <div class="row">
            <div class="col-12 pb-5 d-flex justify-content-center">

                    <h5 class="text-muted py-3">Información adicional </h5>

                    <form>
                        <div class="form-row">
                            <div class="col-2 text-center">
                                <span class="display-3">4,3</span>
                                <br>
                                <span class="h7">(73 reviews)</span>
                            </div>
                            <div class="form-group col-5">
                            <c:forEach var = "i" begin = "1" end = "5">
                                <div class="row justify-content-center">
                                    <div class="col-1 px-0 m-auto text-center">
                                        <span class="h7">${i}</span>
                                    </div>
                                    <div class="col-11 pl-0 m-auto">
                                        <div class="progress" style="height: 18px;">
                                            <div class="progress-bar" role="progressbar" style= "width: 25%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>

                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="genero">género</label>
                                <select id="genero" class="custom-select">
                                    <option selected>mostrar valor actual</option>
                                    <option value="1" >Mujer</option>
                                    <option value="2" >Hombre</option>
                                    <option value="3" >Prefiero no decirlo</option>
                                    <option value="4" >Otro</option>
                                </select>
                            </div>

                            <div class="form-group col-md-9">
                                <label for="userInputDireccion">Dirección</label>
                                <input placeholder="C/ Luis Jorge Castaños 23. 4º-2ª; Urbanización Las Cascajuelas; 28999 Valdecillas de Jarama, Madrid" type="text" class="form-control" id="userInputDireccion" aria-describedby="emailHelp">
                            </div>

                        </div>
                        <div class="form-group col-md-10 mx-auto">
                            <button type="submit" class="btn btn-dark btn-block mt-5">Actualizar</button>
                        </div>
                    </form>

            </div>
        </div>

    </div>
    <%@include file="jsSources.jsp"%>
</body>
</html>
