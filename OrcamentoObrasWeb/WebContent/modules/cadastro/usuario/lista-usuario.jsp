<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
  <jsp:body>
    <span class="title_page">
	  <c:out value="Listagem de usuário"></c:out>
	</span>
	<div class="table-listagem-container center">
	  <table class="table-listagem">
        <thead>
          <tr>
            <th width="150px">Login</th>
            <th width="300px">Nome do usuário</th>
            <th width="15px" colspan=2>Ações</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${usuariosLista}" var="usuario">
            <tr>
              <td><c:out value="${usuario.userName}" /></td>
              <td><c:out value="${usuario.nomeCompleto}" /></td>
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
                <a href="UsuarioController?action=deletar&userName=<c:out value="${usuario.userName}"/>">
                  <img 
                    alt="Remover" 
                    src="${pageContext.request.contextPath}/resources/images/24x24/delete24.png"
                    class="img-list"
                    />
                </a>
              </td>
            </tr>
          </c:forEach>
          <c:if test="${usuariosLista.isEmpty()}">
            <tr>
              <td colspan="4">Não foram encontrados registros!</td>
            </tr>
          </c:if>
        </tbody>
      </table>
      <div class="button-cadastro">
	    <input type="button" value="Novo">
	  </div>
	</div>
  </jsp:body>
</base:template>