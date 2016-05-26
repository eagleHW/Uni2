
var init_index_pregunta = 0;

obtenPreguntas();

function obtenPreguntas() {

    $.ajax({
        type: "GET",
        url:  "mostrarPreguntas/"+init_index_pregunta,
        success: function(response) {
            $("#preguntas").html( response );
        }
    });
    
}

function seguir(){
    init_index_pregunta += 1;
    obtenPreguntas();
    
}

function regresar(){
    init_index_pregunta -= 1;
    obtenPreguntas();
    
}