<%@page import="java.util.List"%>
<%@ page contentType = "text/html; charset=utf-8" %>
<jsp:useBean id="user" scope="request" class="dao.User" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import='dao.UserDao'%>
<%@ page import='dao.User'%>
<%
	UserDao udo = UserDao.getInstance();
List<dao.User> list = udo.selectAllUsers();
request.setAttribute("list", list);
%>

<c:forEach var="user" items="${ list }">
	${ user }<br>
</c:forEach>









