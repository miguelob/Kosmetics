
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="es-es">
<head>
    <jsp:include page="head.jsp"/>
   <title>Iniciar sesión · Kosmetics</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row p-0 justify-content-center">
            <img id="registro-inicio_img" src = "media/inicio_sesion_fondo.jpg" class="img-fluid col-lg-6 p-0 d-none d-xl-block">
            <div class="col-12 col-xl-6 py-5 d-flex justify-content-center">
                <div class = "col-lg-8">
                    <h1 class="text-center pt-5">Login</h1>
                    <h4 class="text-center text-muted py-3">¡Descubre las novedades más asombrosa!</h4>
                    <form method = "POST" action = "Login" onsubmit="return validarLogin();">
                        <div class="form-group">
                            <label for="userInputName">correo electrónico / nombre de usuario</label>
                            <input type="text" class="form-control" id="userInputName" aria-describedby="emailHelp" name = "userOrEmail">
                        </div>
                        <div class="form-group">
                            <label for="userInputPassword">Contraseña</label>
                            <input type="password" class="form-control" id="userInputPassword" name = "password">
                        </div>
                        <div id = "error"><c:out value="${requestScope.error}"/></div>
                        <button type="submit" class="btn btn-dark btn-block mt-5">Iniciar sesión</button>
                        <small class="form-text text-muted mt-3">¿Aun no tienes cuenta? <a class="p-2 text-dark" href="registro_usuario.jsp">¡Regístrate!</a></small>

                    </form>
                </div>

            </div>

        </div>

    </div>

<jsp:include page="jsSources.jsp"/>
</body>
</html>
