<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>Usuario · Kosmetics</title>

</head>
<body>

    <%@include file="cabecera.jsp"%>
    <div class="row d-flex justify-content-center">
        <div class="col-12 col-lg-11 col-xl-10 d-flex justify-content-center">
            <div class = "img-fluid col-lg-4 col-sm-5 d-none d-sm-block">
                <div class="row">
                    <!--<img src = ".\media\inicio_sesion_fondo.jpg" class="rounded-circle img-fluid p-4">-->
                    <span class="rounded-circle icono m-auto">MT</span>
                </div>
                <div class="row justify-content-center">
                    <small class="form-text text-muted mt-3"><a class="p-2 text-dark" href="registro_usuario.jsp">cambiar imagen de perfil</a></small>
                </div>

            </div>
            <div class="col-12 col-lg-8 col-sm-7 d-flex justify-content-center">

                <div class = "col-sm-9 px-">
                    <form>
                        <div class="form-group">
                            <label for="userInputName">nombre de usuario</label>
                            <input placeholder="mostrar valor actual" type="text" class="form-control" id="userInputName" aria-describedby="emailHelp">
                        </div>
                        <div class="form-group">
                            <label for="userInputEmail">correo electrónico</label>
                            <input placeholder="mostrar valor actual" type="email" class="form-control" id="userInputEmail">
                        </div>
                        <div class="form-group">
                            <label for="userInputPassword">contraseña</label>
                            <input type="password" class="form-control" id="userInputPassword">
                        </div>
                        <div class="form-group">
                            <label for="userInputPasswordRepit">repetir la contraseña</label>
                            <input type="password" class="form-control" id="userInputPasswordRepit">
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <%@include file="jsSources.jsp"%>
</body>
</html>
