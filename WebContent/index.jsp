<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css" />
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>

<body background="img/syou.jpg"style="background-size: cover;">

<div class="container"></div>
	<div style="background:#F2F2F2;
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	margin: auto;
	width:60%;height:60%;
	background: rgba(255,255,255,0.5);
	border-radius: 20px;
	">
	<div style="position:absolute;
	top:0px;right:0px;bottom:0px; left: 0px;
	margin: auto;width:100%;height:45%;
	">
	<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
	<div class="form-group" style="">
	<div class="row">
	<div class="col-xs-3" style="width:60%;">
	<input type="text" name="user_id" class="form-control" placeholder="学生番号"style="height:3em;
	margin-left:35%;">
	</div>
	</div>
	</div>
	<div class="form-group">
	<div class="row">
	<div class="col-xs-3"style="width:60%;">
	<input type="text" name="password" class="form-control" placeholder="誕生日" style="height:3em;
	margin-left:35%;
	margin-top:10%;
	"></div></div></div>
	<button type="submit" class="btn btn-default" style="
	margin-left:45%;
	margin-top:5%;
	">ログイン</button>
	</form></div></div>

</body>
</html>