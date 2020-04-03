<%--
  Created by IntelliJ IDEA.
  User: alexr
  Date: 02/04/2020
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="head.jsp"%>
    <title>Registrarse · Kosmetics</title>
</head>
<body>
    <div class="container-fluid">
        <div class="row p-0 justify-content-center">
            <img id="registro-inicio_img" src = "media/registroFondo.jpg" class="img-fluid col-lg-6 p-0 d-none d-xl-block">
            <div class="col-12 col-xl-6 py-5 d-flex justify-content-center">
                <div class = "col-lg-8">
                    <h1 class="text-center pt-5">Crea tu perfil</h1>
                    <h4 class="text-center text-muted py-3">¡Descubre las novedades más asombrosa!</h4>
                    <form>
                        <div class="form-group">
                            <label for="userInputName">nombre de usuario</label>
                            <input placeholder="Milo Tatch" type="text" class="form-control" id="userInputName" aria-describedby="emailHelp">
                        </div>
                        <div class="form-group">
                            <label for="userInputEmail">correo electrónico</label>
                            <input placeholder="mtatch@gmail.com" type="email" class="form-control" id="userInputEmail">
                        </div>
                        <div class="form-group">
                            <label for="userInputPassword">contraseña</label>
                            <input placeholder="********" type="password" class="form-control" id="userInputPassword">
                        </div>
                        <div class="form-group">
                            <label for="userInputPasswordRepit">repetir la contraseña</label>
                            <input placeholder="********" type="password" class="form-control" id="userInputPasswordRepit">
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="tono_piel">tipo de piel</label>
                                <select id="tono_piel" class="custom-select" >
                                    <option selected></option>
                                    <option value="1" style="background: #edaa7c"></option>
                                    <option value="2" style="background: #ff9353"></option>
                                    <option value="3" style="background: #d99058"></option>
                                </select>
                            </div>

                            <div class="form-group col-md-3">
                                <label for="tipo_piel">tipo de piel</label>
                                <select id="tipo_piel" class="custom-select">
                                    <option selected></option>
                                    <option value="1" >mixta</option>
                                    <option value="2" >grasa</option>
                                    <option value="3" >seca</option>
                                </select>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="fecha_nacimiento">fecha de nacimiento </label>
                                <input type="date" name="fecha_nacimiento" class="form-control"id="fecha_nacimiento"
                                           value="2020-04-2"
                                           min="1920-01-01" max="2020-12-31">
                            </div>

                        </div>
                        <button type="submit" class="btn btn-dark btn-block mt-5">Registrarse</button>

                    </form>
                </div>

            </div>

        </div>

    </div>

<%@include file="jsSources.jsp"%>
</body>
</html>
