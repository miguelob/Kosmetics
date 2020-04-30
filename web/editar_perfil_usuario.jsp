
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <jsp:include page="head.jsp"/>
    <title>Editar perfil · Kosmetics</title>
</head>
<body>
<jsp:include page="cabeceraSinAjax.jsp"/>
<div class = "container">
    <div class = "row">
        <div class="col-12 py-0 d-flex justify-content-center">
            <div class="col-lg-9 pt-5 d-flex justify-content-center">
                <div class = "img-fluid col-xl-6 p-7 mt-4 d-none d-xl-block">
                   <div class="row">
                    <!--<img src = ".\media\inicio_sesion_fondo.jpg" class="rounded-circle img-fluid p-4">-->
                       <span class="rounded-circle icono m-auto">MT</span>
                   </div>
                    <div class="row justify-content-center">
                        <small class="form-text text-muted mt-3"><a class="p-2 text-dark" href="registro_usuario.jsp">cambiar imagen de perfil</a></small>
                    </div>

                </div>
                <div class="col-12 col-xl-6 px-0 d-flex justify-content-center">

                    <div class = "col-lg-9 px-0">
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
    </div>

    <div class="row">
        <div class="col-12 pb-5 d-flex justify-content-center">
            <div class = "col-lg-9">
                <h5 class="text-muted py-3">Información adicional </h5>

                <form>
                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label for="tono_piel">tipo de piel</label>
                            <select id="tono_piel" class="custom-select" >
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
                            <select id="tipo_piel" class="custom-select">
                                <option selected>sin definir</option>
                                <option value="1" >mixta</option>
                                <option value="2" >grasa</option>
                                <option value="3" >seca</option>

                            </select>
                        </div>


                        <div class="form-group col-md-4">
                            <label for="fecha_nacimiento">fecha de nacimiento </label>
                            <input type="date" name="fecha_nacimiento" class="form-control"id="fecha_nacimiento"
                                   value="2020-04-2"
                                   min="1920-01-01" max="2020-12-31">
                        </div>

                    </div>
                    <div class="form-row">

                        <div class="form-group col-md-3">
                            <label for="genero">género</label>
                            <select id="genero" class="custom-select">
                                <option selected>mostrar valor actual</option>
                                <option value="1" >Mujer</option>
                                <option value="2" >Hombre</option>
                                <option value="3" >Prefiero no decirlo</option>
                                <option value="4" >Otro</option>
                            </select>
                        </div>

                        <div class="form-group col-md-9">
                            <label for="userInputDireccion">Dirección</label>
                            <input placeholder="C/ Luis Jorge Castaños 23. 4º-2ª; Urbanización Las Cascajuelas; 28999 Valdecillas de Jarama, Madrid" type="text" class="form-control" id="userInputDireccion" aria-describedby="emailHelp">
                        </div>

                    </div>
                    <div class="form-group col-md-10 mx-auto">
                        <button type="submit" class="btn btn-dark btn-block mt-5">Actualizar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>

<jsp:include page="jSources.jsp"/>
</body>
</html>
