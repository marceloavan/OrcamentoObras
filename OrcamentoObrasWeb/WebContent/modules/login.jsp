<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/css/login.css">
<title>Orça Obras - Login</title>
</head>
<body>

	<div id="login">
		<div id="img-login">
			<img alt="ImgLogin" src="resources/images/login.jpg">
		</div>
		<div id="form-login">
			<form action="processLogin.jsp" method="post">
				<input type="text" name="edtUser" value="" />
				<input type="password" name="edtPassword" value="" />
				<input type="submit" name="btnProcess" value="Entrar"/> 
			</form>
		</div>
	</div>
</body>
</html>