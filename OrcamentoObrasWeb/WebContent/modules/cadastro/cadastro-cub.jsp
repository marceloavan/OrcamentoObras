<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="edu.asselvi.orcamentoobrasw.utils.SystemUtils"%>
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>

<base:template>
  <jsp:body>
  	<form action="processCub" method="post">
  		<div>
  			<label>Mês</label>
  			<input type="text">
  		</div>
  		<div>
  			<label>Ano</label>
  			<input type="text">
  		</div>
  		<div>
  			<label>Valor</label>
  			<input type="text">
  		</div>
  		<div>
  			<input type="submit" value="Gravar">
  		</div>
  	</form>
  </jsp:body>
</base:template>