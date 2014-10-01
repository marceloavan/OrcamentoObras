<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
  
    <div id="orcamentoListaBtn">
      <a href="${pageContext.request.contextPath}/OrcamentoController?action=listar" class="button-modules">
	    <img alt="Listagem de orçamentos" src="${pageContext.request.contextPath}/resources/images/32x32/orcamento.png">
	    <br/><br/>
    	<span><c:out value="Orçamento"></c:out></span>
      </a>
    </div>
  
  </jsp:body>
</base:template>