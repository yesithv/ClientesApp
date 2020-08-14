//<![CDATA[
function redireccionar() {
    var URLdomain = window.location.host;
    var ruta = window.location.protocol + "//" + URLdomain + "/NutriApp-web/login.xhtml";
    //alert(ruta);
    window.location = ruta;
}

//]]>