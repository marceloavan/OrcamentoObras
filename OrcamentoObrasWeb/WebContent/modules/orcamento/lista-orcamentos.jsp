<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
  <span class="title_page">
    <c:out value="Listagem de Orçamentos"></c:out>
  </span>
  <div class="table-listagem-container center">
	  <table class="table-listagem">
        <thead>
          <tr>
            <th style="width: 200px">Nome</th>
            <th style="width: 200px">Terreno</th>
            <th style="width: 125px">Metragem</th>
            <th style="width: 125px">Lucro desejado</th>
            <th style="width: 15px" colspan=2>Ações</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${orcamentosLista}" var="orcamento">
            <tr>
              <td><c:out value="${orcamento.nome}" /></td>
              <td><c:out value="${orcamento.terreno.descricao}" /></td>
              <td style="text-align: right"><c:out value="${orcamento.metragemConstrucao} m2" /></td>
              <td style="text-align: right"><c:out value="${orcamento.percentualLucro}%" /></td>
              <td>
                <a href="UsuarioController?action=editar&userName=<c:out value="${usuario.userName}"/>">
                  <img 
                    alt="Editar" 
                    src="${pageContext.request.contextPath}/resources/images/24x24/edit24.png"
                    class="img-list"
                    />
                </a>
              </td>
              <td>
                <a href="UsuarioController?action=deletar&userName=<c:out value="${orcamento.id}"/>" onclick="return confirm('Deseja realmente deletar o orçamento?')">
                  <img 
                    alt="Remover" 
                    src="${pageContext.request.contextPath}/resources/images/24x24/delete24.png"
                    class="img-list"
                    />
                </a>
              </td>
            </tr>
          </c:forEach>
          <c:if test="${orcamentosLista.isEmpty()}">
            <tr>
              <td colspan="4">Não foram encontrados registros!</td>
            </tr>
          </c:if>
        </tbody>
      </table>
	</div>  
  </jsp:body>
</base:template>