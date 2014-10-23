<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>
	
	<script type="text/javascript">
		function showMessage(message) {
			if (message == '') {
				return;
			}
			alert(message);
		}
	</script>
		
	<script type="text/javascript">
		var message = '${pageContext.request.getAttribute("errorMessage")}';
		showMessage(message);
	</script>
	
</body>
</html>