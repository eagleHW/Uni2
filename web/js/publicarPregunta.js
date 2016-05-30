function valida(){
    
    var continua = true;
    
    continua = revisaTitulo() && continua;
    continua = revisaDescripcion() && continua;
    
    return continua;
    
}

function limpiaTitulo(){
    
    $("#validacion_titulo").html("");
   
}

function revisaTitulo(){
    
    var titulo = $("#titulo_pregunta").val().trim();
    
    if(titulo === ""){
        $("#validacion_titulo").html("Este campo no puede quedar vacío");
        $("#titulo_pregunta").text("");
        return false;
    }
    
    return true;
    
}

function limpiaDescripcion(){    
    $("#validacion_descripcion").html("");
}

function revisaDescripcion(){
    
    var descripcion = $("#descripcion").val().trim();
    
    if(descripcion === ""){
        $("#validacion_descripcion").html("Este campo no puede quedar vacío");
        $("#descripcion").text("");
        return false;
    }
    
    return true;
   
}

