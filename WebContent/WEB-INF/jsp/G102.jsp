<%--
name:
date:2017/07/06
comm:作品選択画面
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
function linkclick (num) {
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
		<form name="formA" method="post" action="<%=request.getContextPath()%>/ShowDetail">
			<table class="table table-bordered" cellpadding="0">
			<%-- テーブルは上手いこと綺麗に並ぶようにいじってください --%>
				<c:forEach var="ol" items="${obentoList}" varStatus="status">
				<tr>
				<td><c:out value="${ol.bento_name}"/></td>
				</tr>
				<tr>
				<td>
				<a href="javascript:void(0);" onclick="javascript:linkclick('${ol.bento_id}')"><img src="img/<c:out value="${ol.image}" />.jpg" width="150px"></a>
				</td>
				</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="bento_id" value="${ol.bento_id}" id="bento_id">
		</form>
	</div>
</body>
</html>