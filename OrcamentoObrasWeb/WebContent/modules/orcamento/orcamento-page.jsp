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
	
	<br/>
  	<span class="title_page" style="margin-top: 10px">
    	<c:out value="Informações Gerenciais"></c:out>
  	</span>
  	
  </jsp:body>
</base:template>