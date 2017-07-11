<%--
name:
date:2017/07/06
comm:作品詳細画面
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
<body>
	<div class="col-sm-11">
		<div class="container">
			<table class="table table-bordered" cellpadding="0">
				<c:forEach var="od" items="${obentoDetail}" varStatus="status">
					<tr>
						<td><c:out value="${od.bento_name}" /></td>
					<tr>
						<td><img src="img/<c:out value="${od.image}" />.jpg"
							width="500px"></td>
					</tr>
				</c:forEach>
			</table>
			<form action="<%=request.getContextPath()%>/ConfirmVote" method="post">
			<div class="form-group">
				<c:if test="${voted == '0'}" var="flg" />
				<c:if test="${flg}">
					<!-- 未投票なら投票ボタン表示 -->
					<input type="hidden" name="obento_id" value="${od.obento_id}">
					<textarea name="comment" id="comment" cols="45" rows="8" maxlength="40" placeholder="ご感想をどうぞ(40字以内)" class="form-control"></textarea>
					<input type="submit" name="vote" value="投票する">
				</c:if>

				<c:if test="${!flg}">
					<!-- 投票済なら投票ボタンを表示しない -->
				</c:if>
				</div>
			</form>
		</div>
	</div>
</body>
</html>