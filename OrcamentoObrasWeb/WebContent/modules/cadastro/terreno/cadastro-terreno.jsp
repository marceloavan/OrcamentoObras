<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
  	<span class="title_page">
	  	<c:out value="Cadastro de Terrenos"></c:out>
	</span>
  		
  	<div class="box-cadastro">
  	
  	<form action="TerrenoController" method="post" onsubmit="return checkInputs([inptMes,inptAno,inptValor],[Mês, Ano, Valor])">
  		<div class="item-cadastro">
  			<label><c:out value="Descrição"></c:out></label>
  			<input type="text" id="inptDescricao" name="inptDescricao" value="${inptDescricao}"/>
  		</div>
  			
  		
  		<div class="item-cadastro">
			<label><c:out value="Endereco"></c:out></label>
			<select name="cbEndereco">
				<c:forEach items="${enderecoLista}" var="endereco">
					<option value="${endereco.id}"><c:out value="${endereco.logradouro}, ${endereco.numero}, ${endereco.cep}"></c:out></option>
				</c:forEach>
			</select>
  		</div> 
  		
  		
  		<div class="item-cadastro">
			<label><c:out value="Metragem"></c:out></label>
  			<input type="text" id="inptMetragem" name="inptMetragem" value="${inptMetragem}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
			<label><c:out value="Valor de Venda"></c:out></label>
  			<input type="text" id="inptValorVenda" name="inptValorVenda" value="${inptValorVenda}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
			<label><c:out value="Valor ITBI"></c:out></label>
  			<input type="text" id="inptValorITBI" name="inptValorITBI" value="${inptValorITBI}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
			<label><c:out value="Valor FRJ"></c:out></label>
  			<input type="text" id="inptValorFRJ" name="inptValorFRJ" value="${inptValorFRJ}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
  			<label><c:out value="Valor Escritura"></c:out></label>
  			<input type="text" id="inptValorEscritura" name="inptValorEscritura" value="${inptValorEscritura}"/>
  		</div>
  		
  		<div class="item-cadastro">
  			<label><c:out value="Valor Registro"></c:out></label>
  			<input type="text" id="inptValorRegistro" name="inptValorRegistro" value="${inptValorRegistro}"/>
  		</div>
  		
  		<!-- Action hidden -->
  		<input type="hidden" name="action" value="${action}">
  		<input type="hidden" name="inptCodigo" value="${inptCodigo}">
  		
  		<div class="button-cadastro"> 
  			<input type="submit" value="Salvar">
  		</div>
  		
  		<div class="button-cadastro">
  			<a href="TerrenoController?action=listar">
  				<input type="button" value="Cancelar">
  			</a>
  		</div>
  	</form>	
  	</div>
  		
  </jsp:body>
</base:template>