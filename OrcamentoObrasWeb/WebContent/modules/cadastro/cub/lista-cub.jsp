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
			<table class="table-listagem-container center">
				<thead>
					<tr>
						<th style="width: 150px">Mês</th>
						<th style="width: 150px">Ano</th>
						<th style="width: 150px">Valor</th>
						<th style="width: 15px" colspan="2">Ações</th>
					</tr>
				</thead>
			</table>
		</div>
	</jsp:body>
</base:template>
