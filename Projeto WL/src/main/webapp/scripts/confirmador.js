/**
 * Confirmação de exclusao de um dado
 *@author Ronald Almeida Rodriguez
 */
  
  function confirmar (idcon){
	let resposta = confirm ("Confirmar exclusão ?")
	if (resposta === true){
		window.location.href = "delete?idcon=" + idcon
	}
  }