
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: bineta
  Date: 23/09/19
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>

</head>
<body>




<form method="post" action="Controlleur?todo=acceuil">

    login :<input type="text" name="login"/>

    mot de passe :<input type="password" name="password"/>


    <input type="submit">


    <p style="color: red"> ${message}</p>
</form>
</body>
</html>



