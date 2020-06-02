
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: ilyas
  Date: 29/09/2019
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Title</title>
</head>
<body>



creation utilisateur

<br/>


<form method="post" action="Controlleur?todo=finitionutilisateur">

    login :<input type="text" name="login"/>
    <br/>
    mot de passe :<input type="text" name="mdp"/>
    <br/>

    surnom :<input type="text" name="surnon"/>
    <br/>



    <input type="submit" value="envoyer">

</form>


<a href="Controlleur?todo=menu">
    retour a l acceuil

</a>

</body>
</html>