var XHRObject = false;
if (window.XMLHttpRequest) {
    XHRObject = new XMLHttpRequest();
} else if (window.ActiveXObject) {
    XHRObject = new ActiveXObject("Microsoft.XMLHTTP");
}

var slider = document.getElementById("customRange1");
var output = document.getElementById("precioFiltro");
output.innerHTML = slider.value;

slider.oninput = function() {
    output.innerHTML = this.value;
}

function petAsinc(url, div) {
    var xmlHttpReq = new XMLHttpRequest();
    xmlHttpReq.onreadystatechange=function()
    {
        if (xmlHttpReq.readyState === 4 && xmlHttpReq.status === 200)
        {

            document.getElementById(div).innerHTML = xmlHttpReq.responseText;
        }
    };

    xmlHttpReq.open('GET', url, true);
    xmlHttpReq.send();
}
function getDatos (fuenteDatos, divID) {
    //console.log("prueba");
    if (XHRObject) {
        var obj = document.getElementById(divID);
        XHRObject.open("GET", fuenteDatos);
        XHRObject.onreadystatechange = function(){
            if (XHRObject.readyState == 4 && XHRObject.status == 200) {
                obj.innerHTML = XHRObject.responseText;
            }
        }
        XHRObject.send(null);
    }
}
document.getElementById('searchBar').addEventListener("keypress", function (e) {
    if(e.key === 'Enter'){
        //console.log("event listener");
        buscar();
    }
})
function buscar(){
    var busqueda = document.getElementById('searchBar').value
    var url = "./Filtros?busqueda=";
    var urlCompleta = url.concat(busqueda.replace(" ","-"));
    //console.log(urlCompleta);
    getDatos(urlCompleta,'paginaProductos');
}