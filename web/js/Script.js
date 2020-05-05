function validarRegistro(){
    var pass1 = document.getElementById("userInputPassword").value;
    var pass2 = document.getElementById("userInputPasswordRepit").value;
    var name = document.getElementById("userInputName").value;
    var email = document.getElementById("userInputEmail").value;
    var ton_piel = document.getElementById("tono_piel").value;
    console.log(ton_piel);
    var tip_piel = document.getElementById("tipo_piel").value;
    console.log(tip_piel);
    var date = document.getElementById("fecha_nacimiento").value;
    var error = document.getElementById("error");
    var retorno = true;

    if(pass1 !== pass2){
        retorno = false;
        error.innerHTML = "Las contraseñas no coinciden";
    }
    if(pass1==="" || pass2==="" || name==="" || email==="" || ton_piel==="" || tip_piel==="" || date===""){
        retorno = false;
        error.innerHTML = "Rellene todos los campos";
    }

    return retorno;
}
function validarDescuento(){
    if(document. getElementById("descuento").checked){
        document.getElementById("oferta").innerHTML = "<label for=\"productOffer\">Introduczca la oferta (0-100)%</label>\n" +
            "                    <input type=\"number\" min=\"0\" max=\"100\" class=\"form-control\" id=\"productOffer\" placeholder=\"Ej: 25\" required name = \"descuento\">\n" +
            "                    <div class=\"invalid-feedback\">\n" +
            "                        Valor numérico invalido.\n" +
            "                    </div>";
    }else{
        document.getElementById("oferta").innerHTML = "";
    }
    //console.log("hola");
}
function validarLogin(){
    var user = document.getElementById("userInputName").value;
    var pass = document.getElementById("userInputPassword").value;
    var error = document.getElementById("error");
    var retorno = true;

    if(user === "" || pass === ""){
        retorno = false;
        error.innerHTML = "Debe rellenar todos los campos";
    }

    return retorno;
}
function validarEdicion1() {
    var name = document.getElementById("userInputName").value;
    var email = document.getElementById("userInputEmail").value;
    var pass1 = document.getElementById("userInputPassword").value;
    var pass2 = document.getElementById("userInputPasswordRepit").value;
    var error = document.getElementById("error");
    var retorno = true;

    if(name === "" || email === "" || pass1 === "" || pass2 === ""){
        error.innerHTML = "Debe rellenar todos los campos.";
        retorno = false;
    }else if(pass1 !== pass2){
        error.innerHTML = "Las contraseñas deben coincidir.";
        retorno = false;
    }
    return retorno;
}
function validarEdicion2() {
    var tonoPiel = document.getElementById("tono_piel").value;
    var tipoPiel = document.getElementById("tipo_piel").value;
    var fecha = document.getElementById("fecha_nacimiento").value;
    var genero = document.getElementById("genero").value;
    var direccion = document.getElementById("userInputDireccion").value
    var error = document.getElementById("error1");
    var retorno = true;

    if(tonoPiel === "" || tipoPiel === "" || fecha === "" || genero === "" || direccion === ""){
        error.innerHTML = "Debe rellenar todos los campos.";
        retorno = false;
    }

    return retorno;
}
function validarCompra() {
    var direccion = document.getElementById("address").value;
    var nombre = document.getElementById("cc-name").value;
    var tarjeta = document.getElementById("cc-number").value;
    var caducidad = document.getElementById("caducidad").value;
    var cvv = document.getElementById("cc-cvv").value;
    var error = document.getElementById("error");
    var retorno = true;

    if(direccion === "" || nombre === "" || tarjeta === "" || caducidad === "" || cvv === ""){
        error.innerHTML = "Debe rellenar todos los campos."
        retorno = false
    }

    return retorno;
}

function validarReview(){
    var titel = document.getElementById("tituloReview").value;
    var text = document.getElementById("textReview").value;

    if(titel==="" || text===""){
        error.innerHTML = "Debe rellenar todos los campos.";
        retorno = false;
    }
}

