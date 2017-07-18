<%--
name:
date:2017/07/06
comm:結果詳細
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
	<div class="col-sm-11">
		<div class="container">
			<table class="table table-bordered" cellpadding="0">
				<c:forEach var="od" items="${obentoDetail}" varStatus="status">
					<tr>
						<td><c:out value="${od.bento_name}" /></td>
					</tr>
					<tr>
						<td><img src="img/<c:out value="${od.image}" />.jpg" width="500px"></td>
					</tr>
				</c:forEach>
				<p>頂いたコメント：</p>
				<c:forEach var="rd" items="${RankDetail}" varStatus="status">
					<tr>
						<td><c:out value="${rd.comment}" /></td>
					</tr>
			</table>
			</c:forEach>
		</div>
	</div>
</body>
</html>