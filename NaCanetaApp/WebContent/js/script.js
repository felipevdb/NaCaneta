// Get the modal
var modal = document.getElementById("myModal");
var modal_content = document.getElementById("modal_content");
var add_escola = document.getElementById("add_escola");
var add_lista = document.getElementById("add_lista");
var add_loja = document.getElementById("add_loja");

// Get form inputs
var escola_input = document.getElementById("escola");
var lista_input = document.getElementById("listaMaterial");
var loja_input = document.getElementById("loja");
var valor_input = document.getElementById("valor");


// Verify Form inputs
escola_input.onchange = function() {
	if(escola_input.value != '-'){
		lista_input.disabled = false;
	} else {
		lista_input.disabled = true;
	}
}

lista_input.onchange = function() {
	if(lista_input.value != '-'){
		loja_input.disabled = false;
		valor_input.disabled = false;
	} else {
		loja_input.disabled = true;
		valor_input.disabled = true;
	}
}

// Load the content
add_escola.onclick = function() {
	removeContent();
	modal.style.display = "block";
    let div = document.createElement('div');
    div.id = 'new_form';
    div.innerHTML = `
	    <h1 class="tituloPrincipal">Registrar Escola</h1>
	    <form class="myForm">
			<div class="inputs">
				<label for="nome_escola"><b>Nome</b></label>
				<input type="text" id="nome_escola" placeholder="PUC SP">
				<label for="endereco_escola"><b>Endereço</b></label>
				<input type="text" id="endereco_escola" placeholder="Rua Marquês de Paranaguá">
				<label for="telefone_escola"><b>Telefone</b></label>
				<input type="text" id="nome_escola" placeholder="+55(11)1234-5678">
				<div class="formButtons">
					<button class="newButton" type="button" onclick="cleanForm(this)">limpar</button>
					<button class="newButton" type="submit">salvar</button>
				</div>
			</div>
		</form>
    `;
    document.getElementById('modal_content').appendChild(div);
}

add_lista.onclick = function() {
	removeContent();
	modal.style.display = "block";
    let div = document.createElement('div');
    div.id = 'new_form';
    div.innerHTML = `
	    <h1 class="tituloPrincipal">Registrar Lista</h1>
	    <form class="myForm">
			<div class="inputs">
				<label for="nome_escola"><b>Escola</b></label>
				<input type="text" id="nome_escola" placeholder="PUC SP">
				<label for="nome_escola"><b>Série</b></label>
				<input type="text" id="nome_escola" placeholder="PUC SP">
				<label for="nome_escola"><b>Ano</b></label>
				<input type="text" id="nome_escola" placeholder="PUC SP">
				<label for="nome_escola"><b>Items</b></label>
				<input type="text" id="nome_escola" placeholder="PUC SP">
				<div class="formButtons">
					<button class="newButton" type="button" onclick="cleanForm(this)">limpar</button>
					<button class="newButton" type="submit">salvar</button>
				</div>
			</div>
		</form>
    `;
    document.getElementById('modal_content').appendChild(div);
}

add_loja.onclick = function() {
	removeContent();
	modal.style.display = "block";
    let div = document.createElement('div');
    div.id = 'new_form';
    div.innerHTML = `
	    <h1 class="tituloPrincipal">Registrar Loja/Papelaria</h1>
	    <form class="myForm">
			<div class="inputs">
				<label for="nome_loja"><b>Nome</b></label>
				<input type="text" id="nome_loja" placeholder="Papelaria PUC SP">
				<label for="endereco_loja"><b>Endereço</b></label>
				<input type="text" id="endereco_loja" placeholder="Rua Marquês de Paranaguá">
				<label for="telefone_loja"><b>Telefone</b></label>
				<input type="text" id="telefone_loja" placeholder="+55(11)1234-5678">
				<div class="formButtons">
					<button class="newButton" type="button" onclick="cleanForm(this)">limpar</button>
					<button class="newButton" type="submit">salvar</button>
				</div>
			</div>
		</form>
    `;
    document.getElementById('modal_content').appendChild(div);
}

function cleanForm(element){
	element.parentElement.parentElement.parentElement.reset();
}

function removeContent() {
	content = document.getElementById('modal_content');
	content.innerHTML = '';
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
	modal.style.display = "none";
}
