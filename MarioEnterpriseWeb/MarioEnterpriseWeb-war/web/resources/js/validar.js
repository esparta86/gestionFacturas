function numericoEntero(evt) {
    evt = (evt) ? evt : window.event
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
        status = "This field accepts numbers only."
        return false
    }
    status = ""
    return true
}

function numericoDecimal(evt) {
    evt = (evt) ? evt : window.event
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57) && (charCode!=45) && (charCode!=46)) {
        status = "This field accepts numbers only."
        return false
    }
    status = ""
    return true
}

function numericoDocumento(evt) {
    evt = (evt) ? evt : window.event
    var charCode = (evt.which) ? evt.which : evt.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57) && (charCode!=45) && (charCode!=47)) {
        status = "This field accepts numbers only."
        return false
    }
    status = ""
    return true
}

function numericoEnteroNoEnter(evt) {
    if(evt.keyCode!=13)
        return numericoEntero(evt);
    else{
        return false;
    }
}

function numericoDecimalNoEnter(evt) {
    if(evt.keyCode!=13)
        return numericoDecimal(evt);
    else{
        return false;
    }
}

function numericoDocumentoNoEnter(evt) {
    if(evt.keyCode!=13)
        return numericoDocumento(evt);
    else{
        return false;
    }
}

function noEnter(evt) {
    if (evt.keyCode!=13)
        return true;
    else{
        return false;
    }
}

function sinCaracteresEspecialesNoEnter(evt) {
    // Con esta funcion se valida que no ingresa caracteres especiales 
    // pero si acepte espacio y las letras Ñ y ñ
    evt = (evt) ? evt : window.event
    if (evt.keyCode == 13)
        return false;
    else{
        tecla = (document.all) ? evt.keyCode : evt.which;
        if (tecla == 8 || tecla == 209 || tecla == 241) return true; 
        patron =/\s/; // Acepta Espacio
        patron2 = /\w/;// Acepta números y letras
        te = String.fromCharCode(tecla);
        if( patron.test(te))
        {
            return true;
        }
        else{
            return patron2.test(te);
        } 
         
    }
}

