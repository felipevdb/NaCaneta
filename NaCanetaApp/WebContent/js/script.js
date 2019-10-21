// Get the modal
var modal = document.getElementById("myModal");
var modal_content = document.getElementById("modal_content");
var add_escola = document.getElementById("add_escola");
var add_lista = document.getElementById("add_lista");
var add_loja = document.getElementById("add_loja");

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
				<div class="formButtons">
					<button type="submit">limpar</button>
					<button type="submit">salvar</button>
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
				<label for="nome_escola"><b>Nome</b></label>
				<input type="text" id="nome_escola" placeholder="PUC SP">
				<div class="formButtons">
					<button type="submit">limpar</button>
					<button type="submit">salvar</button>
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
				<label for="nome_escola"><b>Nome</b></label>
				<input type="text" id="nome_escola" placeholder="PUC SP">
				<div class="formButtons">
					<button type="submit">limpar</button>
					<button type="submit">salvar</button>
				</div>
			</div>
		</form>
    `;
    document.getElementById('modal_content').appendChild(div);
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