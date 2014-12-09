<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
  	<span class="title_page">
	  	<c:out value="Cadastro de Clientes"></c:out>
	</span>
  		
  	<div class="box-cadastro">
  	
  	<form action="ProdutoController" method="post" onsubmit="return checkInputs([inptCNPJ, inptCPF, inptNome, inptSobrenome, inptRazaoSocial],[CNPJ, CPF, Nome, Sobrenome, Razão Social])">
  	
  		<div class="item-cadastro">
  			<input type="radio" name="tipoPessoa" value="fisica" checked="checked">Física
			<input type="radio" name="tipoPessoa" value="juridica">Jurídica
  		</div>
  			
  		<div class="item-cadastro">
			<label><c:out value="CNPJ"></c:out></label>
  			<input type="text" id="inptCNPJ" name="inptCNPJ" value="${inptCNPJ}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
			<label><c:out value="CPF"></c:out></label>
  			<input type="text" id="inptCPF" name="inptCPF" value="${inptCPF}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
			<label><c:out value="Nome"></c:out></label>
  			<input type="text" id="inptNome" name="inptNome" value="${inptNome}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
			<label><c:out value="Sobrenome"></c:out></label>
  			<input type="text" id="inptSobrenome" name="inptSobrenome" value="${inptSobrenome}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
			<label><c:out value="Razão Social"></c:out></label>
  			<input type="text" id="inptRazaoSocial" name="inptRazaoSocial" value="${inptRazaoSocial}"/> 			
  		</div>
  		
  		<div class="item-cadastro">
			<label><c:out value="Endereco"></c:out></label>
			<select name="cbEndereco">
				<c:forEach items="${enderecoLista}" var="endereco">
					<option value="${endereco.id}"><c:out value="${endereco.logradouro}, ${endereco.numero}, ${endereco.cep}"></c:out></option>
				</c:forEach>
			</select>
  		</div> 
  				  		
  		<!-- Action hidden -->
  		<input type="hidden" name="action" value="${action}">
  		<input type="hidden" name="inptId" value="${inptId}">
  		
  		<div class="button-cadastro"> 
  			<input type="submit" value="Salvar">
  		</div>
  		
  		<div class="button-cadastro">
  			<a href="PessoaController?action=listar">
  				<input type="button" value="Cancelar">
  			</a>
  		</div>
  	</form>	
  	</div>
  		
  </jsp:body>
</base:template>