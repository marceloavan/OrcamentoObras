<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
  	<span class="title_page">
	  	<c:out value="Cadastro de Custo Unitário Básico"></c:out>
	</span>
  		
  	<div class="box-cadastro">
  	
  	<form action="CustoUnitarioBasicoController" method="post" onsubmit="return checkInputs([inptMes,inptAno,inptValor],[Mês, Ano, Valor])">
  		<div class="item-cadastro">
  			<label><c:out value="Mês"></c:out></label>
  			<input type="text" id="inptMes" name="inptMes" value="${inptMes}"/>
  		</div>
  			
  		<div class="item-cadastro">
			<label><c:out value="Ano"></c:out></label>
  			<input type="text" id="inptAno" name="inptAno" value="${inptAno}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
  			<label><c:out value="Valor"></c:out></label>
  			<input type="text" id="inptValor" name="inptValor" value="${inptValor}"/>
  		</div>
  		
  		<!-- Action hidden -->
  		<input type="hidden" name="action" value="${action}">
  		<input type="hidden" name="inptId" value="${inptId}">
  		
  		<div class="button-cadastro"> 
  			<input type="submit" value="Salvar">
  		</div>
  		
  		<div class="button-cadastro">
  			<a href="CustoUnitarioBasicoController?action=listar">
  				<input type="button" value="Cancelar">
  			</a>
  		</div>
  	</form>	
  	</div>
  		
  </jsp:body>
</base:template>