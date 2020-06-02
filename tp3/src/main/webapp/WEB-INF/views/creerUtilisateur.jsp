<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page session="false"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>
    creation utilisateur:
</p>
<br/>

<form:form action="creationUtilisateur" method="post" modelAttribute="membre">
    login :

    <form:input path="login"/><br/>
    <form:errors path="login" cssStyle="color:red;"/><br/>
    <form:errors cssStyle="color:red;"/><br/>



    mot de passe:
    <form:input path="motdepasse"/><br/>
    <form:errors path="motdepasse" cssStyle="color:red;"/><br/>
    <form:errors cssStyle="color:red;"/><br/>



    surnom:
    <form:input path="surnom"/><br/>
    <form:errors path="surnom" cssStyle="color:red;"/><br/>
    <form:errors cssStyle="color:red;"/><br/>

    <button type="submit">creation</button>
</form:form>

<a href="home">
    accueil
</a>
</body>
</html>
