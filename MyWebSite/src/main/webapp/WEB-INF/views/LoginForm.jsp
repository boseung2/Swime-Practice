<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css?<%=(int)(Math.random()*10)%>" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%-- 메소드 구현부입니다 --%>



<%-- end 메소드 --%>





<%-- 변수 선언부입니다 --%>
<%--
${!empty from ? from : \"\" }
 --%>
<c:set var="toPage" value="${pageContext.request.contextPath}/LoginAction${!empty from ? \"?from=\" += from : \"\" }"/>
<%-- 쿠키를 확인하는 곳입니다 --%>
<c:set var="check" value="${!empty cookie.id.value ? \"checked\" : \"\"}"/>
<div style="color: fff">
${toPage }
</div>

<%-- end 변수 --%>










<%-- 논리 구현부입니다 --%>


<%-- end 논리 --%>


<%-- 페이지 본문입니다 --%>
<div class="main_body">

	<div class="form">
		<%-- 제목입니다 --%>
		<div id="header"><a href="${pageContext.request.contextPath}/index">Spring Project</a></div>
		<%-- 에러메시지 출력입니다 --%>
		<div id="msg">${!empty msg ? msg : "<br>"}</div>
		
		<%-- 로그인 폼입니다 --%>
		<form action='${toPage}' method=post>
			<%-- 아이디 칸입입니다 --%>
			<div class="input_area">
				<input spellcheck="false" type="text" id="a" name="id" value="${cookie.id.value}" placeholder="Id">
			</div>
			<%-- 비밀번호 칸입니다 --%>
			<div class="input_area">
				<input spellcheck="false" type="password" id="b" name="password" placeholder="Password">
			</div>
			<%-- 아이디 기억 칸입니다 --%>
			<div class="remember">
				<input type="checkbox" ${check} id="c" name="remember_id" value="true">
				<label for="c">Remember ID</label>	
			</div>
			<%-- 제출 칸입니다 추가로 엎에 회원가입버튼이 있습니다 --%>
			<div class="button_area">
				<input type='submit' value="LOGIN">
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/Resister'">CREATE ACCOUNT</button>
			</div>
		</form>
		
		<div id="forgot">
		<a style="color: #999; background: transparent;" title="비밀번호를 잊어버리셨습니까?" href="#" >Forgot Password?</a>
		</div>
	</div>
	
</div>
<%-- end 본문 --%>
