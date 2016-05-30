function aceptarRespuesta(id_button,id_pregunta,id_respuesta){
    
    $.post("aceptarRespuesta",
           {id_pregunta : id_pregunta , id_respuesta : id_respuesta},
            function(data){
                
                if(data === "ok"){
                    
                    var id_button_selector = "#" + id_button;
                    var $id_button = $(id_button_selector);    
                    var $id_button_disabled = $(".respuesta_aceptada[disabled]");

                    $(".respuesta_aceptada[disabled] span").text("Aceptar pregunta");
                    $id_button_disabled.prop("disabled", false);
                    $id_button_disabled.removeAttr("style");

                    $(id_button_selector + " span").text("Respuesta aceptada");
                    $id_button.prop("disabled",true);
                    $id_button.css({"background": "#C2FBC4",
                                    "color" : "green" ,
                                    "border-width": "0" });
                    
                }
          
            });
    
    
    
}


function reportarPregunta(id_pregunta){
    
    $.post("reportarPregunta",
          {id_pregunta : id_pregunta},
          function(data){
    
               if(data === 'ok'){
                   
                   $("#pregunta span").text("Reportada");
                   $("#pregunta button").prop("disabled", true);
                   $("#pregunta button").css("background", "#fbe3e4");
                   $("#pregunta button").css("color", "#d12f19");
                   $("#pregunta button").css("border-width", "0");
                   
               }
               
           });
    
    
}

function limpiaNuevaRespuesta(){
    $("#mensaje_nueva_respuesta").text("");
}

function enviarRespuesta(id_pregunta){
    
    var str_nueva_respuesta = $("#nueva_respuesta").val().trim();
    
    if(str_nueva_respuesta === ""){
        $("#mensaje_nueva_respuesta").text("Este campo no puede quedar vacío");
    }else{
     
       $.post("guardarRespuesta", {id_pregunta: id_pregunta, nueva_respuesta: str_nueva_respuesta} ,
            function(data){
                
                $("#lista_respuestas").append(data);
                $("#nueva_respuesta").val("");
    
       });             
       
    }
    
}
