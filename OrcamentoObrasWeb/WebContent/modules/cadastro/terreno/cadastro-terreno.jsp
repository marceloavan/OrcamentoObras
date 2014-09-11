<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="edu.asselvi.orcamentoobrasw.utils.SystemUtils"%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>

<base:template>
  <jsp:body>
  	<form action="processGround" method="post">
  		<div>
  			<label>Descrição</label>
  			<input type="text">
  		</div>
  		<div>
  			<label>Metragem</label>
  			<input type="text">
  		</div>
  		<div>
  			<label>Valor de Venda</label>
  			<input type="text"> 
  		</div>
  		<div>
  			<label>Valor ITBI</label>
  			<input type="text">
  		</div>
  		<div>
  			<label>Valor FRJ</label>
  			<input type="text">
  		</div>
  		<div>
  			<label>Valor Escritura</label>
  			<input type="text">
  		</div>
  		<div>
			<label>Valor Registro</label>
			<input type="text">  		
  		</div>
  		<div>
  			<label>Endereço</label>
  			<select>
  				<option>Marcelinho Gay</option>
  			</select>
  		</div>
  		<div>
  			<input type="submit" value="Gravar">
  		</div>
  	</form>
  </jsp:body>
</base:template>


