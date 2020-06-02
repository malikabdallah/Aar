<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Le titre</title>
</head>
<body>


${message}
<br/>

<form method="post" action="TraiteFormulaire?goto=acceuil">
    Saisir votre login : <input name="log" type="login"><br>
    Mot de passe : <input name="motdepasse" type="password"><br>
    <input type="Submit">
</form>

</body>
</html>s