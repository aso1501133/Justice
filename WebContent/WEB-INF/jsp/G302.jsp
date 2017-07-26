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
<body background="img/syou1.JPG" style="background-size: cover;">

	<div class="container"></div>
	<div
		style="background: #F2F2F2; position: absolute; top: 0;
		 right: 0; bottom: 0; left: 0; margin: auto; width: 60%;
		  height: 60%; background: rgba(255, 255, 255, 0.5); border-radius: 20px;">
		<div style="text-align: center;">
			<c:forEach var="od" items="${obentoDetail}" varStatus="status">
				<h1>
					<c:out value="${od.bento_name}" />
				</h1>
			</c:forEach>
		</div>
		<div
			style="text-align: left; margin-left: 30px; width: 400px; height: 300px;">
			<c:forEach var="od" items="${obentoDetail}" varStatus="status">
				<img src="img/<c:out value="${od.image}" />.jpg" width="400px">
			</c:forEach>
		</div>
		<div
			style="text-align: right; margin-top: -300px; margin-right: 300px;">
			<p>頂いたコメント：</p>
			<c:forEach var="rd" items="${RankDetail}" varStatus="status">
				<p>
					<c:out value="${rd.comment}" />
				<p>
			</c:forEach>
		</div>
		<div
			style="position: absolute; top: 0px; right: 0px; bottom: 0px; left: 0px; margin: auto; width: 100%; height: 45%;">
			<div class="form-group" style="">
				<div class="row">
					<div class="col-xs-3" style="width: 60%;"></div>
				</div>
			</div>
			<div class="form-group">
				<div class="row">
					<div class="col-xs-3" style="width: 60%;"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>