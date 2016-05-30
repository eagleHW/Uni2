<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
            <meta charset="UTF-8">
            <title>${pregunta.titulo}</title>
            <link rel="icon" href=" <c:url value="/imagenes/foco.png"/> "/>
            <link rel="stylesheet" type="text/css" href=" <c:url value="/css/navegacion.css" /> ">
            <link rel="stylesheet" type="text/css" href=" <c:url value="/css/mostrarPregunta.css" /> ">
            <link rel="stylesheet" type="text/css" href=" <c:url value="/css/estrella.css" /> ">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
            <script src=" <c:url value="/js/mostrarPregunta.js" /> "></script>
	</head>
	<body>

            <nav>
		
                <div>
                    <p>Bienvenido : <a href=" <c:url value="/perfilUsuario"/> ">${login}</a> | 
                                    <a href=" <c:url value="/logout"/> ">Logout</a> </p>
                </div>

                <a href=" <c:url value="/home"/> "><img src=" <c:url value="/imagenes/uni2.png"/> "></a>

                <ul>
                    <li><a href=" <c:url value="/publicarPregunta"/> ">Publicar Pregunta</a></li>
                    <li><a href=" <c:url value="/buscarPregunta"/> ">Buscar Pregunta</a></li>
                    <li><a href=" <c:url value="/perfilUsuario"/> ">Ver Perfil</a></li>
                </ul>

            </nav>

           
            <div id="contenedor">   
                <div id="pregunta">
                    <p class="titulo_pregunta">${pregunta.titulo}</p>
                    <p>${pregunta.descripcion}</p>
                    <p id="fecha"><strong>Preguntado por ${pregunta.login.nombre} ${pregunta.login.apellido_paterno}  
                    ${pregunta.login.apellido_materno} el ${sdf.format(pregunta.fecha)}</strong></p>
                    <button type="button" onclick="reportarPregunta(${pregunta.id_pregunta})"><img src=" <c:url value="/imagenes/exclamacion.png"/> " alt=""><span>Reportar pregunta</span></button>
                </div>	

                <h2 id="encabezado_respuesta">Respuestas</h2>	

                <div id="lista_respuestas">   
                <c:set var="num_respuesta" value="1"/>
                <c:forEach var="respuesta" items="${respuestas}">
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
    <!-- Si no hay respuesta satisfactoria todavia -->
    <c:if test="${ empty pregunta.id_respuesta_satisfactoria }">
        <!-- Si el que ve la pregunta es el mismo que la pregunto -->
        <c:if test="${pregunta.login.login == login}">
            <button id="respuesta_aceptada_${num_respuesta}" type="button" class="respuesta_aceptada" onclick="aceptarRespuesta(this.id,${pregunta.id_pregunta},${respuesta.id_respuesta})"><label style="color:green">&#x2714;</label> <span>Aceptar respuesta</span></button>
        </c:if>
    </c:if>
    
    <!-- Si ya hay respuesta satisfactoria -->
    <c:if test="${ not empty pregunta.id_respuesta_satisfactoria }">
        <!-- Si el que ve la pregunta es el mismo que la pregunto -->
        <c:if test="${pregunta.login.login == login}">
            
        <!-- Se despliega de determinada forma el boton de la respuesta 
             dependiento si es la satisfactoria o no                    -->
            <c:if test="${respuesta.id_respuesta == pregunta.id_respuesta_satisfactoria.id_respuesta}">
                <button id="respuesta_aceptada_${num_respuesta}" type="button" class="respuesta_aceptada" 
                onclick="aceptarRespuesta(this.id,${pregunta.id_pregunta},${respuesta.id_respuesta})" 
                disabled="" style="color: green; border-width: 0px; background: rgb(194, 251, 196);"><label style="color:green">&#x2714;</label> <span>Respuesta aceptada</span></button>
            </c:if>
            <c:if test="${respuesta.id_respuesta != pregunta.id_respuesta_satisfactoria.id_respuesta}">
                <button id="respuesta_aceptada_${num_respuesta}" type="button" class="respuesta_aceptada" onclick="aceptarRespuesta(this.id,${pregunta.id_pregunta},${respuesta.id_respuesta})"><label style="color:green">&#x2714;</label> <span>Aceptar respuesta</span></button>
            </c:if>
                
        </c:if>
        <!-- Si el que ve la pregunta NO es el mismo que la pregunto -->        
        <c:if test="${pregunta.login.login != login}">
            
            <!-- Si despliega una etiqueta para señalar la respuesta aceptada -->
            <c:if test="${respuesta.id_respuesta == pregunta.id_respuesta_satisfactoria.id_respuesta}">
                <label id="label_respuesta_aceptada"><span style="color:green">&#x2714;</span> RespuestaAceptada</label>
            </c:if>
        </c:if>        
    </c:if>
                    </div>    
                <c:set var="num_respuesta" value="${num_respuesta + 1}"/>        
                </c:forEach>
                </div>

                <h2>Responder pregunta</h2>
                <div id="responder_pregunta">
                    <textarea id="nueva_respuesta" cols="30" rows="8" placeholder="Escribe tu respuesta aquí" onclick="limpiaNuevaRespuesta()"></textarea>
                    <div id="mensaje_nueva_respuesta"></div>
                    <button type="button" onclick="enviarRespuesta(${pregunta.id_pregunta})">Responder pregunta</button>
                </div>
            </div> 
	

	</body>
</html>