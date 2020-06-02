<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page session="false"%>
<html>
<head>

    <title>Home</title>
</head>
<body>
<h1>Hello world!</h1>



<form:form action="connexion" method="post" modelAttribute="membre">
    <form:label path="login"/>
    <form:input path="login"/><br/>
    <form:errors path="login" cssStyle="color:red;"/><br/>
    <form:errors cssStyle="color:red;"/><br/>



    <form:label path="motdepasse"/>
    <form:input path="motdepasse"/><br/>
    <form:errors path="motdepasse" cssStyle="color:red;"/><br/>
    <form:errors cssStyle="color:red;"/><br/>

    <button type="submit">Login</button>
</form:form>
</body>
</html>
