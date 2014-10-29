<%@tag import="edu.asselvi.orcamentoobrasw.session.SessionValidator"%>
<%@tag description="template" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/template.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/general.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/utils-orcamento-obras.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/24x24/icon24x24.ico" >
    <title>Orça Obras</title>
    <%
    	String logout = request.getParameter("logout");
    	if (logout != null && logout.equals("1")) {
    		session.invalidate();
    		request.getRequestDispatcher("/modules/login.jsp").forward(request, response);
    		return;
    	}
    	
    	SessionValidator sessionValidator = (SessionValidator) session.getAttribute("sessionValidator");
    	if (sessionValidator == null) {
    		request.setAttribute("errorMessage", "Favor efetuar login");
			request.getRequestDispatcher("/modules/login.jsp").forward(request, response);
    	}
    	if (!sessionValidator.validaSessao()) {
    		request.setAttribute("errorMessage", sessionValidator.getMessage());
			request.getRequestDispatcher("/modules/login.jsp").forward(request, response);
    	}
    %>
  </head>
  <body>
    <div id="header">
      <div id="header-inner" class="center">
        <a href="${pageContext.request.contextPath}">
          <img alt="OrcaObras" 
            src="${pageContext.request.contextPath}/resources/images/logo.png"
            class="img-header" height="70%">
        </a>
        <div id="user-loged">
          <img alt="Cadastro de usuário" height="16" width="16" src="${pageContext.request.contextPath}/resources/images/32x32/user.png">
          <span><%= sessionValidator.getNomeUsuarioLogado() %> </span>
        </div>
      </div>
    </div>

    <div id="menu">
      <div id="menu-inner" class="center">

		<!-- LEFT MENU -->        
        <div id=buttons-menu-left class="group-left">
          <a href="${pageContext.request.contextPath}/modules/cadastro/cadastro-home.jsp" class="button-menu">
            <c:out value="Cadastro"/>
          </a>
          
          <a href="${pageContext.request.contextPath}/modules/orcamento/orcamento-home.jsp" class="button-menu">
            <c:out value="Orçamento"/>
          </a>
          
          <a href="${pageContext.request.contextPath}/modules/administrador/administrador-home.jsp" class="button-menu">
            <c:out value="Administrador"/>
          </a>
        </div>
        
        <!-- RIGHT MENU -->
        <div id=buttons-menu-rigth class="group-rigth">
          <a href="https://www.google.com.br/?#safe=off&q=como+usar+um+sistema+de+gestao+de+obras" target="_blank" class="button-menu button-menu-small">
            <c:out value="Ajuda"/>
          </a>
          
          <a href="${pageContext.request.contextPath}/AuthController?logout=1" class="button-menu button-menu-small">
            <c:out value="Sair"/>
          </a>
        </div>
        
      </div>
    </div>
    
    <div id="body-page" class="center">
      <jsp:doBody/>
    </div>
	
	<jsp:include page="/modules/message.jsp" />
  </body>
</html>