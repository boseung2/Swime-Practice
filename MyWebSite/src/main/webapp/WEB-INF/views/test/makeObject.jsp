<%@ page contentType = "text/html; charset=utf-8" %>
<jsp:setProperty property="id" name="member" value="madvirus"/>
<jsp:setProperty property="name" name="member" value="choi"/>
<%--
	member.setId("madvirus");
	member.setName("최범균");
--%>
<jsp:forward page="/test/useObject.jsp" />
