<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Publicar Pregunta</title>
    <link rel="icon" href=" <c:url value="/imagenes/foco.png"/> "/>
    <link rel="stylesheet" type="text/css" href=" <c:url value="/css/navegacion.css" /> ">
    <link rel="stylesheet" type="text/css" href=" <c:url value="/css/publicarPregunta.css" /> ">
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
            <li><a href="">Buscar Pregunta</a></li>
	    <li><a href="">Ver Perfil</a></li>
        </ul>

    </nav>
    
    <p id="titulo">Publicar pregunta</p>
    
    <form:form method="POST" action="/Uni2/guardarPregunta">
        <div id="formulario">

            <div id="pregunta">
                <form:label path="titulo" for="titulo_pregunta">Título</form:label>
                <form:input path="titulo" type="text" id="titulo_pregunta"/>
                <form:label path="descripcion" for="descripcion">Descripción</form:label>
                <form:textarea path="descripcion" id="descripcion" cols="30" rows="10"></form:textarea>
            </div>

            <div id="pregunta_tag">
                <form:label path="carrera" for="carrera">Carrera </form:label>
                <select id="carrera" name="id_carrera">
                    <c:forEach var="carrera" items="${carreras}">
                        <option value="${carrera.id_carrera}">${carrera.carrera}</option>
                    </c:forEach>
                </select>
            </div>

            <button>Publicar pregunta</button>
    
        </div>
    </form:form>    

</body>
</html>
