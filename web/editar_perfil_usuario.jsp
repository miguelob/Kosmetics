<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <jsp:include page="head.jsp"/>
    <title>Editar perfil · Kosmetics</title>
</head>
<body>
<c:if test="${empty sessionScope.user}">
    <jsp:forward page="./inicio_sesion_usuario.jsp"></jsp:forward>
</c:if>
<jsp:include page="cabeceraSinAjax.jsp"/>
<div class = "container">
    <div class = "row">
        <div class="col-12 py-0 d-flex justify-content-center">
            <div class="col-lg-9 pt-5 d-flex justify-content-center">
                <div class = "img-fluid col-xl-6 p-7 mt-4 d-none d-xl-block">
                   <div class="row">
                    <!--<img src = ".\media\inicio_sesion_fondo.jpg" class="rounded-circle img-fluid p-4">-->
                       <c:if test="${sessionScope.user.imagen}">
                           <img src="ReadImg?name=${sessionScope.user.name.replace(' ','-')}" class="img img-rounded img-fluid d-none d-md-block">
                       </c:if>
                       <c:if test="${sessionScope.user.imagen == false}">
                           <span class="rounded-circle icono imgUserInfo m-auto"><c:out value ="${sessionScope.user.iniciales}"/></span>
                       </c:if>
                   </div>
                    <div class="row justify-content-center">
                        <small class="form-text text-muted mt-3"><a class="p-2 text-dark" href="">cambiar imagen de perfil</a></small>
                    </div>

                </div>
                <div class="col-12 col-xl-6 px-0 d-flex justify-content-center">

                    <div class = "col-lg-9 px-0">
                        <form action="EditarPerfil" method="POST" onsubmit="return validarEdicion1();">
                            <div class="form-group">
                                <label for="userInputName">nombre de usuario</label>
                                <input value="${sessionScope.user.name}" type="text" class="form-control" id="userInputName" aria-describedby="emailHelp" name="name">
                            </div>
                            <div class="form-group">
                                <label for="userInputEmail">correo electrónico</label>
                                <input value="${sessionScope.user.email}" type="email" class="form-control" id="userInputEmail" name = "email">
                            </div>
                            <div class="form-group">
                                <label for="userInputPassword">contraseña</label>
                                <input type="password" class="form-control" id="userInputPassword" value="${sessionScope.user.password}" name="pass">
                            </div>
                            <div class="form-group">
                                <label for="userInputPasswordRepit">repetir la contraseña</label>
                                <input type="password" class="form-control" id="userInputPasswordRepit" value="${sessionScope.user.password}">
                            </div>
                            <div style="color: red; align-content: center; text-align: center;" id="error">
                                ${requestScope.error}
                            </div>
                            <div class="form-group col-md-10 mx-auto">
                                <button type="submit" class="btn btn-dark btn-block mt-5" name = "btn" value = "first">Actualizar</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-12 pb-5 d-flex justify-content-center">
            <div class = "col-lg-9">
                <h5 class="text-muted py-3">Información adicional </h5>

                <form action="EditarPerfil" method="post" onsubmit="return validarEdicion2();">
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="tono_piel">tipo de piel</label>
                            <select id="tono_piel" class="custom-select" name="skinColor">
                                <option selected>sin definir</option>
                                <option value="1" style="background: #fdeec7">marfil</option>
                                <option value="2" style="background: #fee1b9">palida</option>
                                <option value="3" style="background: #fcbd84">beige</option>
                                <option value="4" style="background: #a87256; color:white">moreno claro</option>
                                <option value="5" style="background: #633c1d; color:white">moreno oscuro</option>

                            </select>
                        </div>

                        <div class="form-group col-md-4">
                            <label for="tipo_piel">tipo de piel</label>
                            <select id="tipo_piel" class="custom-select" name="skinCondition">
                                <option selected>sin definir</option>
                                <option value="1" >mixta</option>
                                <option value="2" >grasa</option>
                                <option value="3" >seca</option>

                            </select>
                        </div>


                        <div class="form-group col-md-4">
                            <label for="fecha_nacimiento">fecha de nacimiento </label>
                            <input type="date" name="fecha_nacimiento" class="form-control"id="fecha_nacimiento"
                                   value="${sessionScope.user.birthDate}"
                                   min="1920-01-01" max="2020-12-31">
                        </div>

                    </div>
                    <div class="form-row">

                        <div class="form-group col-md-3">
                            <label for="genero">género</label>
                            <select id="genero" class="custom-select" name = "genero">
                                <option selected>mostrar valor actual</option>
                                <option value="1" >Mujer</option>
                                <option value="2" >Hombre</option>
                                <option value="3" >Prefiero no decirlo</option>
                                <option value="4" >Otro</option>
                            </select>
                        </div>

                        <div class="form-group col-md-9">
                            <label for="userInputDireccion">Dirección</label>
                            <input placeholder="C/ Luis Jorge Castaños 23. 4º-2ª; Urbanización Las Cascajuelas; 28999 Valdecillas de Jarama, Madrid" type="text" class="form-control" id="userInputDireccion" aria-describedby="emailHelp" name="direccion">
                        </div>

                    </div>
                    <div style="color: red; align-content: center; text-align: center;" id="error1">
                        ${requestScope.error1}
                    </div>
                    <div class="form-group col-md-10 mx-auto">
                        <button type="submit" class="btn btn-dark btn-block mt-5" name = "btn" value = "second">Actualizar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<script src = "./js/Script.js"></script>
<jsp:include page="jsSources.jsp"/>
</body>
</html>
