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
	  <div class="item-cadastro">
		<label><c:out value="Nome completo:"></c:out></label>
		<input type="text" />
	  </div>
	  
	  <div class="item-cadastro">
		<label><c:out value="Login:"></c:out></label>
		<input type="text" />
	  </div>
	  
	  <div class="item-cadastro">
		<label><c:out value="Senha:"></c:out></label>
		<input type="password" />
	  </div>
	  
	  <div class="button-cadastro">
	    <input type="button" value="Salvar">
	  </div>
	  
	  <div class="button-cadastro">
	    <input type="button" value="Cancelar">
	  </div>
	  
	</div>
  </jsp:body>
</base:template>