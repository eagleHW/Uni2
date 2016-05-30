<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
    <head>
        <title>Perfil de Usuario</title>
        <meta charset="UTF-8">
        <link rel="icon" href=" <c:url value="/imagenes/foco.png"/> "/>
        <link rel="stylesheet" type="text/css" href=" <c:url value="/css/navegacion.css" /> ">
        <link rel="stylesheet" type="text/css" href=" <c:url value="/css/perfilUsuario.css" /> ">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <script src=" <c:url value="/js/perfilUsuario.js" /> "></script>
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

        
        <p id="titulo">Perfil de Usuario</p>

        <div id="formulario">
            <form:form id="form_datos">
                <div id="datos">
                    <p>Si lo deseas modifica tus datos y luego guarda los cambios</p>
                    <form:label path="nombre" for="nombre">Nombre </form:label>
                    <form:input path="nombre" type="text" id="nombre" value="${nombre}" onclick="limpiaNombre()"/>
                    <div id="validacion_nombre" class="mensaje_error"></div>
                    <form:label path="apellido_paterno" for="apellido_paterno">Apellido Paterno </form:label>
                    <form:input path="apellido_paterno" type="text" id="apellido_paterno" value="${apellido_paterno}" onclick="limpiaApellidoPaterno()"/>
                    <div id="validacion_apellido_paterno" class="mensaje_error"></div>
                    <form:label path="apellido_materno" for="apellido_materno">Apellido Materno </form:label>
                    <form:input path="apellido_materno" type="text" id="apellido_materno" value="${apellido_materno}" onclick="limpiaApellidoMaterno()"/>
                    <div id="validacion_apellido_materno" class="mensaje_error"></div>
                    <form:label path="correo" for="correo">Correo </form:label>
                    <form:input path="correo" type="text" id="correo" value="${correo}" onclick="limpiaCorreo()"/>
                    <div id="validacion_correo" class="mensaje_error"></div>
                    <form:label path="facebook" for="facebook">Facebook </form:label>
                    <form:input path="facebook" type="text" id="facebook" value="${facebook}" placeholder=" Ej. https://www.facebook.com/[ nombre usuario ]" onclick="limpiaFacebook()"/>
                    <div id="validacion_facebook" class="mensaje_error"></div>
                    <form:label path="whatsapp" for="whatsapp">Whats app </form:label>
                    <form:input path="whatsapp" type="text" id="whatsapp" value="${whatsapp}" onclick="limpiaWhatsapp()"/>
                    <div id="validacion_whatsapp" class="mensaje_error"></div>
                    <form:label path="carrera" for="carrera">Carrera </form:label>
                    <select id="carrera" name="id_carrera">
                    <c:set var="val1" value="${id_carrera}"/>
                    <c:forEach var="carrera" items="${carreras}">
                        <c:set var="val2" value="${carrera.id_carrera}"/>
                            <c:if test="${val1 == val2}">        
                                <option selected="true" value="${carrera.id_carrera}">${carrera.carrera}</option>
                            </c:if>
                            <c:if test="${val1 != val2}">        
                                <option value="${carrera.id_carrera}">${carrera.carrera}</option>
                            </c:if>   
                    </c:forEach>
                    </select>
                    <div id="mensaje_datos"></div>
                    <button type="button" onclick="validaDatos()">Guardar cambios</button>
                </div>
            </form:form>
            
            <form id="form_contrasena">
                <div id="contrasena">
                    <p>Cambio de contraseña</p>
                    <label for="contrasena_anterior" id="label_contrasena_anterior">Contraseña Anterior </label>
                    <input type="password" id="contrasena_anterior" name="contrasena_anterior"/>

                    <hr>    

                    <label for="contrasena_nueva" id="label_contrasena_nueva">Contraseña Nueva</label>
                        <input type="password" id="contrasena_nueva" name="contrasena_nueva" onclick="limpiaContrasena()"/>
                    <div id="validacion_contrasena" class="mensaje_error"></div>
                    <label for="repite_contrasena" id="label_repite_contrasena">Repite Contraseña </label>
                        <input type="password" id="repite_contrasena" name="repite_contrasena" onclick="limpiaRepiteContrasena()"/>
                    <div id="validacion_repite_contrasena" class="mensaje_error"></div>
                    <div id="mensaje_contrasena"></div>
                    <button type="button" onclick="validaContrasena()">Cambiar contraseña</button>
                </div>
            </form>
        </div>

    </body>
</html>