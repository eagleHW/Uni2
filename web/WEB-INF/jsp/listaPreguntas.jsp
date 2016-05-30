<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach var="pregunta" items="${preguntas}">
    <div class="pregunta">
        <p class="titulo_pregunta"><a href=" <c:url value="/mostrarPregunta?id=${pregunta.id_pregunta}"/> ">${pregunta.titulo}</a></p>
        <p>${pregunta.descripcion}</p>
        <p class="datos_pregunta"><strong>Preguntado por ${pregunta.login.nombre} ${pregunta.login.apellido_paterno}  
                ${pregunta.login.apellido_materno} el ${sdf.format(pregunta.fecha)}</strong> </p>
        <label class="carrera_pregunta carrera_${pregunta.carrera.id_carrera}">${pregunta.carrera.carrera}</label>
    </div>
</c:forEach>