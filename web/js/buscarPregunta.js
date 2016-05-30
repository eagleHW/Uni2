
function buscarPregunta(){
    
    var palabra_clave = $("#palabra_clave").val();
    var usuario = $("#usuario").val();
    var fecha = $("#fecha").val();
    var id_carrera = $("#carrera").val();
       
    $.post("realizarBusqueda",
            {palabra_clave:palabra_clave, usuario:usuario, fecha:fecha, id_carrera:id_carrera},
            function(data){
                $("#preguntas").html(data);
            });
    
}