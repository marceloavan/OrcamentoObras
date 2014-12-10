<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>  
    
    <span class="title_page">
    	<c:out value="Informações Gerais"></c:out>
  	</span>
	
	<div class="div-half">
	 	<div class="item-cadastro">
		  <label><c:out value="Nome"></c:out></label>
		  <c:out value="${inptNome}"/>
	    </div>
	    
	    <div class="item-cadastro">
		  <label><c:out value="Descrição"></c:out></label>
		  <c:out value="${inptDesc}"/>
	    </div>
	    
	    <div class="item-cadastro">
			<label><c:out value="Cliente"></c:out></label>
			<c:out value="${inptCliente}"/>
  		</div>
  	
  		<div class="item-cadastro">
			<label><c:out value="Terreno"></c:out></label>
			<c:out value="${inptTerreno}"/>
  		</div>
	</div>
	
  	<div class="div-half">
  		<div class="item-cadastro">
			<label><c:out value="CUB"></c:out></label>
			<c:out value="${inptCub}"/>
  		</div>
	    
	    <div class="item-cadastro">
		  <label><c:out value="Metragem construção (m2)"></c:out></label>
		  <c:out value="${inptMetragemConst}"/>
	    </div>
	    
	    <div class="item-cadastro">
		  <label><c:out value="Lucro (%)"></c:out></label>
		  <c:out value="${inptLucro}"/>
	    </div>
  	</div>	
	<div style="clear: both;"/>	 
	
	<!-- #####################################################################################
	     ##################################################################################### -->
	<br/>
  	<span class="title_page" style="margin-top: 10px">
    	<c:out value="Informações Gerenciais"></c:out>
  	</span>
  	
  	<div class="div-half">
  	  <form action="PrevisaoOrcamentoController" method="post" onsubmit="return checkInputs(['inptPrevisao', 'inptValorPrevisao'], ['Previsão', 'Valor'])">
	    
	    <div class="item-cadastro">
		  <label><c:out value="Previsão"></c:out></label>
		  <input type="text" id="inptPrevisao" name="inptPrevisao" value="${inptPrevisao}" style="width: 200px"/>
	    </div>
	  
	    <div class="item-cadastro">
		  <label><c:out value="Valor"></c:out></label>
		  <input type="text" id="inptValorPrevisao" name="inptValorPrevisao" value="${inptValor}" style="width: 200px"/>
	    </div>
	  
	    <!-- Action hidden -->
	    <input type="hidden" name="action" value="${action}"/>
	    <input type="hidden" name="orcamentoId" value="${orcamentoId}"/>
	    
	    <div class="button-cadastro" style="margin-right: 55px">
	      <input type="submit" value="Incluir">
	    </div>
	  </form>
  	
  	<br/>
  	<br/>
  	<br/>
  	<table class="table-listagem">
        <thead>
          <tr>
            <th style="width: 201px">Previsão</th>
            <th style="width: 201px">Valor</th>
	          </tr>
        </thead>
        <tbody>
          <c:forEach items="${previsaoOrcamentoLista}" var="previsaoOrcamento">
            <tr>
              <td><c:out value="${previsaoOrcamento.previsao.descricao}" /></td>
              <td><c:out value="${previsaoOrcamento.valor}" /></td>
            </tr>
          </c:forEach>
          <c:if test="${previsaoOrcamentoLista.isEmpty()}">
            <tr>
              <td colspan="3">Não foram encontrados registros!</td>
            </tr>
          </c:if>
        </tbody>
      </table>
  	</div>
  	
  	<div class="div-half">
  		<div class="item-cadastro">
		  <label><c:out value="Valor Venda Cub"></c:out></label>
		  <c:out value="${inptValorVendaCub}"/>
	    </div>
	    <div class="item-cadastro">
		  <label><c:out value="Valor Venda Previsão/Lucro"></c:out></label>
		  <c:out value="${inptValorVendaPrevisao}"/>
	    </div>				
  	</div>
  	
  </jsp:body>
</base:template>