<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 03/05/2020
  Time: 13:52
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
                    <p>Precio final: 3 € Coste envio: 3 Tiempo estimado: ...</p>

                </div>
            </div>
            <div class="row">
                <div class="col-12 mb-3 pl-3">
                    <label for="address">Address</label>
                    <input type="text" class="form-control" id="address" placeholder="C/ Luis Jorge Castaños 23. 4º-2ª; Urbanización Las Cascajuelas; 28999 Valdecillas de Jarama, Madrid"g required="">
                    <div class="invalid-feedback">
                        Please enter your shipping address.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="cc-name">Nombre completo</label>
                    <input type="text" class="form-control" id="cc-name" placeholder="" required="">

                </div>
                <div class="col-md-6 mb-3">
                    <label for="cc-number">Número bancario</label>
                    <input type="text" class="form-control" id="cc-number" placeholder="" required="">

                </div>
            </div>
            <div class="row">
                <div class="col-md-3 mb-3">
                    <label for="cc-expiration">Fecha de caducidad</label>
                    <input type="text" class="form-control" id="cc-expiration" placeholder="" required="">

                </div>
                <div class="col-md-3 mb-3">
                    <label for="cc-cvv">CVV</label>
                    <input type="text" class="form-control" id="cc-cvv" placeholder="" required="">
                </div>
            </div>
            <div class="row justify-content-center">
                <button type="submit" class="col-5 btn btn-dark mt-5 px-5">Pagar</button>
            </div>
        </div>
    </div>
<jsp:include page="jsSources.jsp"/>
</body>
</html>
