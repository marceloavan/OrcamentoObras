<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="edu.asselvi.orcamentoobrasw.utils.SystemUtils"%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
  		<span class="title_page">
	  		<c:out value="Cadastro de Custo Unitário Básico"></c:out>
		</span>
  		
  		<div class="box-cadastro">
  		
  			<div class="item-cadastro">
  				<label><c:out value="Mês"></c:out></label>
  				<input type="text" />
  			</div>
  		
  			
  			<div class="item-cadastro">
				<label><c:out value="Ano"></c:out></label>
  				<input type="text" /> 			
  			</div>
  		
  		
  			
  			<div class="item-cadastro">
  				<label><c:out value="Valor"></c:out></label>
  				<input type="text" />
  			</div>
  		
  		
  			<div class="button-cadastro"> 
  				<input type="button">
  			</div>
  		
  			<div class="button-cadastro">
  				<input type="button">
  			</div>
  		
  		</div>
  		
  </jsp:body>
</base:template>