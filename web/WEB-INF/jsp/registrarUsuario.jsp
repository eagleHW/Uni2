<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Registrar Usuario</title>
</head>
<body>

<h2>Registrar Usuario</h2>
<form:form method="POST" action="/Uni2/guardarUsuario">
   <table>
    <tr>
        <td><form:label path="login">Login</form:label></td>
        <td><form:input path="login" /></td>
    </tr>
    <tr>
        <td><form:label path="nombre">Nombre</form:label></td>
        <td><form:input path="nombre" /></td>
    </tr>
    <tr>
        <td><form:label path="apellido_paterno">Apellido Paterno</form:label></td>
        <td><form:input path="apellido_paterno" /></td>
    </tr>
    <tr>
        <td><form:label path="apellido_materno">Apellido Materno</form:label></td>
        <td><form:input path="apellido_materno" /></td>
    </tr>
    <tr>
        <td><form:label path="contraseña">Contraseña</form:label></td>
        <td><form:input type="password" path="contraseña" /></td>
    </tr>
    <tr>
        <td><form:label path="correo">Correo</form:label></td>
        <td><form:input path="correo" /></td>
    </tr>
    <tr>
        <td><form:label path="facebook">Facebook</form:label></td>
        <td><form:input path="facebook" /></td>
    </tr>
    <tr>
        <td><form:label path="whatsapp">Whats App</form:label></td>
        <td><form:input path="whatsapp" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Registrarse"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>