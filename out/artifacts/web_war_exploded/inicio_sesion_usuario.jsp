
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <form method = "POST" action = "Login">
                        <div class="form-group">
                            <label for="userInputEmail">correo electrónico</label>
                            <input type="email" class="form-control" id="userInputEmail" aria-describedby="emailHelp" name = "email">
                        </div>
                        <div class="form-group">
                            <label for="userInputPassword">Contraseña</label>
                            <input type="password" class="form-control" id="userInputPassword" name = "password">
                        </div>

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
