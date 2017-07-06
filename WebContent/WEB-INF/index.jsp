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

<body>
<div class="container">

	<h1>週間スケジュール</h1>
	</div>
	<div class="container">
		<!--  Loginサーブレットに送信 -->
		<form action="<%=request.getContextPath()%>/LoginServlet" method="post" >
			<div class="form-group">
				<label>ユーザーID</label>
				<div class="row">
					<div class="col-xs-3">
						<input type="text" name="userID" class="form-control" placeholder="ユーザーID">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label>パスワード</label>
				<div class="row">
					<div class="col-xs-3">
						<input type="text" name="password" class="form-control" placeholder="パスワード">
					</div>
				</div>
			</div>
			<button type="submit">ログイン</button>
		</form>
	</div>
</body>
</html>