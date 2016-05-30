<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
    <head>
	<title>Home</title>
	<meta charset="UTF-8">
	<link rel="icon" href=" <c:url value="/imagenes/foco.png"/> "/>
        <link rel="stylesheet" type="text/css" href=" <c:url value="/css/navegacion.css" /> ">
	<link rel="stylesheet" type="text/css" href=" <c:url value="/css/home.css" /> ">
        <link rel="stylesheet" type="text/css" href=" <c:url value="/css/listaPreguntas.css" /> ">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.3/jquery.min.js"></script>
        <script src=" <c:url value="/js/home_pregunta.js" /> "></script>
    </head>
    <body>

	<nav>
		
            <div>
                <p>Bienvenido : <a href=" <c:url value="/perfilUsuario"/> ">${login}</a> | <a href=" <c:url value="/logout"/> ">Logout</a> </p>
            </div>
                <a href=" <c:url value="/home"/> "><img src=" <c:url value="/imagenes/uni2.png"/> "></a>

                <ul>
                    <li><a href=" <c:url value="/publicarPregunta"/> ">Publicar Pregunta</a></li>
        	    <li><a href=" <c:url value="/buscarPregunta"/> ">Buscar Pregunta</a></li>
		    <li><a href=" <c:url value="/perfilUsuario"/> ">Ver Perfil</a></li>
                </ul>

            </nav>

            <div id="preguntas">
            <!--En este div se insertaran las preguntas--> 
            </div>
            
            <div id="navegacion_preguntas">
                <button id="regresar" type="button" onclick="regresar()">Regresar</button>
                <button id="seguir" type="button" onclick="seguir()">Seguir</button>
            </div>    

                    
	</body>
</html>