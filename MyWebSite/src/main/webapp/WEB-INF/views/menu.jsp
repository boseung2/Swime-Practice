<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>

<%request.setAttribute("index", request.getServletPath().contains("index.jsp"));%>
<c:set var="main" value="/css/main.css?4"/>
<c:set var="top" value="/css/topmenu.css?3"/>
<link rel="stylesheet" type="text/css" href="../..${ index ? pageContext.request.contextPath += main : main}" />
<link rel="stylesheet" type="text/css" href="../..${ index ? pageContext.request.contextPath += top : top}" />

<%--
<link rel="stylesheet" type="text/css" href="../css/main.css?123232" />
--%>



<!DOCTYPE html>
<html>
	<head>
		<title>My Dao web page</title>
	</head>
	<body>
		<div class="top">
		
			<div class="topMenu" >
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/view/index.jsp'">index</button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/view/Board/Board.jsp'">Board1</button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/view/Board/Board2.jsp'">Board2</button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/view/Resister/ResisterList.jsp'">ResisterList</button>
			<%--
			 --%>
			</div>
			<div class="loginbar" ">
		
				<c:if test="${!empty MEMBERID}">
					<c:set var="loginStatus" value="${MEMBERID}으로 로그인중입니다"/>
					${loginStatus}
					<button type="button" onclick="location.href='${pageContext.request.contextPath}/view/Resister/ResisterChange.jsp'">ResisterChange</button>
					<button type='button' onclick="location.href='${pageContext.request.contextPath}/view/Login/Logout.jsp'">Logout</button>
				</c:if>
				
				<c:if test="${empty MEMBERID}">
					<c:set var="loginStatus" value="로그인 중이 아닙니다"/>
					${loginStatus}
					<button type='button' onclick="location.href='${pageContext.request.contextPath}/view/Login/LoginForm.jsp'">Login</button>
					<button type='button' onclick="location.href='${pageContext.request.contextPath}/view/Resister/Resister.jsp'">Resister</button>
				</c:if>
			</div>
			
		</div>
