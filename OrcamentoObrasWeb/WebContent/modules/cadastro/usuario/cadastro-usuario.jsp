<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
	<span class="title_page">
	  <c:out value="Cadastro de usuário"></c:out>
	</span>
	
	<div class="box-cadastro">
	  
	  <form action="UsuarioController" method="post" onsubmit="return checkInputs(['inptLogin', 'inptNomeComp', 'inptPasswd'], ['Login', 'Nome completo', 'Senha'])">
	    <div class="item-cadastro">
		  <label><c:out value="Login:"></c:out></label>
		  <input type="text" id="inptLogin" name="inptLogin" ${isEdicao ? "readonly style='background-color: #dddddd'" : ""} value="${inptLogin}"/>
	    </div>
	  
	    <div class="item-cadastro">
		  <label><c:out value="Nome completo:"></c:out></label>
		  <input type="text" id="inptNomeComp" name="inptNomeComp" value="${inptNomeComp}"/>
	    </div>
	  
	    <div class="item-cadastro">
		  <label><c:out value="Senha:"></c:out></label>
		  <input type="password" id="inptPasswd" name="inptPasswd" value="${inptPasswd}"/>
	    </div>
	    <!-- Action hidden -->
	    <input type="hidden" name="action" value="${action}"/>
	    
	    <div class="button-cadastro">
	      <input type="submit" value="Salvar">
	    </div>
	  
	    <div class="button-cadastro">
          <a href="UsuarioController?action=listar">
	        <input type="button" value="Cancelar">
	      </a>
	    </div>
	  </form>
	  
	</div>
  </jsp:body>
</base:template>