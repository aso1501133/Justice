<%--
name:
date:2017/07/06
comm:投票確認画面
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/kadai3/css/style.css">
</head>
<body background="img/d.jpg" style="background-size: cover;">
	<div id="backArea">
		<div class="col-sm-11">
			<div class="container">
				<c:forEach var="od" items="${obentoDetail}" varStatus="status">
					<div style="text-align: center;">
						<h1>
							<c:out value="${od.bento_name}" />
						</h1>
					</div>
					<div id="img">
						<img src="img/<c:out value="${od.image}" />.jpg" width="500px">
					</div>

					<div id="comment">
						<p>コメント：</p>
						${requestScope.comment}
						<p>以上の内容で投票しますか？</p>
						<form action="<%=request.getContextPath()%>/VoteServlet" method="post">
							<div class="form-group">
								<input type="hidden" name="bento_id" value="${od.bento_id}">
								<input type="hidden" name="comment" value="${requestScope.comment}"> 
								<input type="submit" name="vote" value="完了">
								<a href="#" onclick="javascript:window.history.back(-1);return false;">
								<button type="button" name="cancel" value="キャンセル">キャンセル</button>
								</a>
							</div>
						</form>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>