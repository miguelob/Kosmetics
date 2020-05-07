<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 20/04/2020
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <jsp:include page="head.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Crear tu review · Kosmetics </title>
</head>
<body>
<jsp:include page="cabecera.jsp"/>
<div class="col-lg-11 pt-5 ">
    <div class="row d-flex justify-content-center">
        <!--Imagen del producto pantallas grandes-->
        <div class="img-fluid col-lg-6 p-7 pt-0 d-none d-lg-block">
            <div class="row">
                <!-- <img src = ".\media\prueba_cuadrada.jpg" class="img img-fluid p-4">-->
                <img src="ReadImg?id=${sessionScope.allProduct.id}" class="img-fluid px-4 pt-0">

            </div>

        </div>
        <!--Info principal producto-->
        <div class="col-12 col-lg-6 col-md-9 px-0 text-center">
            <div class="col-12 px-0">

                <!--Nombre del producto-->
                <div class="row justify-content-center">
                    <div class="col-12 col-lg-6 text-left">
                        <h2><c:out value="${sessionScope.allProduct.name}"/></h2>
                    </div>
                    <div class="col-11 col-lg-5 py-3 ">
                        <div class="row">
                            <c:forEach var = "i" begin = "1" end = "${sessionScope.allProduct.score}">
                                <span class="fa fa-star fa-2x checked"></span>
                            </c:forEach>
                            <c:forEach var = "i" begin = "1" end = "${sessionScope.allProduct.resto}">
                                <span class="fa fa-star fa-2x "></span>
                            </c:forEach>
                        </div>
                    </div>
                </div>


                <form id="createReviewForm" class="justify-content-center" action="creatReview" method="POST" onsubmit="return validarReview();">
                    <!--Estrellas -->
                    <div class="form-group justify-content-center row">
                        <label for="selectEstrellas" class="col-sm-2 col-form-label">Estrellas</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="selectEstrellas" name="estrellas">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>


                    <!--Texto -->
                    <div class="form-group row">
                        <textarea  id="tituloReview" form="createReviewForm" class="form-control" placeholder="Ponle un título a tu review" rows="1" name="titulo"></textarea>
                    </div>

                    <div class="form-group row">
                        <textarea id="textReview" form="createReviewForm" class="form-control" placeholder="Cuentanos tu experiencia!" rows="4" name="comentario"></textarea>
                    </div>

                    <div class="form-group row">
                    <!--Preguntas-->
                    <c:forEach var = "question" items="${sessionScope.allProduct.survey.questions}">
                        <div class="row">
                            <div class="col-12">
                                <div class="row py-1 d-flex justify-content-center">
                                    <div class="col-7 col-lg-6 col-xl-7">
                                        <div class="form-check m-auto pr-4 ">
                                            <span class="font-italic"><c:out value ="${question.questionText}"/></span>
                                        </div>
                                    </div>
                                    <div class="col-5 col-lg-6 col-xl-5">
                                        <div class="form-check form-check-inline ">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions@${question.idQuestion}" id="inlineRadio1" value="Si">
                                            <label class="form-check-label text-muted" for="inlineRadio1">Si</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions@${question.idQuestion}" id="inlineRadio2" value="No">
                                            <label class="form-check-label text-muted" for="inlineRadio2">No</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input class="form-check-input" type="radio" name="inlineRadioOptions@${question.idQuestion}" id="inlineRadio3" value="NS/NC">
                                            <label class="form-check-label text-muted" for="inlineRadio2">NS/NC</label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                    </div>

                    <div class="row justify-content-center">
                        <button type="submit" class="col-8 btn btn-outline-dark" name="btn">Enviar opinión</button>
                    </div>

                </form>


            </div>
        </div>
    </div>
</div>

<jsp:include page="jsSources.jsp"/>
</body>
</html>
