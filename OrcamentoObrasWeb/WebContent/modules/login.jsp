<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/24x24/icon24x24.ico" >
<title>Orça Obras - Login</title>
</head>
<body>
	
	<div id="body">
		<div id=header>
			<div id="header-inner" class=center>
				<img alt="OrcaObras" class="image-head" src="${pageContext.request.contextPath}/resources/images/logo.png"/>
			</div>
		</div>
		<img class="image-login" alt="ImgLogin" src="${pageContext.request.contextPath}/resources/images/login.jpg">
			<div id="form-login">
				<div id="login-user">
					<form action="${pageContext.request.contextPath}/AuthController" method="post">
						<span><c:out value="Usuário"/></span>
						<input type="text" name="userNameLogin" />
						<br/>
						<span><c:out value="Senha"/></span>
						<input type="password" name="passwdLogin" />
						<br/>
						<input type="submit" name="btnProcess" value="Entrar"/>
						<br/>
						<a href="DatabaseConfigController?action=configurar">Configurar base de dados</a> 
					</form>
				</div>
			</div>
	</div>
	
	<jsp:include page="../components/message.jsp" />
</body>
</html>