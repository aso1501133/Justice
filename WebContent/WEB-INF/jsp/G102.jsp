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
<!-- <link rel="stylesheet" href="/WebContent/bootstrap.min.css" /> -->
<!-- <link rel="stylesheet" href="/WebContent/css/style.css"/> -->

<title>Insert title here</title>
<script type="text/javascript">
	function linkclick(num) {
		//alert("入った");
		document.getElementById("bento_id").value = num;
		// alert("bento_idの値：" + document.getElementById("bento_id").value);
		document.formA.submit();
	}
</script>
<style type="text/css">

html{
    height:auto;
    margin:0px;
}
body{
    height:auto;
    margin:0px;
}
#main{
	height:auto;
	overflow:auto;
}
.table {
	text-align: center;
	margin-left:auto;
	margin-right:auto;
	
}


.gundam{background:#F2F2F2;
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	margin: auto;
	width:70%;height:70%;
	background: rgba(255,255,255,0.75);
	border-radius: 20px;
	height:100%;
	min-height:100%;
}
#main{
	height:auto;
}
h1{
	text-align:center;
}

</style>

</head>
<body background="img/d.jpg"style="background-size: cover;">
		<div class="gundam" id="main">
		<h1>画像をクリックすると投票画面に遷移します</h1>
		<br>
		<form name="formA" method="post"
			action="<%=request.getContextPath()%>/ShowDetail">
			<table class="table table-bordered" cellpadding="0" style="text-align:center;">
				<%-- テーブルは上手いこと綺麗に並ぶようにいじってください --%>
				
					<c:forEach var="ol" items="${obentoList}" varStatus="status">
					
						
						<tr>
						<section class="site_box">
						<div class="1">
						
							<td><a href="javascript:void(0);"
								onclick="javascript:linkclick('${ol.bento_id}')">
									 <img width="500" height="390"
											src="img/<c:out value="${ol.image}" />.jpg" width="150px">
							</a>
						</div>

							<h2 class="hover_name">
								<c:out value="${ol.bento_name}" /></a>
							</h2>
						</section>
						</tr>
					
					</c:forEach>
				
			</table>
			<input type="hidden" name="bento_id" value="${ol.bento_id}"
				id="bento_id">
		</form>
	</div>
</body>
</html>