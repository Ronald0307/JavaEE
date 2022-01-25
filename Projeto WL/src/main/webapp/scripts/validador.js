/**
 * Validação de formulário
 *@author Ronald Almeida Rodrigues
 */
function validar() {
	let nome = frmpessoas.nome.value
	let cpf = frmpessoas.cpf.value
	let item = frmpessoas.item.value
	if (nome === "") {
		alert('Preencha o campo Nome!')
		frmpessoas.nome.focus()
		return false
	} else if (cpf === "") {
		alert('Preencha o campo CPF!')
		frmpessoas.cpf.focus()
		return false
	} else if (item === "") {
		alert('Preencha o campo Item!')
		frmpessoas.item.focus()
		return false
	}
	else {
		document.forms["frmpessoas"].submit()
	}
}