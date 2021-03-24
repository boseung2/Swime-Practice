<%@page import="dao.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.UserDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css?<%=(int)(Math.random()*10)%>" />


<%--변수 선언부입니다 --%>


<%-- 액션페이지로 갈때에 정상루트를 통했는지 쿼리를 가지고 갑니다 --%>
<c:set var="toPage" value="${pageContext.request.contextPath}/ResisterAction"/>
<%-- end 변수 --%>
    
    


<%-- 페이지 본문입니다 --%>
<div class="main_body">

	<div class="form">
		<%-- 제목입니다 --%>
		<div id="header"><a href="${pageContext.request.contextPath}/index">RESISTER</a></div>
		<%-- 에러메시지 출력입니다 --%>
		<div id="msg">${!empty msg ? msg : "<br>"}</div>
		
		<%-- 가입폼입니다 --%>
		<form action='${toPage}' method=post>
			<div class="input_area">
				<input spellcheck="false" type="text" id="Id" name="id" value="${user.id}" placeholder="ID">
			</div>
			<div class="input_area">
			    <input type="password" id="Pw" name="password" value="${user.password}" placeholder="Password">
			</div>
			<div class="input_area">
			    <input spellcheck="false" type="text" id="Name" name="name" value="${user.name}" placeholder="Name">
			</div>
			<div class="input_area">
			    <input spellcheck="false" type="Email" id="Email" name="email" value="${user.email}" placeholder="Email">
			</div>
			<div class="button_area">
			    <input type='submit' value='RESISTER'>
		    </div>
		</form>
		<br>
	</div>
	
</div>
<%-- end 본문 --%>