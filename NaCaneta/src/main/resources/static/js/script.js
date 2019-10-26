// Get the modal
var modal = document.getElementById("form_modal");
var modal_content = document.getElementById("content_modal");
var modal_close = document.getElementById("close_modal");
var add_escola = document.getElementById("add_escola");
var add_lista = document.getElementById("add_lista");
var add_loja = document.getElementById("add_loja");

// Get form inputs
var escola_input = document.getElementById("escola");
var lista_input = document.getElementById("listaMaterial");
var loja_input = document.getElementById("loja");
var valor_input = document.getElementById("valor");
var submit_btn = document.getElementById("submit_btn");

// Get form data
var list_cotacoes = document.getElementById("list_cotacoes");
var list_escolas = document.getElementById("escola");
var list_material = document.getElementById("listaMaterial");
var list_lojas = document.getElementById("loja");

// Verify Form inputs
escola_input.onchange = function () {
    if (escola_input.value != '-') {
        lista_input.disabled = false;
        listListasMaterialbyEscola(escola_input.value);
    } else {
    	lista_input.disabled = true;
    	lista_input.value = '-';
    	loja_input.disabled = true;
    	loja_input.value = '-';
    	valor_input.disabled = true;
        submit_btn.disabled = true
    }
}

lista_input.onchange = function () {
    if (lista_input.value != '-') {
        loja_input.disabled = false;
    } else {
        loja_input.disabled = true;
        submit_btn.disabled = true;
        loja_input.value = '-';
        valor_input.disabled = true;
    }
}

loja_input.onchange = function () {
    if (loja_input.value != '-') {
        valor_input.disabled = false;
        submit_btn.disabled = false;
    } else {
        valor_input.disabled = true;
        submit_btn.disabled = true
    }
}

// When the user clicks on <span> (x), close the modal
modal_close.onclick = function () {
    modal.style.display = "none";
}

// Load the content
add_escola.onclick = function () {
    generateForm(`
    <h1>Registrar Escola</h1>
    <form class="main_form">
        <div class="form_inputs">
            <label for="nome_escola"><b>Nome</b></label>
            <input type="text" id="nome_escola" placeholder="PUC SP">
            <label for="endereco_escola"><b>Endereço</b></label>
            <input type="text" id="endereco_escola" placeholder="Rua MarquÃªs de ParanaguÃ¡">
            <label for="telefone_escola"><b>Telefone</b></label>
            <input type="text" id="nome_escola" placeholder="+55(11)1234-5678">
            <div class="form_buttons">
                <button style="background-color: #65ABA3;" type="button" onclick="cleanForm(this)"><span>limpar</span></button>
                <button style="background-color: #65ABA3;" type="submit"><span>salvar</span></button>
            </div>
        </div>
    </form>
`);
}

add_lista.onclick = function () {
    generateForm(`
    <h1 class="tituloPrincipal">Registrar Lista</h1>
    <form class="main_form">
        <div class="form_inputs">
            <label for="nome_escola"><b>Escola</b></label>
            <input type="text" id="nome_escola" placeholder="PUC SP">
            <label for="nome_escola"><b>Série</b></label>
            <input type="text" id="nome_escola" placeholder="PUC SP">
            <label for="nome_escola"><b>Ano</b></label>
            <input type="text" id="nome_escola" placeholder="PUC SP">
            <label for="nome_escola"><b>Items</b></label>
            <input type="text" id="nome_escola" placeholder="PUC SP">
            <div class="form_buttons">
                <button style="background-color: #65ABA3;" type="button" onclick="cleanForm(this)"><span>limpar</span></button>
                <button style="background-color: #65ABA3;" type="submit"><span>salvar</span></button>
            </div>
        </div>
    </form>
`);
}

add_loja.onclick = function () {
    generateForm(`
    <h1 class="tituloPrincipal">Registrar Loja/Papelaria</h1>
    <form class="main_form">
        <div class="form_inputs">
            <label for="nome_loja"><b>Nome</b></label>
            <input type="text" id="nome_loja" placeholder="Papelaria PUC SP">
            <label for="endereco_loja"><b>Endereço</b></label>
            <input type="text" id="endereco_loja" placeholder="Rua Marquês de ParanaguÃ¡">
            <label for="telefone_loja"><b>Telefone</b></label>
            <input type="text" id="telefone_loja" placeholder="+55(11)1234-5678">
            <div class="form_buttons">
                <button style="background-color: #65ABA3;" type="button" onclick="cleanForm(this)"><span>limpar</span></button>
                <button style="background-color: #65ABA3;" type="submit"><span>salvar</span></button>
            </div>
        </div>
    </form>
`);
}

function generateForm(form) {
    removeContent();
    modal.style.display = "block";
    let div = document.createElement('div');
    div.id = 'new_form';
    div.innerHTML = form;
    modal_content.appendChild(div);
}

function cleanForm(element) {
    element.parentElement.parentElement.parentElement.reset();
    escola_input.value = '-';
    lista_input.disabled = true;
	loja_input.disabled = true;
	valor_input.disabled = true;
    submit_btn.disabled = true
}

function removeContent() {
    modal_content.innerHTML = '';
}

function checkSubmit() {
	if (escola_input.value != '-' && lista_input.value != '-' && loja_input.value != '-'){
		submit_btn.disabled = false;
	}
}

function listCotacoes() {
    $.get("listCotacoes", function (data, status) {
    	cleanCotacoes();
    	data = JSON.parse(data);
    	data.forEach(function (item, index) {
    		let li = document.createElement("li");
    		li.className = "dropdown"
    		let span = document.createElement("span");
    		span.appendChild(document.createTextNode("Cotação #" + parseInt(index+1) + " = R$" + item["valor"]));
    		li.appendChild(span);
    		let div = document.createElement("div");
    		div.className = "dropdown-content";
    		let escola = document.createElement("p");
    		let lista = document.createElement("p");
    		let loja = document.createElement("p");
    		escola.appendChild(document.createTextNode("Escola: "+item["escola"]));
    		lista.appendChild(document.createTextNode("Lista: "+item["lista"]));
    		loja.appendChild(document.createTextNode("Loja: "+item["loja"]));
    		div.appendChild(escola);
    		div.appendChild(lista);
    		div.appendChild(loja);
    		li.appendChild(div);
            list_cotacoes.appendChild(li);
    	});
    });
}

function cleanCotacoes() {
	list_cotacoes.innerHTML = '';
}

function listEscolas() {
    $.get("listEscolas", function (data, status) {
    	cleanEscolas();
    	data = JSON.parse(data);
    	data.forEach(function (item, index) {
    		let option = document.createElement("option");
    		option.value = item['id'];
            option.appendChild(document.createTextNode(item['nome']));
            list_escolas.appendChild(option);
    	});
    });
}

function cleanEscolas() {
	list_escolas.innerHTML = '';
	let option = document.createElement("option");
	option.value = '-';
    option.appendChild(document.createTextNode('escola'));
    list_escolas.appendChild(option);
}

function listListasMaterialbyEscola(escola) {
	$.ajax({
		  url: "listListasMaterialbyEscola",
		  type: "get",
		  data: { 
		    escola: escola
		  },
		  success: function(data) {
			cleanListasMaterial();
			data = JSON.parse(data);
			data.forEach(function (item, index) {
				let option = document.createElement("option");
				option.value = item['id'];
			    option.appendChild(document.createTextNode(item['nome']));
			    list_material.appendChild(option);
			});
		  },
		  error: function(error) {
			  console.log(error);
		  }
		});
}

function cleanListasMaterial() {
	list_material.innerHTML = '';
	let option = document.createElement("option");
	option.value = '-';
    option.appendChild(document.createTextNode('lista'));
    list_material.appendChild(option);
}

function listLojas() {
    $.get("listLojas", function (data, status) {
    	cleanLojas();
    	data = JSON.parse(data);
    	data.forEach(function (item, index) {
    		let option = document.createElement("option");
    		option.value = item['id'];
            option.appendChild(document.createTextNode(item['nome']));
            list_lojas.appendChild(option);
    	});
    });
}

function cleanLojas() {
	list_lojas.innerHTML = '';
	let option = document.createElement("option");
	option.value = '-';
    option.appendChild(document.createTextNode('loja'));
    list_lojas.appendChild(option);
}

$(document).ready(function(){
	listCotacoes();
	listEscolas();
	listLojas();
});