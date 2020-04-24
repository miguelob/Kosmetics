var XHRObject = false;
if (window.XMLHttpRequest) {
    XHRObject = new XMLHttpRequest();
} else if (window.ActiveXObject) {
    XHRObject = new ActiveXObject("Microsoft.XMLHTTP");
}
function getDatos (fuenteDatos, divID) {
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