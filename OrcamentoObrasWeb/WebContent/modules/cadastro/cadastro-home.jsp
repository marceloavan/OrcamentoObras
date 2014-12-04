<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
    
    <div id="cadastroUsuarioBtn">
      <a href="${pageContext.request.contextPath}/UsuarioController?action=listar" class="button-modules">
	    <img alt="Cadastro de usuário" src="${pageContext.request.contextPath}/resources/images/32x32/user.png">
	    <br/><br/>
    	<span><c:out value="Usuário"></c:out></span>
      </a>
    </div>
    
    <div id="cadastroTerrenoBtn">
      <a href="${pageContext.request.contextPath}/TerrenoController?action=listar" class="button-modules">
	    <img alt="Cadastro de terreno" src="${pageContext.request.contextPath}/resources/images/32x32/box.png">
	    <br/><br/>
    	<span><c:out value="Terreno"></c:out></span>
      </a>
    </div>
    
     <div id="cadastroCubBtn">
      <a href="${pageContext.request.contextPath}/CustoUnitarioBasicoController?action=listar" class="button-modules">
	    <img alt="Cadastro de custo unitário básico" src="${pageContext.request.contextPath}/resources/images/32x32/box.png">
	    <br/><br/>
    	<span><c:out value="Custo Unitário Básico"></c:out></span>
      </a>
    </div>
      
  </jsp:body>
</base:template>