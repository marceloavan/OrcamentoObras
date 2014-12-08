<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="base" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<base:template>
	<jsp:body>
		<span class="title_page">
	  		<c:out value="Listagem de Produtos"></c:out>
		</span>	
		<div class="table-listagem-container center">
			<table class="table-listagem">
				<thead>
					<tr>
						<th style="width: 150px">Código</th>
						<th style="width: 150px">Descrição</th>
						<th style="width: 15px" colspan="2">Ações</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtoLista}" var="produto">
						<tr>
							<td><c:out value="${produto.codigo}"/></td>
							<td><c:out value="${produto.descricao}"/></td>
							<td>
                				<a href="ProdutoController?action=editar&id=<c:out value="${produto.codigo}"/>">
                  				<img 
                    			alt="Editar" 
                   				src="${pageContext.request.contextPath}/resources/images/24x24/edit24.png"
                    			class="img-list"
                    				/>
               					 </a>
              				</td>
							<td>
								<a href="ProdutoController?action=deletar&id=<c:out value="${produto.codigo}"/>" onclick="return confirm('Deseja realmente deletar o produto?')">
								<img alt="Remover" 
                   					 src="${pageContext.request.contextPath}/resources/images/24x24/delete24.png"
                    					class="img-list"/> 
                    			</a>
							</td>
						</tr>
					</c:forEach>
					<c:if test="${produtoLista.isEmpty()}">
            			<tr>
             			<td colspan="4">Não foram encontrados registros!</td>
            			</tr>
          			</c:if>
				</tbody>
			</table>
			 <div class="button-cadastro">
        		<a href="ProdutoController?action=cadastrar">
     	  		<input type="button" value="Novo">
       			</a>
	  		</div>
		</div>
	</jsp:body>
</base:template>