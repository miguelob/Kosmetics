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
