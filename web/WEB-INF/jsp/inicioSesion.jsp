<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    	<title>Inicio de sesi�n</title>
        <link rel="icon" href=" <c:url value="/imagenes/foco.png"/> "/>
        <link rel="stylesheet" type="text/css" href=" <c:url value="/css/header.css" /> ">
        <link rel="stylesheet" type="text/css" href=" <c:url value="/css/inicioSesion.css" /> ">    
    </head>
    <body>
    	
    	<header>
    			
            <img src=" <c:url value="/imagenes/uni2.png"/> ">
            <p >�Dudas?, viniste al lugar adecuado</p>
    	
        </header>

        <p id="titulo">Inicio de Sesi�n</p>
        <form method="POST" action="/Uni2/login">
            <div id="formulario">

                <input id="login" name="login" type="text" placeholder=" Login"> <br>
                <input id="contrasena" name="contrasena" type="password" placeholder=" Contrase�a">
                <span>${error}</span>
                <button>Iniciar Sesi�n</button>
                <p>�A�n no eres parte de la comunidad?, <a href="<c:url value='/registroUsuario'/>">reg�strate</a> .</p>

            </div>
        </form>
    </body>
</html>
