<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 03/05/2020
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>

    <jsp:include page="head.jsp"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Crear tu review · Kosmetics </title>
</head>
<body>
<c:if test="${empty sessionScope.user}">
    <jsp:forward page="./inicio_sesion_usuario.jsp"></jsp:forward>
</c:if>
<jsp:include page="cabecera.jsp"/>
    <div class="row justify-content-center">

        <div class="col-11 mx-auto mt-5">

            <div class="row">
                <div class="mb-3 pl-3">
                    <h1 class="text-center  "><strong>
                        Finalzar tu pedido!!
                    </strong></h1>

                </div>
            </div>
            <!--Informacion del envio-->
            <div class="row">
                <div class="mb-6 pl-3">
                    <p>Precio final: <fmt:formatNumber pattern="#,##0.00 €" value="${sessionScope.carrito.total}"/>
                        Envio: <fmt:formatNumber pattern="#,##0.00 €" value="${sessionScope.carrito.envio}"/>
                        Total: <fmt:formatNumber pattern="#,##0.00 €" value="${sessionScope.carrito.totalPedido}"/>
                    </p>

                </div>
            </div>
            <div class="row">
                <div class="col-12 mb-3 pl-3">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" placeholder="C/ Luis Jorge Castaños 23. 4º-2ª; Urbanización Las Cascajuelas; 28999 Valdecillas de Jarama, Madrid"g required="">
                    <div class="invalid-feedback">
                        Por favor intruduzca la direccion de entrega.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="cc-name">Nombre completo</label>
                    <input type="text" class="form-control" id="cc-name" value="<c:out value="${sessionScope.user.name}"/>" placeholder="" required="">

                </div>
                <div class="col-md-6 mb-3">
                    <label for="cc-number">Número bancario</label>
                    <input type="text" class="form-control" id="cc-number" placeholder="" required="">
                    <div class="invalid-feedback">
                        Por favor intruduzca el número de la tarjeta.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 mb-3">
                    <label for="cc-expiration">Fecha de caducidad</label>
                    <input type="date" name = "birthDate" class="form-control"id="caducidad"
                    value="2020-04-2"
                    min="2020-04-11" max="2030-12-31">
                    <div class="invalid-feedback">
                        Por favor intruduzca la fecha de caducidad de la tarjeta.
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <label for="cc-cvv">CVV</label>
                    <input type="number" step="1" min="1" max="999" class="form-control" id="cc-cvv" placeholder="" required="">
                    <div class="invalid-feedback">
                        Por favor intruduzca el CVV.
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <form action="GenerateInvoice" method="POST" onsubmit="return validarCompra();">
                    <button class="btn btn-info my-2 mx-2 my-sm-0" type="submit" >Pagar</button>
                </form><br>
                <span style="color: red;justify-content: center;text-align: center" id="error"></span>
            </div>
        </div>
    </div>
<jsp:include page="jsSources.jsp"/>
</body>
</html>
