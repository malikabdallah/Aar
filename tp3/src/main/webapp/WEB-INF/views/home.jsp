
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: bineta
  Date: 25/09/19
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

bonjour ${login}
<br/>
voici vos competences
<br/>

<nav>
    <ul>
        <li>
            <a href="ajouterCompetences">
                vous souhaitez vous rajouter une competences ?
            </a>
        </li>

        <li>
            <a href="creerprojet">
                creer un projet
            </a>
        </li>


        <li>
            <a href="creerutilisateur">
                creer un utilisateur
            </a>
        </li>




        <li>
            <a href="deconnexion">
                deconnexion
            </a>
        </li>

    </ul>
</nav>





<c:forEach items="${competences }" var="element">

    <td>${element.getDeType().getIntituleC()}</td>:
    <td>${element.getDeType().getDescriptionC()}</td>

    <br/>
</c:forEach>


<br/>
<br/>

<p>********************* la liste des projets que vous dirigez*************************</p>
<c:forEach items="${dirige}" var="elem">
    ${elem.intituleP} : ${elem.descriptionP}
    <br/>
</c:forEach>

<p>********************* la liste de vos paticipations*************************</p>
<c:forEach items="${participe}" var="elem">
    ${elem.intituleP} : ${elem.descriptionP}
    <br/>
</c:forEach>
<br/>



<br/>
<br/>
*** *voici les projets auquels vous pouvez participer en raison de vos competences : ******
<br>
<c:forEach items="${acompetences }" var="element">

    <td>${element.getIntituleP()}</td>:
    <td>${element.getDescriptionP()}</td>

    <br/>
</c:forEach>




<br/>
<br/>
*** *voici les projets auquels vous ne pouvez participer en raison de votre manque de  competences : ******
<br>
<c:forEach items="${autre }" var="element">

    <td>${element.getIntituleP()}</td>:
    <td>${element.getDescriptionP()}</td>

    <br/>
</c:forEach>

<br/>
<br/>

</body>
</html>
