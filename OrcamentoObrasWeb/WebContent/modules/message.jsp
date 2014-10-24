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
		
		function getMessages() {
			var messageList = [];
			messageList.push('${pageContext.request.getAttribute("errorMessage")}');
			messageList.push('${pageContext.request.getAttribute("infoMessage")}');
			return messageList;
		}
	</script>
		
	<script type="text/javascript">
		var messageList = getMessages();
		var message = '';
		
		for (var idx = 0; idx < messageList.length; idx++) {
			var text = messageList[idx];
			if (text != null && text != '') {
				if (message == '') {
					message = message + '- ';
				} else {
					message = message + '\n- ';
				}
				message = message + text;
			}
		}
		
		showMessage(message);
	</script>
	
</body>
</html>