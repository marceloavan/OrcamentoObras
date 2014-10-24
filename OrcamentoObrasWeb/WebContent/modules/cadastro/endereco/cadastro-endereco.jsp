<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
	<jsp:body>
		
		<span class="title_page">
			<c:out value="Cadastro de Endereços"></c:out>		
		</span>
		
  		<div class="box-cadastro">
  			<div class="item-cadastro">
 				<label><c:out value="Unidade Federativa"></c:out></label>
 				<select>
 					<option>Marcelinho Gay</option>
 				</select>
 			</div>
 			
 			<div class="item-cadastro">
 				<label><c:out value="Município"></c:out></label>
 				<select>
 					<option>Teste</option>
 				</select>
 			</div>
 			
 			<div class="item-cadastro">
 				<label><c:out value="Logradouro"></c:out></label>
 				<input type="text">
 			</div>
 			
 			<div class="item-cadastro">
 				<label><c:out value="Número"></c:out></label>
 				<input type="text">
 			</div>
 			
 			<div class="item-cadastro">
 				<label><c:out value="Bairro"></c:out></label>
 				<input type="text">
 			</div>
 			
 			<div class="item-cadastro">
 				<label><c:out value="CEP"></c:out></label>
 				<input type="text">
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