<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript" charset="utf-8">

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

// Verify Form inputs
escola_input.onchange = function () {
    if (escola_input.value != '-') {
        lista_input.disabled = false;
    } else {
        lista_input.disabled = true;
    }
}

lista_input.onchange = function () {
    if (lista_input.value != '-') {
        loja_input.disabled = false;
    } else {
        loja_input.disabled = true;
    }
}

loja_input.onchange = function () {
    if (loja_input.value != '-') {
        valor_input.disabled = false;
    } else {
        valor_input.disabled = true;
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
            <input type="text" id="endereco_escola" placeholder="Rua Marquês de Paranaguá">
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
            <input type="text" id="endereco_loja" placeholder="Rua Marquês de Paranaguá">
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
}

function removeContent() {
    modal_content.innerHTML = '';
}

function listCotacoes() {
    $.get("listCotacao", function (data, status) {
        let li = document.createElement("li");
        li.appendChild(document.createTextNode(data));
        cotacao_lista.appendChild(li);
    });
}

</script>