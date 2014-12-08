<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
	<span class="title_page">
	  <c:out value="Cadastro de orçamento"></c:out>
	</span>
	
	<div class="box-cadastro">
	  
	  <form action="OrcamentoController" method="post" onsubmit="return checkInputs(['inptLogin', 'inptNomeComp', 'inptPasswd'], ['Login', 'Nome completo', 'Senha'])">
		  
	    <div class="item-cadastro">
		  <label><c:out value="Nome"></c:out></label>
		  <input type="text" id="inptNome" name="inptNome" value="${inptNome}"/>
	    </div>
	    
	    <div class="item-cadastro">
		  <label><c:out value="Descrição"></c:out></label>
		  <textarea id="inptDesc" name="inptDesc" >${inptDesc}</textarea>
	    </div>
	    
	    <div class="item-cadastro">
		  <label><c:out value="Metragem construção"></c:out></label>
		  <input type="text" id="inptMetragemConst" name="inptMetragemConst" value="${inptMetragemConst}"/>
	    </div>
	    
	    <div class="item-cadastro">
		  <label><c:out value="Lucro (%)"></c:out></label>
		  <input type="text" id="inptLucro" name="inptLucro" value="${inptLucro}"/>
	    </div>
	  
	    <!-- Action hidden -->
	    <input type="hidden" name="action" value="${action}"/>
	    
	    <div class="button-cadastro">
	      <input type="submit" value="Salvar">
	    </div>
	  
	    <div class="button-cadastro">
          <a href="OrcamentoController?action=listar">
	        <input type="button" value="Cancelar">
	      </a>
	    </div>
	  </form>
	  
	</div>
  </jsp:body>
</base:template>