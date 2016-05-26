<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="pregunta" items="${preguntas}">
    <div class="pregunta">
        <h2>${pregunta.titulo}</h2>
        <p>
            ${pregunta.descripcion}
        </p>
        <p class="datos_pregunta"><strong>Preguntado por ${pregunta.login.nombre} ${pregunta.login.apellido_materno}  
                ${pregunta.login.apellido_paterno} el ${sdf.format(pregunta.fecha)}</strong> </p>
        <label class="carrera_pregunta">${pregunta.carrera.carrera}</label>
    </div>
</c:forEach>