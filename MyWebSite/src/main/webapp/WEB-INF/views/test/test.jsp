<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import='java.util.Iterator'%>
<%@ page import='java.util.List'%>
<%@ page import='dao.UserDao'%>
<%@ page import='dao.User'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${pageContext.request.contextPath}/test/test2" method=post>
	<input inputmode="text" name="msg">
	<input type="submit">
</form>

<a href="${pageContext.request.contextPath}/test/test2?hrefmsg=asdf1234&hrefmsg2=qwer1234&redirect=true">리다이렉트 파라미터</a>

<style>
@-webkit-keyframes blackWhite {  
  0% { background-color: white; }
  50% { background-color: white; }
  51% { background-color: black; }
  100% { background-color: black; }
}

.blinkdiv {
    height: 100px;
    width:100px;
    background-color: black;
    -webkit-animation-name: blackWhite;  
    -webkit-animation-iteration-count: infinite;  
    -webkit-animation-duration: 2s; 
}   

@-webkit-keyframes rainbow {  
  0% { background-color: red; }
  16% { background-color: orange; }
  32% { background-color: yellow; }
  48% { background-color: green; }
  66% { background-color: blue; }
  83% { background-color: navy; }
  100% { background-color: purple; }
}

.rainbow {
    height: 100px;
    width:100px;
    background-color: black;
    -webkit-animation-name: rainbow;  
    -webkit-animation-iteration-count: infinite;  
    -webkit-animation-duration: 1s; 
}   
</style>

<div class="blinkdiv">
</div>
<div class="rainbow">
</div>