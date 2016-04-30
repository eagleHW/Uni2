<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login</h2>
<form:form method="POST" action="/Uni2/home">
   <table>
    <tr>
        <td><form:label path="login">Login</form:label></td>
        <td><form:input path="login" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input type="password" path="password" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</body>
</html>