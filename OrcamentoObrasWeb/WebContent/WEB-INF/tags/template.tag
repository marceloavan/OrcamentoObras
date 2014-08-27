<%@tag description="template" pageEncoding="UTF-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="resources/css/template.css">
  </head>
  <body>
  
    <div id="header">
      <div id="header-inner" class="center">
        <img alt="OrcaObras" 
          src="resources/images/logo.png"
          class="img-header" height="70%">
        <div id="user-loged">
          <span>Usuário logado</span>
        </div>
      </div>
    </div>

    <div id="menu">
      <div id="menu-inner" class="center">
        
      </div>
    </div>
    
    <div id="body-page" class="center">
      <jsp:doBody/>
    </div>

  </body>
</html>