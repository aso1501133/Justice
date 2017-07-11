<%--
name:
date:2017/07/06
comm:最終結果画面
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${votes}" var="votes">
<c:out value="votes.bento_id"/>
<c:out value="votes.votes"/>
<c:out value="votes.comment"/>
</c:forEach>
</body>
</html>