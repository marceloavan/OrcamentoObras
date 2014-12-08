<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/template.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/utils-orcamento-obras.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/24x24/icon24x24.ico" >
    <title>Orça Obras - Configuração da base de dados</title>
</head>
<body>
	
    <span class="title_page">
  		<c:out value="Configuração da base de dados"></c:out>
	</span>
	
	<div class="box-cadastro">
	  
	  <form action="DatabaseConfigController" method="post" onsubmit="return checkInputs(['inptHost', 'inptPort', 'inptDatabase', 'inptUsuario', 'inptSenha'], ['Host', 'Port', 'Database', 'Usuário', 'Senha'])">
	    
	    <div class="item-cadastro">
		  <label><c:out value="Host"></c:out></label>
		  <input type="text" id="inptHost" name="inptHost" value="${inptHost}"/>
	    </div>
	  
	    <div class="item-cadastro">
		  <label><c:out value="Port"></c:out></label>
		  <input type="text" id="inptPort" name="inptPort" value="${inptPort}"/>
	    </div>
	    
	    <div class="item-cadastro">
		  <label><c:out value="Database"></c:out></label>
		  <input type="text" id="inptDatabase" name="inptDatabase" value="${inptDatabase}"/>
	    </div>
	  
	    <div class="item-cadastro">
		  <label><c:out value="Usuário"></c:out></label>
		  <input type="text" id="inptUsuario" name="inptUsuario" value="${inptUsuario}"/>
	    </div>
	    
	    <div class="item-cadastro">
		  <label><c:out value="Senha"></c:out></label>
		  <input type="password" id="inptSenha" name="inptSenha"/>
	    </div>
	    
	    <div class="button-cadastro">
	      <input type="submit" value="Gravar">
	    </div>
	  
	    <div class="button-cadastro">
          <a href="${pageContext.request.contextPath}">
	        <input type="button" value="Cancelar">
	      </a>
	    </div>
	  </form>
	  
	</div>
	
	<jsp:include page="../components/message.jsp" />
	
</body>

</html>