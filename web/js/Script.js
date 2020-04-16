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
