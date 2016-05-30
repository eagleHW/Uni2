<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="respuestas">
    <p>${respuesta.descripcion}</p>
    <p class="datos_respuesta"><strong>Respondido por ${respuesta.login.nombre} ${respuesta.login.apellido_paterno}  
                              ${respuesta.login.apellido_materno} el ${sdf.format(respuesta.fecha)}</strong> |</p>
        <fieldset class="rating">
            <input type="radio" id="p${num_respuesta}star5" name="p${num_respuesta}star" value="5" /><label class = "full" for="p${num_respuesta}star5" title="Muy útil"></label>
            <input type="radio" id="p${num_respuesta}star4" name="p${num_respuesta}star" value="4" /><label class = "full" for="p${num_respuesta}star4" title="Útil"></label>
            <input type="radio" id="p${num_respuesta}star3" name="p${num_respuesta}star" value="3" /><label class = "full" for="p${num_respuesta}star3" title="Ligeramente Útil"></label>
            <input type="radio" id="p${num_respuesta}star2" name="p${num_respuesta}star" value="2" /><label class = "full" for="p${num_respuesta}star2" title="No Útil"></label>
            <input type="radio" id="p${num_respuesta}star1" name="p${num_respuesta}star" value="1" /><label class = "full" for="p${num_respuesta}star1" title="Sin sentido"></label>
        </fieldset>
        <c:if test="${pregunta.login.login == login}">
            <button id="respuesta_aceptada_${num_respuesta}" type="button" class="respuesta_aceptada" onclick="aceptarRespuesta(this.id,${pregunta.id_pregunta},${respuesta.id_respuesta})"><label style="color:green">&#x2714;</label> <span>Aceptar respuesta</span></button>
        </c:if>     
</div>

   