/* Funções uteis em javascript */
function checkInputs(ids, names) {
	for (i=0;i<ids.length;i++) {
		var element = document.getElementById(ids[i]);
		if (element.value == '' || element.value == null) {
			showError('Campo obrigatório não informado: ' + (names[i] != null ? names[i] : ids[i]));
			return false;
		}
	}
	return true;
}

function showError(message) {
	alert(message);
}