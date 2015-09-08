<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>跳转中..</title>
</head>
<body>
<security:authentication property="principal.username"/>
<security:authorize ifAllGranted="ROLE_ADMIN">
    <c:redirect url="/admin/index.do"/>
</security:authorize>
<security:authorize ifAllGranted="ROLE_USER">
    <c:redirect url="/user/index.do"/>
</security:authorize>
<security:authorize ifNotGranted="ROLE_ADMIN,ROLE_USER">
    <c:redirect url="/index.do"></c:redirect>
</security:authorize>
</body>
</html>