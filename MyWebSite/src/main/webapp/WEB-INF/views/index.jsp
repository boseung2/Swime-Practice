<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css?<%=(int)(Math.random()*10)%>" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main_body">

<%-- 본문입니다 --%>
<div>
	<table>
		<tr>
			<td>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/LoginForm'"><h2>login</h2></button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/Logout'"><h2>logout</h2></button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/Board/Board'"><h2>board</h2></button>
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/Board/Board1'"><h2>board1</h2></button>
			</td>
			<td>
				<div style="color: fff;">
					${!empty MEMBERID ? MEMBERID += "로 로그인중입니다" : "로그인중이 아닙니다" }
				</div>
			</td>
		</tr>
	</table>
</div>
<br>

<%-- 제목라인입니다 --%>
<div id="header"><a href="${pageContext.request.contextPath}/index">Spring Project</a></div>
<%-- 부제목 라인입니다 --%>
<h2>cookie, session, login, resister</h2>

<pre>
resister info, list
</pre>




<button type="button" onclick="location.href='https://cafe.naver.com/nks13'"><h2>카페이동</h2></button>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/newindex'"><h2>newIndex</h2></button>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/test/test'"><h2>테스트페이지</h2></button>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/test/test2'"><h2>테스트페이지2</h2></button>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/test/test3'"><h2>테스트페이지3</h2></button>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/StudyInfomation/request'"><h2>리퀘스트 메소드</h2></button>

<!-- 
<div class="fixed" style="position: fixed;bottom: 0;right: 0;width: auto;">
	<img src="${pageContext.request.contextPath}/Img/hani.jpg" alt="I'm codeMonkey">
</div>
 -->
</div>




