<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Perfil Usuario</title>
</head>
<body>

<h2>Perfil Usuario</h2>
<form:form method="POST" action="/Uni2/guardarCambiosUsuario">
   <table>
    <tr>
        <td><form:label path="nombre">Nombre</form:label></td>
        <td><form:input value="${nombre} "path="nombre" /></td>
    </tr>
    <tr>
        <td><form:label path="apellido_paterno">Apellido Paterno</form:label></td>
        <td><form:input value="${apellido_paterno}" path="apellido_paterno" /></td>
    </tr>
    <tr>
        <td><form:label path="apellido_materno">Apellido Materno</form:label></td>
        <td><form:input value="${apellido_materno}" path="apellido_materno" /></td>
    </tr>
    <tr>
        <td><form:label path="contraseña">Contraseña</form:label></td>
        <td><form:input type="password" value="${contraseña}" path="contraseña" /></td>
    </tr>
    <tr>
        <td><form:label path="correo">Correo</form:label></td>
        <td><form:input value="${correo}" path="correo" /></td>
    </tr>
    <tr>
        <td><form:label path="facebook">Facebook</form:label></td>
        <td><form:input value="${facebook}" path="facebook" /></td>
    </tr>
    <tr>
        <td><form:label path="whatsapp">Whats App</form:label></td>
        <td><form:input value="${whatsapp}" type="number" path="whatsapp" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Guardar cambios"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>