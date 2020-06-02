
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


    ajouter un commentaire
    <br/>


    <form method="post" action="Controlleur?todo=ajoutFini">



        la competences a ajoute :
        <select name="competencesMembres">
            <c:forEach items="${competences}" var="competence">
                <option value="${competence.intituleC}">
                        ${competence.intituleC}
                </option>
            </c:forEach>
        </select>
        <br/>
       niveau : <input type="number" step="1" min="1" max="5" name="niveau"/>
        <br/>
        <textarea name="commentaire" rows="3" cols="50">
            un commentaire ?
        </textarea>
        <br/>
        <input type="submit" value="envoyer">

    </form>


    <a href="Controlleur?todo=menu">
        retour a l acceuil

    </a>

</body>
</html>
