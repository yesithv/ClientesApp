//<![CDATA[
function redireccionar() {
    var URLdomain = window.location.host;
    var ruta = window.location.protocol + "//" + URLdomain + "/ClientesApp-web/login.xhtml";
    //alert(ruta);
    window.location = ruta;
}

//]]>