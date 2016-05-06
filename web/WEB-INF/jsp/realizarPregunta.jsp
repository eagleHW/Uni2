<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Realizar Pregunta</title>
</head>
<body>

<h2>Realizar Pregunta</h2>
<form:form method="POST" action="/Uni2/guardarPregunta">
   <table>
    <tr> <form:label path="titulo">Título  </form:label> </tr>
    <tr> <form:input path="titulo"/> </tr>
    <tr> <td> <label>Descripción</label> </td> </tr>   
    <tr>
        <td>
            <form:textarea path="descripcion" rows="5" cols="30" value="Escribe aquí tu pregunta"/>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="RealizarPregunta"/>
        </td>
    </tr>
</table>       
</form:form>
</body>
</html>