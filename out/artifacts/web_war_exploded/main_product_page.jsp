
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%@include file="head.jsp"%>
    <title>Página principal · Kosmetics </title>
</head>
<body>
    <%@include file="cabecera.jsp"%>
    <div class="row">
        <div class="col-xl-3 col-md-4 p-0 border-right justify-content-center d-none d-md-block">
            <div class="col-9 m-auto">

                <h4 class="text-left pt-5 pb-1 px-3">Filtros</h4>
                <label for="customRange1">Precio</label>
                <input type="range" class="custom-range" id="customRange1">

                <h4 class="text-left pt-5 pb-1 px-3">Características</h4>
                <div class="custom-control custom-checkbox">

                    <div class="row">
                        <input type="checkbox" class="custom-control-input" id="caracteristicas1">
                        <label class="custom-control-label" for="caracteristicas1">leer de la BD</label>
                    </div>

                    <div class="row">
                        <input type="checkbox" class="custom-control-input" id="caracteristicas2">
                        <label class="custom-control-label" for="caracteristicas2">leer de la BD</label>
                    </div>

                </div>

                <h4 class="text-left pt-5 pb-1 px-3">Marca</h4>
                <div class="custom-control custom-checkbox">
                    <div class="row">
                        <input type="checkbox" class="custom-control-input" id="marca1">
                        <label class="custom-control-label" for="marca1">leer de la BD</label>
                    </div>

                    <div class="row">
                        <input type="checkbox" class="custom-control-input" id="marca2">
                        <label class="custom-control-label" for="marca2">leer de la BD</label>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-12 col-md-8 col-xl-9" >

            Producto
        </div>
    </div>
        <%@include file="jsSources.jsp"%>

</body>
</html>
