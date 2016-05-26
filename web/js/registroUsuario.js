
function valida(){
    
    var continua = true;
    
    continua = revisaNombre() && continua; 
    continua = revisaApellidoPaterno() && continua;
    continua = revisaApellidoMaterno() && continua;
    continua = revisaLogin() && continua;
    continua = revisaContrasena() && continua;
    continua = revisaCorreo() && continua; 
    continua = revisaFacebook() && continua; 
    continua = revisaWhatsapp() && continua;
    
    return continua;

}

// Validación del campo nombre

function limpiaNombre(){
    document.getElementById("validacion_nombre").innerHTML = "";
    document.getElementById("nombre").classList.remove("error");
}

function revisaNombre(){
    
    var nombre = document.getElementById("nombre").value;
    var nombre_pat = /^[A-Za-zñáéíóú]+$/;
    
    if(nombre.match(nombre_pat)){
        if(nombre.length >= 2 && nombre.length <= 100){ //Tamaño [2,100]
            return true;
        }else{
            document.getElementById("validacion_nombre").innerHTML = "El nombre debe tener un m\u00EDnimo de 2 letras y un m\u00E1ximo de 100 letras";
            document.getElementById("nombre").classList.add("error");
            return false;
        }
    }else{        
        if(nombre === ""){
            document.getElementById("validacion_nombre").innerHTML = "Este campo no pude quedar vac\u00EDo";     
        }else{
            document.getElementById("validacion_nombre").innerHTML = "El nombre solo puede contener letras";    
        }

        document.getElementById("nombre").classList.add("error");
        return false;
    }  
}

// Validación del campo apellido paterno

function limpiaApellidoPaterno(){
    document.getElementById("validacion_apellido_paterno").innerHTML = "";
    document.getElementById("apellido_paterno").classList.remove("error");
}

function revisaApellidoPaterno(){
    
    var apellido_paterno = document.getElementById("apellido_paterno").value;
    var apellido_paterno_pat = /^[A-Za-zñáéíóú]+$/;
    
    if(apellido_paterno.match(apellido_paterno_pat)){
        if(apellido_paterno.length >= 2 && apellido_paterno.length <= 100){ //Tamaño [2,100]
            return true;
        }else{
            document.getElementById("validacion_apellido_paterno").innerHTML = "El apellido paterno debe tener un m\u00EDnimo de 2 letras y un m\u00E1ximo de 100 letras";
            document.getElementById("apellido_paterno").classList.add("error");
            return false;
        }
    }else{        
        if(apellido_paterno === ""){
            document.getElementById("validacion_apellido_paterno").innerHTML = "Este campo no pude quedar vac\u00EDo";     
        }else{
            document.getElementById("validacion_apellido_paterno").innerHTML = "El apellido paterno solo puede contener letras";    
        }
        document.getElementById("apellido_paterno").classList.add("error");
        return false;
    }   
}

// Validación del campo apellido materno

function limpiaApellidoMaterno(){
    document.getElementById("validacion_apellido_materno").innerHTML = "";
    document.getElementById("apellido_materno").classList.remove("error");
}

function revisaApellidoMaterno(){
    
    var apellido_materno = document.getElementById("apellido_materno").value;
    var apellido_materno_pat = /^[A-Za-zñáéíóú]+$/;
    
    if(apellido_materno.match(apellido_materno_pat)){
        if(apellido_materno.length >= 2 && apellido_materno.length <= 100){ //Tamaño [2,100]
            return true;
        }else{
            document.getElementById("validacion_apellido_materno").innerHTML = "El apellido materno debe tener un m\u00EDnimo de 2 letras y un m\u00E1ximo de 100 letras";
            document.getElementById("apellido_materno").classList.add("error");
            return false;
        }
    }else{        
        if(apellido_materno === ""){
            document.getElementById("validacion_apellido_materno").innerHTML = "Este campo no pude quedar vac\u00EDo";     
        }else{
            document.getElementById("validacion_apellido_materno").innerHTML = "El apellido materno solo puede contener letras";    
        }
        document.getElementById("apellido_materno").classList.add("error");
        return false;
    }   
}

// Validación del campo login

function limpiaLogin(){
    document.getElementById("validacion_login").innerHTML = "";
    document.getElementById("login").classList.remove("error");
}

function revisaLogin(){
    
    var login = document.getElementById("login").value;
    var login_pat = /^[A-Za-z0-9_ñ]+$/;
    
    if(login.match(login_pat)){
        if(login.length >= 4 && login.length <= 20){ //  tamaño [4,20]
            return true;
        }else{
            document.getElementById("validacion_login").innerHTML = "El login debe tener un m\u00EDnimo de 4 caracteres y un m\u00E1ximo de 20";
            document.getElementById("login").classList.add("error");
            return false;
        }
    }else{
        if(login === ""){
            document.getElementById("validacion_login").innerHTML = "Este campo no puede quedar vac\u00EDo";
        }else{
            document.getElementById("validacion_login").innerHTML = "El login solo puede contener n\u00FAmeros,letras y guiones bajos";  
        }

        document.getElementById("login").classList.add("error");
        return false;
    }
}

// Validación del campo contraseña y repite contraseña

function limpiaContrasena(){
    document.getElementById("validacion_contrasena").innerHTML = "";
    document.getElementById("contrasena").classList.remove("error");
}
function limpiaRepiteContrasena(){
    document.getElementById("validacion_repite_contrasena").innerHTML = "";
    document.getElementById("repite_contrasena").classList.remove("error");
}

function revisaContrasena(){
    var contraseniaUno = document.getElementById("contrasena").value;
    var contraseniaDos = document.getElementById("repite_contrasena").value;

    if(contraseniaUno === ""){
        document.getElementById("validacion_contrasena").innerHTML ="Este campo no puede quedar vac\u00EDo";
        document.getElementById("contrasena").classList.add("error");
        return false;
    }else{
        if(contraseniaUno.length < 5 || contraseniaUno.length > 40){
            document.getElementById("validacion_contrasena").innerHTML ="La contraseña debe tener un m\u00EDnimo de 5 caracteres y un m\u00E1ximo de 40";
            document.getElementById("contrasena").classList.add("error");
            return false;
         }
    }

    if(contraseniaUno !== contraseniaDos){
        document.getElementById("validacion_repite_contrasena").innerHTML ="Las contraseñas no coinciden";
        document.getElementById("repite_contrasena").classList.add("error");
        return false;
    } 

    return true;
}

// Validación del campo correo

function limpiaCorreo(){
    document.getElementById("validacion_correo").innerHTML = "";
    document.getElementById("correo").classList.remove("error");
}

function revisaCorreo(){
    
    var correo = document.getElementById("correo").value;
    var correo_pat = /^[A-Za-z0-9_.]+@ciencias.unam.mx$/;
    
    if(correo.match(correo_pat)){
        if(correo.length <= 100){  // Si cumple la estructura y su tamaño es menor a 70 
            return true;
        }else{
            document.getElementById("validacion_correo").innerHTML = "El correo debe tener un tamaño m\u00E1ximo de 100 caracteres";
            document.getElementById("correo").classList.add("error");
            return false;
        }     
    }else{        
        if(correo === ""){
            document.getElementById("validacion_correo").innerHTML = "Este campo no puede quedar vac\u00EDo"; 
        }else{
            document.getElementById("validacion_correo").innerHTML = "El correo debe tener la siguiente estructura: ejemplo@ciencias.unam.mx";
        }

        document.getElementById("correo").classList.add("error");
        return false;
    }
    
}

// Validación del campo whatsapp

function limpiaFacebook(){
    document.getElementById("validacion_facebook").innerHTML = "";
    document.getElementById("facebook").classList.remove("error");
}

function revisaFacebook(){
    
    var facebook = document.getElementById("facebook").value;
    var facebook_pat = /^https:\/\/www.facebook.com\/.+$/;
    
    if(!facebook.match(facebook_pat)){
         if(facebook === ""){
            document.getElementById("validacion_facebook").innerHTML = "Este campo no puede quedar vac\u00EDo"; 
        }else{
            document.getElementById("validacion_facebook").innerHTML = "El facebook debe tener la siguiente estructura: https://www.facebook.com/[ nombre usuario ]";
        }

        document.getElementById("facebook").classList.add("error");
        return false;
    }

    return true;
}


// Validación del campo whatsapp

function limpiaWhatsapp(){
    document.getElementById("validacion_whatsapp").innerHTML = "";
    document.getElementById("whatsapp").classList.remove("error");
}

function revisaWhatsapp(){
    
    var whatsapp = document.getElementById("whatsapp").value;
    var whatsapp_pat = /^[0-9]+$/;
    
    if(whatsapp.match(whatsapp_pat)){
        if(whatsapp.length >= 8 && whatsapp.length <= 15){  // Tamaño [8,15]
            return true;
        }else{
            document.getElementById("validacion_whatsapp").innerHTML = "El tel\u00E9fono debe tener un m\u00EDnimo de 8 n\u00FAmeros y un m\u00E1ximo de 10";
            document.getElementById("whatsapp").classList.add("error");
            return false;
        }
    }else{
        if(whatsapp === ""){
            document.getElementById("validacion_whatsapp").innerHTML = "Este campo no puede quedar vac\u00EDo";
        }else{
            document.getElementById("validacion_whatsapp").innerHTML = "El tel\u00E9fono solo puede contener n\u00FAmeros";            
        }   

        document.getElementById("whatsapp").classList.add("error");
        return false;
    }
}
