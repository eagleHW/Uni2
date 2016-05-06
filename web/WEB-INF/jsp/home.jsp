<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Home</title>
</head>
<body>

<h2>Bienvenido</h2>
   <table>
    <tr>
        <td>Login</td>
        <td><a href='<c:url value='/perfilUsuario'/>'>${login}</a></td>
    </tr>
</table>  
 <a href='<c:url value='/logout'/>'>Logout</a>    
 <a href='<c:url value='/realizarPregunta'/>'>Realizar Pregunta</a>  
</body>
</html