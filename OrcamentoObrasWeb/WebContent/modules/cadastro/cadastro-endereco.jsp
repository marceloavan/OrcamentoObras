<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="edu.asselvi.orcamentoobrasw.utils.SystemUtils"%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>

<base:template>
  <jsp:body>
  	<form action="processAdress" method="post">
 		<div>
 			<label>Unidade Federativa</label>
 			<select>
 				<option>Marcelinho Gay</option>
 			</select>
 		</div>
 		<div>
 			<label>Município</label>
 			<select>
 				<option>Marcelinho Gay</option>
 			</select>
 		</div>
 		<div>
 			<label>Logradouro</label>
 			<input type="text">
 		</div>
 		<div>
 			<label>Número</label>
 			<input type="text">
 		</div>
 		<div>
 			<label>Bairro</label>
 			<input type="text">
 		</div>
 		<div>
 			<label>CEP</label>
 			<input type="text">
 		</div>
 		<div>
  			<input type="submit" value="Gravar">
  		</div>
  	</form>
  </jsp:body>
</base:template>