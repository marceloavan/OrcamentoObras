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

	<div id=header>
		<div id="header-inner" class=center>
			<img alt="OrcaObras" class="image-head" src="resources/images/logo.png"/>
		</div>
		
	</div>
	
	<div id="body-page">
		<img class="image-login" alt="ImgLogin" src="resources/images/login.jpg">
			<div id="form-login">
				<form action="processLogin.jsp" method="post">
					<br><br><br><br>
					<span>Usuário</span>
					<input type="text" name="edtUser" value="" />
					<br>
					<span>Senha</span>
					<input type="password" name="edtPassword" value="" />
					<br>
					<input type="submit" name="btnProcess" value="Entrar"/> 
				</form>
			</div>
	</div>
	
	
	
</body>
</html>