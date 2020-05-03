var slider = document.getElementById("customRange1");
var output = document.getElementById("precioFiltro");
output.innerHTML = slider.value;

slider.oninput = function() {
    output.innerHTML = this.value;
}

// function filtroPrecio() {
//     document.getElementById("formulario").submit();
// }

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