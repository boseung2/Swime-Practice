<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:set var="login" value="${!empty MEMBERID}"/>
<c:set var="redir" value="/view/Login/LoginForm.jsp?from=${pageContext.request.requestURI}"/>

<c:if test="${!login}">
	<c:redirect url="${redir}"/>
</c:if>


<h1>게시판2 페이지입니다</h1>
