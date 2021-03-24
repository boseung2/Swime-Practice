<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import='java.util.Iterator'%>
<%@ page import='java.util.List'%>
<%@ page import='dao.UserDao'%>
<%@ page import='dao.User'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

@ModelAttribute("msg")<br>
msg = ${msg}<br>
param.msg = ${param.msg}<br>
<hr>
modelmsg<br>
modelmsg = ${modelmsg}<br>
param.modelmsg = ${param.modelmsg}<br>
<hr>
@ModelAttribute("hrefmsg")<br>
hrefmsg = ${hrefmsg}<br>
param.hrefmsg = ${param.hrefmsg}<br>
<hr>
hrefmsg2<br>
hrefmsg2 = ${hrefmsg2}<br>
param.hrefmsg2 = ${param.hrefmsg2}<br>