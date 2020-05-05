<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <jsp:include page="head.jsp"/>
    <title>Cargar Imagen · Kosmetics</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    -->

</head>
<body>
<jsp:include page="cabecera.jsp"/>
<div class="row justify-content-center">

    <div class="col-11 mx-auto mt-5">

        <div class="row">
            <div class="mb-3 pl-3">
                <h1 class="text-center  "><strong>
                    Añade la imagenes del producto!!
                </strong></h1>

            </div>
        </div>

        <form action="subirImg" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="file" name="imagen[]" id="upload-files" accept="image/*" multiple="multiple">
                <label for="upload-files" class=" form-control-file upload-drop-zone" id="drop-zone">
                </label>
            </div>

            <div>
                <input type="submit" class="btn btn-dark" value="Subir">
            </div>
        </form>
    </div>
</div>
<jsp:include page="jsSources.jsp"/>
</body>
</html>


