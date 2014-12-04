<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
	<jsp:body>
		<span class="title_page">
	  		<c:out value="Listagem de Custo Básico Mensais"></c:out>
		</span>	
		<div class="table-listagem-container center">
			<table class="table-listagem">
				<thead>
					<tr>
						<th style="width: 150px">Mês</th>
						<th style="width: 150px">Ano</th>
						<th style="width: 150px">Valor</th>
						<th style="width: 15px" colspan="2">Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cubLista}" var="cub">
						<tr>
							<td><c:out value="${cub.mes}"/></td>
							<td><c:out value="${cub.ano}"/></td>
							<td><c:out value="${cub.valorMetroQuadrado}"/></td>
							<td>
                				<a href="CustoUnitarioBasicoController?action=editar&id=<c:out value="${cub.id}"/>">
                  				<img 
                    			alt="Editar" 
                   				src="${pageContext.request.contextPath}/resources/images/24x24/edit24.png"
                    			class="img-list"
                    				/>
               					 </a>
              				</td>
							<td>
								<a href="CustoUnitarioBasicoController?action=deletar&id=<c:out value="${cub.id}"/>" onclick="return confirm('Deseja realmente deletar o custo unitário básico?')">
								<img alt="Remover" 
                   					 src="${pageContext.request.contextPath}/resources/images/24x24/delete24.png"
                    					class="img-list"/> 
                    			</a>
							</td>
						</tr>
					</c:forEach>
					<c:if test="${cubLista.isEmpty()}">
            			<tr>
             			<td colspan="4">Não foram encontrados registros!</td>
            			</tr>
          			</c:if>
				</tbody>
			</table>
			 <div class="button-cadastro">
        		<a href="CustoUnitarioBasicoController?action=cadastrar">
     	  		<input type="button" value="Novo">
       			</a>
	  		</div>
		</div>
	</jsp:body>
</base:template>
