<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Registro de Usuario</title>
        <link rel="icon" href=" <c:url value="/imagenes/foco.png"/> "/>
        <link rel="stylesheet" type="text/css" href=" <c:url value="/css/header.css" /> ">
        <link rel="stylesheet" type="text/css" href=" <c:url value="/css/registroUsuario.css" /> ">    
        <script src=" <c:url value="/js/registroUsuario.js" /> "></script>
    </head>
    <body>
    	
    	<header>
    			
            <img src=" <c:url value="/imagenes/uni2.png"/> ">
            <p>Únete a la comunidad</p>
    	
        </header>


        <p id="titulo">Registro de Usuario</p>

        <form:form method="POST" action="/Uni2/guardarUsuario" onsubmit="return valida()">
            <div id="formulario">
                    <div id="datos_formulario">

                        <p>Datos Personales</p>
                        <form:label path="nombre" for="nombre">Nombre </form:label>
                        <form:input path="nombre" type="text" id="nombre" onclick="limpiaNombre()"/>
                        <div id="validacion_nombre" class="mensaje_error"></div>
                        <form:label path="apellido_paterno" for="apellido_paterno">Apellido Paterno </form:label>
                        <form:input path="apellido_paterno" type="text" id="apellido_paterno" onclick="limpiaApellidoPaterno()"/>
                        <div id="validacion_apellido_paterno" class="mensaje_error"></div>
                        <form:label path="apellido_materno" for="apellido_materno">Apellido Materno </form:label>
                        <form:input path="apellido_materno" type="text" id="apellido_materno" onclick="limpiaApellidoMaterno()"/>
                        <div id="validacion_apellido_materno" class="mensaje_error"></div>
                        <label for="carrera">Carrera </label>
                        <select id="carrera" name="id_carrera">
                            <c:forEach var="carrera" items="${carreras}">
                                <option value="${carrera.id_carrera}">${carrera.carrera}</option>
                            </c:forEach>
                        </select>

                        <hr>

                        <p>Datos de Perfil</p>
                        <form:label path="login" for="login">Login </form:label>
                        <form:input path="login" type="text" id="login" onclick="limpiaLogin()"/>
                        <div id="validacion_login" class="mensaje_error"></div>
                        <form:label path="contraseña" for="contrasena">Contraseña </form:label>
                        <form:input path="contraseña" type="password" id="contrasena" onclick="limpiaContrasena()"/>
                        <div id="validacion_contrasena" class="mensaje_error"></div>
                        <label for="repite_contrasena">Repite Contraseña </label>
                        <input path="repite_contraseña" type="password" id="repite_contrasena" name="repite_contraseña" onclick="limpiaRepiteContrasena()"/>
                        <div id="validacion_repite_contrasena" class="mensaje_error"></div>
                        
                        <hr>

                        <p>Contacto</p>
                        <form:label path="correo" for="correo">Correo </form:label>
                        <form:input path="correo" type="text" id="correo" onclick="limpiaCorreo()"/>
                        <div id="validacion_correo" class="mensaje_error"></div>
                        <form:label path="facebook" for="facebook">Facebook</form:label>
                        <form:input path="facebook" type="text" id="facebook" placeholder=" Ej. https://www.facebook.com/[ nombre usuario ]" onclick="limpiaFacebook()"/>
                        <div id="validacion_facebook" class="mensaje_error"></div>
                        <form:label path="whatsapp" for="whatsapp">Whats app</form:label>
                        <form:input path="whatsapp" type="text" id="whatsapp" onclick="limpiaWhatsapp()"/>
                        <div id="validacion_whatsapp" class="mensaje_error"></div>
                    </div>

                    <div id="privacidad">
                        <p>El dar click en <strong>Registrar Usuario</strong> significa que estas deacuerdo con nuestra
                        <a href=" <c:url value="/politicaPrivacidad"/> ">Política de privacidad</a> y <a href=" <c:url value="/condicionesUso"/> ">Condiciones de uso</a></p>
                    </div>

                    <button>Registrar Usuario</button>

            </div>
        </form:form> 

    </body>
</html>