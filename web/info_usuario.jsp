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

    <%@include file="head.jsp"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Crear tu review · Kosmetics </title>
</head>
<body>
<%@include file="cabecera.jsp"%>
<div class="container">
    <div class = "row">
        <div class="col-12 py-3 d-flex justify-content-center">
                <div class = "img-fluid col-4 p-7 mt-4 ">
                    <div class="row">
                        <!--<img src = ".\media\inicio_sesion_fondo.jpg" class="rounded-circle img-fluid p-4">-->
                        <span class="rounded-circle icono userImg m-auto">MT</span>
                    </div>
                </div>
                <div class="col-8 px-0 py-5 d-flex justify-content-right">

                    <div class = "col-12 px-0">
                        <div class="row">
                            <div class="col-8">
                                <span class="display-4" ><strong>Milo Tatch</strong></span>
                            </div>
                            <div class="col-4">
                                <form>
                                    <button type="button" class="btn btn-outline-dark">Editar perfil</button>
                                </form>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <span class="font-weight-bold py-2" >Piel mixta</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <span class="font-weight-bold py-2" >25 años</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                    <span class="rounded-circle icono colorIcon ml-0" style="color: saddlebrown"> </span>

                            </div>
                        </div>

                    </div>

                </div>

        </div>
    </div>
</div>

<%@include file="jsSources.jsp"%>
</body>
</html>
