
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


creation projet

<br/>


<form method="post" action="Controlleur?todo=finitionprojet">

    intitule :<input type="text" name="intitule"/>
    <br/>
    descirption :<input type="text" name="description"/>
    <br/>


    la competences a necessaire :
    <br/>

    <c:forEach items="${competences}" var="competence">
            ${competence.intituleC}:<input type="checkbox" value="${competence.intituleC}" name="liste"/>
            <br/>
        </c:forEach>
    <br/>

    <input type="submit" value="envoyer">

</form>


<a href="Controlleur?todo=menu">
    retour a l acceuil

</a>

</body>
</html>