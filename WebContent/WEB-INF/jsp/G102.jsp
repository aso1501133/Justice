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
<link rel="stylesheet" href="WebContent/bootstrap.min.css"/>

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
<body background="img/d.jpg" style="background-size: cover;">
	<div class="col-sm-11">
		<br>
		<form name="formA" method="post"
			action="<%=request.getContextPath()%>/ShowDetail">
			<table class="table table-bordered" cellpadding="0">
				<%-- テーブルは上手いこと綺麗に並ぶようにいじってください --%>
				<c:forEach var="ol" items="${obentoList}" varStatus="status">
					<tr>
						<td><c:out value="${ol.bento_name}" /></td>
					</tr>
					<tr>
						<td>
							<a href="javascript:void(0);" onclick="javascript:linkclick('${ol.bento_id}')">>
								<div class="site_box_pic">
									<span class="pic_shadow"></span> 
									<img width="500" height="390"src="img/<c:out value="${ol.image}" />.jpg" width="150px"></a>
								</div>
						</a>

							<div class="contenthover">
								<h2 class="hover_name">
									<a href="javascript:void(0);" target="_blank"><c:out value="${ol.bento_name}" /></a>
								</h2></td>

					</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="bento_id" value="${ol.bento_id}"
				id="bento_id">
		</form>
	</div>
</body>
</html>