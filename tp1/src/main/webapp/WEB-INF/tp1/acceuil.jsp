<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Le titre</title>
</head>
<body>

bonjour ${login}
<br/>
voici vos competences
<br/>
<c:forEach items="${competences }" var="element">

        <td>${element.getDeType().getIntituleC()}</td>:
        <td>${element.getDeType().getDescriptionC()}</td>

    <br/>
</c:forEach>


<br/>
<br/>
voici les projets que vous diriges :
<br>
<c:forEach items="${dirige }" var="element">

    <td>${element.getIntituleP()}</td>:
    <td>${element.getDescriptionP()}</td>

    <br/>
</c:forEach>




<br/>
<br/>
voici les projets auquels vous participer :
<br>
<c:forEach items="${participe }" var="element">

    <td>${element.getIntituleP()}</td>:
    <td>${element.getDescriptionP()}</td>

    <br/>
</c:forEach>



<br/>
<br/>
voici les projets auquels vous pouvez participer en raison de vos competences :
<br>
<c:forEach items="${acompetence }" var="element">

    <td>${element.getIntituleP()}</td>:
    <td>${element.getDescriptionP()}</td>

    <br/>
</c:forEach>




<br/>
<br/>
voici les projets auquels vous ne pouvez participer en raison de votre manque de competences dans le domaine :
<br>
<c:forEach items="${autres }" var="element">

    <td>${element.getIntituleP()}</td>:
    <td>${element.getDescriptionP()}</td>

    <br/>
</c:forEach>
</body>
</html>