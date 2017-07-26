<%--
name:
date:2017/07/06
comm:作品詳細画面
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<%@ page session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="img/d.jpg" style="background-size: cover;">
	<div
		style="background: #F2F2F2; position: absolute; top: 0; right: 0;
		 bottom: 0; left: 0; margin: auto; width: 60%; height: 60%;
		  background: rgba(255, 255, 255, 0.5); border-radius: 20px;">
		<div class="col-sm-11">
			<div class="container">
					<c:forEach var="od" items="${obentoDetail}" varStatus="status">
						
							<h1><c:out value="${od.bento_name}" /></h1>
						<img src="img/<c:out value="${od.image}" />.jpg"
								width="500px">
				<form action="<%=request.getContextPath()%>/ConfirmVote"
					method="post">
					<div class="form-group">
						<c:if test="${voted == 0}" var="flg" />
						<c:if test="${flg}">
							<!-- 未投票なら投票ボタン表示 -->
							<input type="hidden" name="bento_id" value="${od.bento_id}">
							<textarea name="comment" id="comment" cols="45" rows="8"
								maxlength="40" placeholder="ご感想をどうぞ(40字以内)" class="form-control"></textarea>
							<input type="submit" name="vote" value="投票する">
						</c:if>
				</form>

				<c:if test="${!flg}">
					<!-- 投票済なら投票ボタンを表示しない -->
				</c:if>
				</c:forEach>
			</div>

		</div>
	</div>
</body>
</html>