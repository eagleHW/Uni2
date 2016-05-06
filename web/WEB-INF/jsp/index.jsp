<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Iniciar Sesión</h2>
<form method="POST" action="/Uni2/login">
   <table>
    <tr>
        <td><label>Login</label></td>
        <td><input name="login" /></td>
    </tr>
    <tr>
        <td><label>Password</label></td>
        <td><input type="password" name="password"/></td>
    </tr>
        <td>${error}</td>
    <tr>
        <td colspan="2">
            <input type="submit" value="Iniciar Sesión"/>
        </td>
    </tr>
</table>  
 <a href='<c:url value='/registrarUsuario'/>'>Registrarse</a>       
</form>
</body>
</html>