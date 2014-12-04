<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
	<jsp:body>
		<span class="title_page">
	  		<c:out value="Listagem de Terrenos"></c:out>
		</span>	
		<div class="table-listagem-container center">
			<table class="table-listagem">
				<thead>
					<tr>
						<th style="width: 150px">Descrição</th>
						<th style="width: 150px">Metragem</th>
						<th style="width: 150px">Endereço</th>
						<th style="width: 15px" colspan="2">Ações</th>	
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${terrenoLista}" var="terreno">
						<tr>
							<td><c:out value="${terreno.descricao}"/></td>
							<td><c:out value="${terreno.metragem}"/></td>
							<td><c:out value="${terreno.endereco.logradouro}, ${terreno.endereco.numero}"/></td>
							<td>
                				<a href="TerrenoController?action=editar&id=<c:out value="${terreno.codigo}"/>">
                  				<img 
                    			alt="Editar" 
                   				src="${pageContext.request.contextPath}/resources/images/24x24/edit24.png"
                    			class="img-list"
                    				/>
               					 </a>
              				</td>
							<td>
								<a href="TerrenoController?action=deletar&id=<c:out value="${terreno.codigo}"/>" onclick="return confirm('Deseja realmente deletar o terreno?')">
								<img alt="Remover" 
                   					 src="${pageContext.request.contextPath}/resources/images/24x24/delete24.png"
                    					class="img-list"/> 
                    			</a>
							</td>
						</tr>
					</c:forEach>
					<c:if test="${terrenoLista.isEmpty()}">
            			<tr>
             			<td colspan="4">Não foram encontrados registros!</td>
            			</tr>
          			</c:if>
				</tbody>
			</table>
			 <div class="button-cadastro">
        		<a href="TerrenoController?action=cadastrar">
     	  		<input type="button" value="Novo">
       			</a>
	  		</div>
		</div>
	</jsp:body>
</base:template>