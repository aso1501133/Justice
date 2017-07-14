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
<script type="text/javascript">
	function linkclick(num) {
		//alert("入った");
		document.getElementById("bento_id").value = num;
		// alert("bento_idの値：" + document.getElementById("bento_id").value);
		document.formA.submit();
	}
</script>
</head>
<body>
	<div class="col-sm-11">
		<br>
		<form name="formA" method="post"
			action="<%=request.getContextPath()%>/RankDetail">
			<table class="table table-bordered" cellpadding="0">
				<c:forEach items="${obentoRanking}" var="ob">
				<tr>
				<td>
					<a href="javascript:void(0);" onclick="javascript:linkclick('${ob.bento_id}')"><c:out value="ob.bento_name" /></a>
				</td>
				</tr>
				<tr>
				<td>
					<c:out value="ob.votes" />
				</td>
				</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="bento_id" value="${ob.bento_id}" id="bento_id">
		</form>
</body>
</html>