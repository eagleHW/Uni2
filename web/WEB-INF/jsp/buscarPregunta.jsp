<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
      <title>Buscar pregunta</title>
            <meta charset="UTF-8">
            <link rel="icon" href=" <c:url value="/imagenes/foco.png"/> "/>
            <link rel="stylesheet" type="text/css" href=" <c:url value="/css/navegacion.css" /> ">
            <link rel="stylesheet" type="text/css" href=" <c:url value="/css/buscarPregunta.css" /> ">
            <link rel="stylesheet" type="text/css" href=" <c:url value="/css/listaPreguntas.css" /> ">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
            <script src=" <c:url value="/js/buscarPregunta.js" /> "></script>
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
        <aside>

            <p>Realiza tu búsqueda</p>
            <label for="palabra">Palabra clave </label>
            <input type="text" id="palabra_clave">
            <label for="usuario">Usuario </label>
            <input type="text" id="usuario">
            <label for="fecha">Fecha </label>
            <input type="date" id="fecha">
            <label for="carrera">Carrera </label>
            <select id="carrera">
                <option value="-1">Sin filtro</option>
            <c:forEach var="carrera" items="${carreras}">
                <option value="${carrera.id_carrera}">${carrera.carrera}</option>
            </c:forEach>
            </select>
            
            <button type="button" onclick="buscarPregunta()">Buscar</button>
        
            <img src=" <c:url value="/imagenes/lens.png"/> ">
            
        </aside>

        <div id="preguntas"></div>


        
        
        
    </body>
</html>