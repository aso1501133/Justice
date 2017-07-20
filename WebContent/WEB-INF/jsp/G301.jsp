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
<body background="img/d.jpg"style="">
<div style=" width: 60%;
    margin: 0 auto;
    text-align: center;
    margin-top:30px;
  ">
<p style="font-size:40px">結果発表</p>
</div>
<div style=" width: 60%;
    margin: 0 auto;
    margin-top:30px;">
    <form name="formA" method="post" action="<%=request.getContextPath()%>/RankDetail">
    <% int i=1; %>
    <c:forEach var="ol" items="${obentoRanking}" varStatus="status">
    <div style="width:100%;
	height:250px;
	background:white;
	border: 3px #F6F3F3 solid;
	border-radius: 20px;
	margin-top:20px;
	">
	<div style="font-size:70px;
	width:auto;
	height:auto;
	margin-top:60px;
	margin-left:20px;
	">
	<p style="margin-left:30px;">
	<% out.print(i+"位");
	i=i+1;
	%>
	<p>
	</div>
	<p style="margin-left:380px;
	font-size:50px;
	margin-top:-150px;
	"><c:out value="${ol.bento_name}"/></p>
	<a href="javascript:void(0);" onclick="javascript:linkclick('${ol.bento_id}')">
	<img src="img/<c:out value="${ol.image}" />.jpg" width="150px" style="margin-top:-150px; margin-left:200px;"></a>
	</div>
	</c:forEach>
	<input type="hidden" name="bento_id" value="${ol.bento_id}" id="bento_id">
	</form>
	</div>
	</body>
</html>