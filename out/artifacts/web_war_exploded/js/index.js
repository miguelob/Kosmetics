document.getElementById('searchBarIndex').addEventListener("keypress", function (e) {
        aplicarSubmit();
})
function aplicarSubmit(){
    document.getElementById("formulario").submit();
}